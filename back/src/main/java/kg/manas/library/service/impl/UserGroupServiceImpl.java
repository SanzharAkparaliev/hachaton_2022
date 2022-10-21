package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.entity.UserGroup;
import kg.manas.library.model.UserGroupModel;
import kg.manas.library.repository.GroupRepository;
import kg.manas.library.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserGroupServiceImpl implements UserGroupService {

    private GroupRepository groupRepository;
    @Override
    public UserGroupModel get(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User Group by id:" + id + "cannot be forund")).toModel();
    }

    @Override
    public UserGroupModel save(UserGroupModel userGroupModel) {
        UserGroup userGroup = userGroupModel.getId() == null ? new UserGroup() : groupRepository.getById(userGroupModel.getId());
        userGroup.setDescription(userGroupModel.getDescription());
        userGroup.setName(userGroupModel.getName());
        return  groupRepository.save(userGroup).toModel();
    }

    @Override
    public List<UserGroupModel> getAll() {
        return groupRepository.findAll().stream().map(UserGroup::toModel).collect(Collectors.toList());
    }
}
