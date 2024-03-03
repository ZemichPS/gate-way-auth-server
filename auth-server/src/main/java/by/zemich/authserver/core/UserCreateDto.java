package by.zemich.authserver.core;

public class UserCreateDto {
    private String name;
    private String login;
    private String password;

    public UserCreateDto(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public UserCreateDto() {
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
