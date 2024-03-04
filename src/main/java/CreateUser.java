import org.apache.commons.lang3.RandomStringUtils;
public class CreateUser {
    private  String email;
    private  String password;
    private  String name;
    public CreateUser(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public static CreateUser getDataUser(int countSymbolsPassword) {
        final String name = RandomStringUtils.randomAlphabetic(7);
        final String email = RandomStringUtils.randomAlphabetic(7) + "@mail.ru";
        final String password = RandomStringUtils.randomAlphabetic(countSymbolsPassword);
        return new CreateUser(email, password, name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
