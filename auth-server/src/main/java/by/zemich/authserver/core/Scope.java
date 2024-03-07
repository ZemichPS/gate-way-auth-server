package by.zemich.authserver.core;

public enum Scope {
    READ_SECRET("readSecret"), WRITE_SECRET("writeSecret");

    private String scope;

    Scope(String scope){
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }
}
