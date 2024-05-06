package bean;

public class RegInfo {
    private String username;
    private String password;

    // Конструктор
    public RegInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Геттеры
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

