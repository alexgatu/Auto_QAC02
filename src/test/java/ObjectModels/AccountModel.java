package ObjectModels;

import jakarta.xml.bind.annotation.XmlElement;

public class AccountModel {
    private String username;
    private String password;

    public AccountModel() {
    }

    public AccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}
