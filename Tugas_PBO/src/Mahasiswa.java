import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends User {
    // List untuk menyimpan daftar mahasiswa yang terdaftar
    private static final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    // Inisialisasi daftar mahasiswa
    static {
        daftarMahasiswa.add(new Mahasiswa("Muhammad Surya", "202410370110235"));
        daftarMahasiswa.add(new Mahasiswa("Ahmad Budi", "20241037101123"));
        daftarMahasiswa.add(new Mahasiswa("King Andi", "20241037101099"));
        daftarMahasiswa.add(new Mahasiswa("Queen Caca", "20241037101089"));
        daftarMahasiswa.add(new Mahasiswa("Prince Dede", "20241037101231"));
    }

    // Konstruktor menggunakan 'super' untuk memanggil konstruktor dari User
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    // Override method login dari superclass
    @Override
    public boolean login(String inputNama, String inputNim) {
        return daftarMahasiswa.stream()
                .anyMatch(mhs -> mhs.getNama().equalsIgnoreCase(inputNama) && mhs.getNim().equals(inputNim));
    }

    // Menampilkan informasi mahasiswa dengan tambahan keterangan
    @Override
    public void displayInfo() {
        System.out.println("\n=== Informasi Mahasiswa ===");
        super.displayInfo(); // Memanggil method displayInfo dari superclass
        System.out.println("Status: Mahasiswa Terdaftar");
    }
}
