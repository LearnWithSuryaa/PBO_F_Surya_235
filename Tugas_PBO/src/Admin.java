public class Admin {
    private String username;
    private String password;

    // Constructor untuk inisialisasi username dan password
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Metode untuk login (validasi username & password sekaligus)
    public boolean validateLogin(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Getter untuk username (tidak ada setter karena username sebaiknya tetap)
    public String getUsername() {
        return username;
    }

    // Getter & Setter untuk password (bisa diubah jika perlu)
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}
