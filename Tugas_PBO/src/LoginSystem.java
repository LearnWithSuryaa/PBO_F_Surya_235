import java.util.Scanner;

public class LoginSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_ATTEMPTS = 3; // deklarasi konstanta maksimal percobaan login

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Login ===");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3): ");
            
            String pilihan = scanner.nextLine().trim(); // Menghapus spasi kosong

            switch (pilihan) {
                case "1":
                    if (attemptLogin("Mahasiswa")) return; // Jika login berhasil, keluar dari program
                    break;
                case "2":
                    if (attemptLogin("Admin")) return; // Jika login berhasil, keluar dari program
                    break;
                case "3":
                    System.out.println(ConsoleColor.green("Terima kasih telah menggunakan sistem."));
                    scanner.close();
                    return;
                default:
                    System.out.println(ConsoleColor.red("Pilihan tidak valid. Silakan coba lagi."));
            }
        }
    }

    // Metode untuk menangani batasan percobaan login
    private static boolean attemptLogin(String role) {
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            boolean success = role.equals("Mahasiswa") ? loginMahasiswa() : loginAdmin();
            if (success) return true; // Jika login berhasil, keluar dari program

            attempts++;
            int remainingAttempts = MAX_ATTEMPTS - attempts;
            if (remainingAttempts > 0) {
                System.out.println(ConsoleColor.red("Kesempatan tersisa: " + remainingAttempts));
            } else {
                System.out.println(ConsoleColor.red("\nAnda telah gagal login 3 kali. Sistem keluar."));
                System.exit(0); // Keluar dari program setelah gagal 3 kali
            }
        }
        return false;
    }

    // Login sebagai Mahasiswa
    private static boolean loginMahasiswa() {
        System.out.print("\nMasukkan Nama: ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine().trim();

        // Validasi input tidak boleh kosong
        if (nama.isEmpty() || nim.isEmpty()) {
            System.out.println(ConsoleColor.red("\nNama dan NIM tidak boleh kosong!"));
            return false;
        }

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim);
        if (mahasiswa.login(nama, nim)) {
            System.out.println(ConsoleColor.green("\nLogin berhasil sebagai Mahasiswa."));
            mahasiswa.displayInfo();
            return true;
        } else {
            System.out.println(ConsoleColor.red("\nLogin gagal! Nama atau NIM salah."));
            return false;
        }
    }

    // Login sebagai Admin hanya dengan username dan password
    private static boolean loginAdmin() {
        System.out.print("\nMasukkan Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine().trim();

        // Validasi input tidak boleh kosong
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println(ConsoleColor.red("\nUsername dan Password tidak boleh kosong!"));
            return false;
        }

        Admin admin = new Admin(username, password);
        if (admin.login(username, password)) {
            System.out.println(ConsoleColor.green("\nLogin berhasil sebagai Admin."));
            return true;
        } else {
            System.out.println(ConsoleColor.red("\nLogin gagal! Username atau Password salah."));
            return false;
        }
    }
}
