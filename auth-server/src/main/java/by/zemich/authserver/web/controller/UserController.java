package by.zemich.authserver.web.controller;

import by.zemich.authserver.core.UserCreateDto;
import by.zemich.authserver.core.UserDto;
import by.zemich.authserver.dao.entity.UserEntity;
import by.zemich.authserver.service.api.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserDto> save(@RequestBody UserCreateDto userCreateDto){
        UserEntity savedEntity = userService.save(userCreateDto);
        UserDto user = new UserDto();
        user.setLogin(savedEntity.getLogin());
        user.setName(savedEntity.getName());
        user.setPassword(savedEntity.getPassword());
        user.setUuid(savedEntity.getUuid());

        return ResponseEntity.ok(user);

    }
    @GetMapping("/by_login")
    public ResponseEntity<UserDto> getByLogin(@RequestParam String login){
        UserEntity entity = userService.getByLogin(login);
        UserDto user = new UserDto();
        user.setLogin(entity.getLogin());
        user.setName(entity.getName());
        user.setPassword(entity.getPassword());
        user.setUuid(entity.getUuid());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userDtos = userService.getAll().stream()
                .map(entity -> {
                    UserDto user = new UserDto();
                    user.setLogin(entity.getLogin());
                    user.setName(entity.getName());
                    user.setPassword(entity.getPassword());
                    user.setUuid(entity.getUuid());
                    return user;
                }).toList();
        return ResponseEntity.ok(userDtos);
    }

}
