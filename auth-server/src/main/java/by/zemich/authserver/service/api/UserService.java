package by.zemich.authserver.service.api;

import by.zemich.authserver.core.UserCreateDto;
import by.zemich.authserver.core.UserDto;
import by.zemich.authserver.dao.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity save(UserCreateDto userDto);
    UserEntity getByLogin(String login);
    List<UserEntity> getAll();

}
