package com.hauptkern.dbeaver_credrecov.utils;

public class CredentialModel {
    public String ConnectionName;
    public String User;
    public String Password;

    public String getConnectionName() {
        return ConnectionName;
    }

    public void setConnectionName(String connectionName) {
        this.ConnectionName = connectionName;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public CredentialModel(String cName, String user, String password) {
        ConnectionName = cName;
        User = user;
        Password = password;
    }
}
