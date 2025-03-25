import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    // List untuk menyimpan daftar admin yang terdaftar
    private static final List<Admin> daftarAdmin = new ArrayList<>();

    // Inisialisasi daftar admin
    static {
        daftarAdmin.add(new Admin("Admin235", "Password235"));
        daftarAdmin.add(new Admin("master", "master235"));
    }

    // Konstruktor untuk menginisialisasi admin dengan nama dan password
    public Admin(String nama, String password) {
        super(nama, password);
    }

    // Override method login khusus untuk admin (menggunakan nama & password)
    @Override
    public boolean login(String inputNama, String inputPassword) {
        return daftarAdmin.stream()
                .anyMatch(admin -> admin.getNama().equalsIgnoreCase(inputNama) && admin.getPassword().equals(inputPassword));
    }
}
