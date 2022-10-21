package kg.manas.library.service;

import kg.manas.library.model.RentModel;

import java.util.List;

public interface RentService {
    RentModel get(Long id);

    RentModel save(RentModel rent);

    List<RentModel> getAll();

}
