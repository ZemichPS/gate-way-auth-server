package by.zemich.authserver.service.impl;

import by.zemich.authserver.core.UserCreateDto;
import by.zemich.authserver.dao.entity.UserEntity;
import by.zemich.authserver.dao.repo.UserRepository;
import by.zemich.authserver.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public UserEntity save(UserCreateDto userDto) {

        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setUuid(UUID.randomUUID());
        newUserEntity.setLogin(userDto.getLogin());
        newUserEntity.setName(userDto.getName());
        newUserEntity.setPassword(userDto.getPassword());

        return userRepository.save(newUserEntity);
    }

    @Override
    public UserEntity getByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(()-> new UsernameNotFoundException(login));
    }

    @Override
    public List<UserEntity> getAll() {
        List<UserEntity> userEntities = new ArrayList<>();

        for (UserEntity user : userRepository.findAll()) {
            userEntities.add(user);
        }
        return userEntities;
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
