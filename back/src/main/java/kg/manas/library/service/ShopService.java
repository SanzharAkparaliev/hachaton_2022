package kg.manas.library.service;

import kg.manas.library.model.ShopModel;

import java.util.List;

public interface ShopService {
    ShopModel save(ShopModel shop);

    ShopModel get(Long id);

    List<ShopModel> getAll();
}
