import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Menampilkan menu login
        System.out.println("===== Sistem Login =====");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");

        int pilihan = 0;
        while (true) {
            System.out.print("Masukkan pilihan (1/2): ");
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); // Bersihkan buffer
                if (pilihan == 1 || pilihan == 2) break;
            } else {
                input.nextLine(); // Buang input yang salah
            }
            System.out.println(ConsoleColor.red("Pilihan tidak valid. Harus berupa angka 1 atau 2."));
        }

        attemptLogin(pilihan, input);
        input.close();
    }

    private static void attemptLogin(int userType, Scanner input) {
        int maxPercobaan = 3;

        for (int i = 0; i < maxPercobaan; i++) {
            if (userType == 1) {
                Admin admin = new Admin("Admin235", "Password235");

                System.out.print("Username: ");
                String inputUsername = input.nextLine();
                System.out.print("Password: ");
                String inputPassword = input.nextLine();

                if (admin.validateLogin(inputUsername, inputPassword)) {
                    System.out.println(ConsoleColor.green("Login berhasil sebagai Admin."));
                    return; // Keluar dari metode jika login berhasil
                } else {
                    System.out.println(ConsoleColor.red("Login gagal. Username atau Password salah."));
                }

            } else if (userType == 2) {
                System.out.print("Masukkan Nama: ");
                String inputNama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = input.nextLine();

                if (!Mahasiswa.isValid(inputNama, inputNim)) {
                    System.out.println(ConsoleColor.red("Nama atau NIM tidak valid."));
                } else {
                    Mahasiswa mahasiswa = Mahasiswa.login(inputNama, inputNim);
                    System.out.println(ConsoleColor.green("Login Mahasiswa berhasil!"));
                    mahasiswa.displayInfo();
                    return; // Keluar dari metode jika login berhasil
                }
            }

            int sisaPercobaan = maxPercobaan - (i + 1);
            if (sisaPercobaan > 0) {
                System.out.println(ConsoleColor.red("Percobaan gagal. Sisa percobaan: " + sisaPercobaan));
            } else {
                System.out.println(ConsoleColor.red("Anda telah mencapai batas percobaan login."));
            }
        }
    }
}
