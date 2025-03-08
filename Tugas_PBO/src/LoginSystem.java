import java.util.Scanner;

public class LoginSystem {
    final static String RED = "\u001B[31m";
    final static String GREEN = "\u001B[32m";
    final static String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.println("===== Sistem Login =====");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");

        int pilihan = 0;
        while (true) {
            System.out.print("Masukkan pilihan (1/2): ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); // Bersihkan buffer

                if (pilihan == 1 || pilihan == 2) {
                    break;
                }
            }

            // Tampilkan error hanya satu kali
            System.out.println(RED + "Pilihan tidak valid. Harus berupa angka 1 atau 2." + RESET);
            input.next(); // Buang input yang salah
        }

        if (pilihan == 1) {
            // Login Admin
            int maxPercobaan = 3;
            boolean isLoginBerhasil = false;

            for (int i = 0; i < maxPercobaan; i++) {
                System.out.print("Username: ");
                String inputUsername = input.nextLine();
                System.out.print("Password: ");
                String inputPassword = input.nextLine();

                boolean isUsernameValid = admin.isValidUsername(inputUsername);
                boolean isPasswordValid = admin.isValidPassword(inputPassword);

                if (!isUsernameValid && !isPasswordValid) {
                    System.out.println(RED + "Username dan Password salah." + RESET);
                } else if (!isUsernameValid) {
                    System.out.println(RED + "Username salah." + RESET);
                } else if (!isPasswordValid) {
                    System.out.println(RED + "Password salah." + RESET);
                }

                if (admin.login(inputUsername, inputPassword)) {
                    System.out.println(GREEN + "Login berhasil sebagai Admin." + RESET);
                    isLoginBerhasil = true;
                    break;
                } else {
                    int sisaPercobaan = maxPercobaan - (i + 1);
                    if (sisaPercobaan > 0) {
                        System.out.println(RED + "Percobaan ke-" + (i + 1) + " gagal. Sisa percobaan: " + sisaPercobaan + RESET);
                    } else {
                        System.out.println(RED + "Anda telah mencapai batas percobaan login." + RESET);
                    }
                }
            }

            if (!isLoginBerhasil) {
                System.out.println(RED + "\nLogin Admin gagal. Silakan coba lagi nanti." + RESET);
            }

        } else if (pilihan == 2) {
            // Login Mahasiswa
            int maxPercobaan = 3;
            boolean isLoginBerhasil = false;

            for (int i = 0; i < maxPercobaan; i++) {
                System.out.print("Masukkan Nama: ");
                String inputNama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = input.nextLine();

                boolean isNamaValid = Mahasiswa.isNamaValid(inputNama);
                boolean isNimValid = Mahasiswa.isNimValid(inputNim);

                if (!isNamaValid && !isNimValid) {
                    System.out.println(RED + "Nama dan NIM tidak valid." + RESET);
                } else if (!isNamaValid) {
                    System.out.println(RED + "Nama tidak valid." + RESET);
                } else if (!isNimValid) {
                    System.out.println(RED + "NIM tidak valid." + RESET);
                }

                Mahasiswa mahasiswa = Mahasiswa.login(inputNama, inputNim);

                if (mahasiswa != null) {
                    System.out.println(GREEN + "Login Mahasiswa berhasil!" + RESET);
                    mahasiswa.displayInfo();
                    isLoginBerhasil = true;
                    break;
                } else {
                    int sisaPercobaan = maxPercobaan - (i + 1);
                    if (sisaPercobaan > 0) {
                        System.out.println( RED + "Percobaan ke-" + (i + 1) + " gagal. Sisa percobaan: " + sisaPercobaan + RESET);
                    } else {
                        System.out.println(RED + "Anda telah mencapai batas percobaan login." + RESET);
                    }
                }
            }

            if (!isLoginBerhasil) {
                System.out.println(RED + "Login Mahasiswa gagal. Silakan coba lagi nanti." + RESET);
            }
        }

        input.close();

    }
}
