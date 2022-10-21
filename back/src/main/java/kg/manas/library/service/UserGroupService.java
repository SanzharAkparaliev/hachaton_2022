package kg.manas.library.service;

import kg.manas.library.model.BookCategoryModel;
import kg.manas.library.model.UserGroupModel;

import java.util.List;

public interface UserGroupService {
    UserGroupModel get(Long id);

    UserGroupModel save(UserGroupModel userGroupModel);

    List<UserGroupModel> getAll();

}
