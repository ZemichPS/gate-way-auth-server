package by.zemich.authserver.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "users")
public class UserEntity {
    @Id
    private UUID uuid;
    private String name;
    private String login;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role{
        USER, ADMIN, SELLER;
    }
    public UserEntity() {
    }

    public UserEntity(UUID uuid, String name, String login, String password, Role role) {
        this.uuid = uuid;
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(uuid, that.uuid)
                && Objects.equals(name, that.name)
                && Objects.equals(login, that.login)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, login, password);
    }
}
