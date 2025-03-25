public class User {
    private String nama;
    private String nim;
    private String password;

    // Konstruktor untuk Mahasiswa (Memerlukan NIM)
    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.password = null; // Mahasiswa tidak butuh password
    }

    // Konstruktor untuk Admin (Memerlukan Password, tapi tidak butuh NIM)
    public User(String nama, String password, boolean isAdmin) {
        this.nama = nama;
        this.password = password;
        this.nim = null; // Admin tidak memiliki NIM
    }

    // Getter dan Setter untuk Nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk NIM (hanya untuk Mahasiswa)
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // Getter dan Setter untuk Password (hanya untuk Admin)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method untuk menampilkan informasi pengguna
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        if (nim != null) {
            System.out.println("NIM: " + nim);
        }
    }

    // Method login() akan di-override oleh subclass
    public boolean login(String inputNama, String inputCredential) {
        return false;
    }
}
