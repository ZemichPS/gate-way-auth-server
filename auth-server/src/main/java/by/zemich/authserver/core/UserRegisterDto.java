package by.zemich.authserver.core;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserRegisterDto {

    private long id;
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private char[] password;

    public UserRegisterDto(long id, String login, String token, char[] password) {
        this.id = id;
        this.login = login;
        this.token = token;
        this.password = password;
    }

    public UserRegisterDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
