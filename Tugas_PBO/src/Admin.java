public class Admin {
    private final String username = "Admin235";
    private final String password = "Password235";

    // Metode untuk memeriksa login Admin
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    // Metode untuk mengecek apakah username valid
    public boolean isValidUsername(String inputUsername) {
        return inputUsername.equals(username);
    }

    // Metode untuk mengecek apakah password valid
    public boolean isValidPassword(String inputPassword) {
        return inputPassword.equals(password);
    }
}
