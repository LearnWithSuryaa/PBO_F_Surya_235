import java.time.LocalDate;
import java.util.Scanner;

public class DataDiriSederhana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Validasi nama tidak boleh kosong dan harus huruf
        String nama;
        while (true) {
            System.out.print("Masukkan nama: ");
            nama = scanner.nextLine().trim();
            if (!nama.isEmpty() && nama.matches("[a-zA-Z\\s]+")) break;
            System.out.println("Nama tidak boleh kosong dan harus hanya berisi huruf. Silakan coba lagi.");
        }
        
        // Validasi jenis kelamin hanya boleh 'p' atau 'l'
        char jenisKelamin;
        while (true) {
            System.out.print("Masukkan jenis kelamin (p/l): ");
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("p") || input.equals("l")) {
                jenisKelamin = input.charAt(0);
                break;
            }
            System.out.println("Jenis kelamin harus 'p' (Perempuan) atau 'l' (Laki-laki). Silakan coba lagi.");
        }
        
        // Validasi tahun lahir harus angka dan dalam rentang yang wajar
        int tahunLahir = 0;
        int tahunSekarang = LocalDate.now().getYear();
        while (true) {
            System.out.print("Masukkan tahun lahir: ");
            if (scanner.hasNextInt()) {
                tahunLahir = scanner.nextInt();
                if (tahunLahir > 1900 && tahunLahir <= tahunSekarang) break;
                else System.out.println("Tahun lahir harus antara 1900 dan " + tahunSekarang + ". Silakan coba lagi.");
            } else {
                System.out.println("Harap masukkan angka yang valid.");
                scanner.next(); // Menghapus input yang tidak valid
            }
        }
        
        int umur = tahunSekarang - tahunLahir;
        
        System.out.println("\nData Diri: ");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + (jenisKelamin == 'p' ? "Perempuan" : "Laki-laki"));
        System.out.println("Umur: " + umur + " tahun");
        
        scanner.close();
    }
}
