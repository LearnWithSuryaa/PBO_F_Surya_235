public class Mahasiswa {
    private String nama;
    private String nim;

    // Data mahasiswa yang valid
    private static final String[][] dataMahasiswa = {
        { "Muhammad Surya", "202410370110235" },
        { "Ahmad Budi", "202410370110123" },
        { "King Andi", "202410370110456" },
        { "Queen Caca", "202410370110789" },
        { "Prince Dede", "202410370110321" }
    };

    // Konstruktor untuk objek mahasiswa
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Metode untuk memeriksa login Mahasiswa
    public static Mahasiswa login(String inputNama, String inputNim) {
        for (String[] mahasiswa : dataMahasiswa) {
            if (mahasiswa[0].equalsIgnoreCase(inputNama) && mahasiswa[1].equals(inputNim)) {
                return new Mahasiswa(inputNama, inputNim);
            }
        }
        return null; // Login gagal
    }

    // Metode untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("\n=== Informasi Mahasiswa ===");
        System.out.println("Nama: " + this.nama);
        System.out.println("NIM: " + this.nim);
    }

    // Metode untuk mengecek apakah nama valid
    public static boolean isNamaValid(String inputNama) {
        for (String[] mahasiswa : dataMahasiswa) {
            if (mahasiswa[0].equalsIgnoreCase(inputNama)) {
                return true;
            }
        }
        return false;
    }

    // Metode untuk mengecek apakah NIM valid
    public static boolean isNimValid(String inputNim) {
        for (String[] mahasiswa : dataMahasiswa) {
            if (mahasiswa[1].equals(inputNim)) {
                return true;
            }
        }
        return false;
    }
}
