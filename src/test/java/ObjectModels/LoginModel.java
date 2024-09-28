package ObjectModels;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
    private AccountModel account;
    private String loginErr;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String loginErr) {
        this.account = new AccountModel(username, password);
        this.loginErr = loginErr;
    }

    public AccountModel getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getLoginErr() {
        return loginErr;
    }

    @XmlElement
    public void setLoginErr(String loginErr) {
        this.loginErr = loginErr;
    }

    @Override
    public String toString() {
        return "LoginModel value: {\n" +
                "account:{\nusername" + account.getUsername() + ",\n password=" + account.getPassword() +
                "\n}, \n loginErr='" + loginErr + '\n' +
                '}';
    }
}
