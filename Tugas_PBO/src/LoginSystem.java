import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data admin
        String username = "admin235";
        String password = "password235";

        // Data mahasiswa
        String[][] dataMahasiswa = {
            {"Muhammad Surya", "202410370110235"},
            {"Ahmad Budi", "202410370110123"},
            {"King Andi", "202410370110456"},
            {"Queen Caca", "202410370110789"},
            {"Prince Dede", "202410370110321"}
        };

        System.out.println("Pilih login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        
        int pilihan;

        if (input.hasNextInt()) {
            pilihan = input.nextInt();
            input.nextLine(); // newline setelah angka
        } else {
            System.out.println("Pilihan tidak valid.");
            input.close();
            return;
        }

        if (pilihan == 1) {
            while (true) {
                System.out.print("Username: ");
                String inputUsername = input.nextLine();
                System.out.print("Password: ");
                String inputPassword = input.nextLine();

                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    System.out.println("Login berhasil sebagai Admin.");
                    break;
                } else {
                    System.out.println("Username atau password salah, coba lagi.");
                }
            }
        } else if (pilihan == 2) {
            while (true) {
                System.out.print("Masukkan Nama: ");
                String inputNama = input.nextLine();
                System.out.print("Masukkan NIM: ");
                String inputNim = input.nextLine();

                boolean isValid = false;
                for (String[] mahasiswa : dataMahasiswa) {
                    if (mahasiswa[0].equalsIgnoreCase(inputNama) && mahasiswa[1].equals(inputNim)) {
                        isValid = true;
                        break;
                    }
                }

                if (isValid) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.println("Nama: " + inputNama);
                    System.out.println("NIM: " + inputNim);
                    break;
                } else {
                    System.out.println("Nama atau NIM salah, coba lagi.");
                }
            }
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        
        input.close();
    }
}
