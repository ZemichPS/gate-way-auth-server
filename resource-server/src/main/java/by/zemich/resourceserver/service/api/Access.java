package by.zemich.resourceserver.service.api;

public interface Access {
    default String getSecretCode() {
        return "super secret code";
    }
}
