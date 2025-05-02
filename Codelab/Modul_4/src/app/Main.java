package app;

import java.util.InputMismatchException;
import java.util.Scanner;
import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Input Data Buku ===");
            System.out.print("Judul Buku: ");
            String judul = inputString(scanner);

            System.out.print("Penulis Buku: ");
            String penulis = inputString(scanner);

            System.out.print("Kategori Buku (Fiksi / NonFiksi): ");
            String kategori = inputString(scanner);

            Buku buku;
            if (kategori.equalsIgnoreCase("Fiksi")) {
                System.out.print("Genre Fiksi: ");
                String genre = inputString(scanner);
                buku = new Fiksi(judul, penulis, genre);
            } else if (kategori.equalsIgnoreCase("NonFiksi")) {
                System.out.print("Bidang NonFiksi: ");
                String bidang = inputString(scanner);
                buku = new NonFiksi(judul, penulis, bidang);
            } else {
                throw new IllegalArgumentException("Kategori harus Fiksi atau NonFiksi!");
            }

            buku.displayInfo();
            System.out.println();

            System.out.println("=== Input Data Anggota ===");
            System.out.print("Nama Anggota: ");
            String nama = inputString(scanner);

            System.out.print("ID Anggota: ");
            String id = inputString(scanner);

            Anggota anggota = new Anggota(nama, id);
            anggota.displayInfo();
            System.out.println();

            System.out.println("=== Proses Peminjaman Buku ===");
            System.out.print("Ingin pinjam berapa hari? (masukkan angka >= 1): ");
            int hari = inputInt(scanner, 1); // Validasi: hari >= 1

            anggota.pinjamBuku(buku.getJudul(), hari);
            System.out.println();

            System.out.println("=== Proses Pengembalian Buku ===");
            anggota.kembalikanBuku(buku.getJudul());

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harus sesuai tipe data yang diminta.");
        } catch (IllegalArgumentException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan yang tidak terduga: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method bantu untuk validasi input String (tidak boleh kosong)
    public static String inputString(Scanner scanner) {
        String input = "";
        while (input.trim().isEmpty()) {
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.print("Input tidak boleh kosong, coba lagi: ");
            }
        }
        return input.trim();
    }

    // Method bantu untuk validasi input Integer dengan batas minimum
    public static int inputInt(Scanner scanner, int min) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // konsumsi newline
                if (input < min) {
                    System.out.print("Input minimal adalah " + min + ", coba lagi: ");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Input harus angka, coba lagi: ");
                scanner.nextLine(); // buang input yang salah
            }
        }
    }
}
