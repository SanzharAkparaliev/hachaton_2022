package kg.manas.library.service.impl;

import kg.manas.library.entity.Rent;
import kg.manas.library.entity.User;
import kg.manas.library.model.RentDetailModel;
import kg.manas.library.model.RentModel;
import kg.manas.library.repository.RentRepository;
import kg.manas.library.repository.UserRepository;
import kg.manas.library.service.RentDetailService;
import kg.manas.library.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final UserRepository userRepository;
    private final RentDetailService rentDetailService;

    @Override
    public RentModel get(Long id) {
        RentModel rentModel = rentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Rent by id: " + id + " cannot be found !")).toModel();
        rentModel.setRentDetailModels(rentDetailService.getAllByRentId(id));
        return rentModel;
    }

    @Override
    public RentModel save(RentModel rentModel) {
        Rent rent = rentModel.getId() != null ? rentRepository.findById(rentModel.getId())
                .orElseThrow(() -> new NoSuchElementException("Rent by id: " + rentModel.getId() + " cannot be found !")) :
                new Rent();
        User user = userRepository.findById(rentModel.getUserModel().getId()).orElseThrow(() -> new NoSuchElementException("User cannot be found !"));
        Double totalSum = 0.0;
        rent.setDateOfRent(rentModel.getDateOfRent());
        rent.setDuration(rentModel.getDuration());
        rent.setTotalSum(rentModel.getTotalSum());
        rent.setNote(rentModel.getNote());
        rent.setUser(user);
        Rent savedRent = rentRepository.save(rent);
        List<RentDetailModel> rentDetailModels = rentModel.getRentDetailModels();
        for (RentDetailModel rentDetailModel : rentDetailModels ) {
            rentDetailModel.setRentId(savedRent.getId());
            rentDetailService.save(rentDetailModel);
            totalSum += rentDetailModel.getProductModel().getPrice() * rentDetailModel.getAmount();
        }
        savedRent.setTotalSum(totalSum);
        return rentRepository.save(savedRent).toModel();
    }

    @Override
    public List<RentModel> getAll() {
        return rentRepository.findAll().stream().map(rent -> {
            RentModel rentModel = rent.toModel();
            rentModel.setRentDetailModels(rentDetailService.getAllByRentId(rent.getId()));
            return rentModel;
        }).collect(Collectors.toList());
    }


}
