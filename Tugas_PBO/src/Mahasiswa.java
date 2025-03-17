import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    private String nama;
    private String nim;

    // List mahasiswa yang valid
    private static final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    // Inisialisasi data mahasiswa
    static {
        daftarMahasiswa.add(new Mahasiswa("Muhammad Surya", "202410370110235"));
        daftarMahasiswa.add(new Mahasiswa("Ahmad Budi", "202410370110123"));
        daftarMahasiswa.add(new Mahasiswa("King Andi", "202410370110456"));
        daftarMahasiswa.add(new Mahasiswa("Queen Caca", "202410370110789"));
        daftarMahasiswa.add(new Mahasiswa("Prince Dede", "202410370110321"));
    }

    // Konstruktor
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Metode untuk login mahasiswa
    public static Mahasiswa login(String inputNama, String inputNim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.nama.equalsIgnoreCase(inputNama) && mhs.nim.equals(inputNim)) {
                return mhs; // Return objek Mahasiswa jika cocok
            }
        }
        return null; // Login gagal
    }

    // Metode untuk mengecek apakah nama dan NIM valid
    public static boolean isValid(String inputNama, String inputNim) {
        return daftarMahasiswa.stream()
                .anyMatch(mhs -> mhs.nama.equalsIgnoreCase(inputNama) && mhs.nim.equals(inputNim));
    }

    // Menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("\n=== Informasi Mahasiswa ===");
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
    }

    // Getter untuk nama dan NIM
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}
