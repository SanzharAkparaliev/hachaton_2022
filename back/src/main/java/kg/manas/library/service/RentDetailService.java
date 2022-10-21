package kg.manas.library.service;

import kg.manas.library.model.RentDetailModel;

import java.util.List;

public interface RentDetailService {
    RentDetailModel save(RentDetailModel rentDetailModel);
    List<RentDetailModel> getAllByRentId(Long id);
    List<RentDetailModel> getAll();
}
