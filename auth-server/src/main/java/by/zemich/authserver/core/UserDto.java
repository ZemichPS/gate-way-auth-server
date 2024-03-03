package by.zemich.authserver.core;

import java.util.UUID;

public class UserDto {
    private UUID uuid;
    private String name;
    private String login;
    private String password;

    public UserDto(UUID uuid, String name, String login, String password) {
        this.uuid = uuid;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public UserDto() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
