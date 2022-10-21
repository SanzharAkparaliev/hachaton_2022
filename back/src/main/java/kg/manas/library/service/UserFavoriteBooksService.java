package kg.manas.library.service;

import kg.manas.library.model.UserFavoriteBooksModel;

import java.util.List;

public interface UserFavoriteBooksService {
    UserFavoriteBooksModel get(Long id);
    UserFavoriteBooksModel save(UserFavoriteBooksModel userFavoriteBooksModelModel);
    List<UserFavoriteBooksModel> getAll();
}
