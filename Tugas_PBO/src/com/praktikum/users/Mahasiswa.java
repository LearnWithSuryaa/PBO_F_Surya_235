package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nim;

    // Daftar mahasiswa terdaftar
    private static final List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    static {
        daftarMahasiswa.add(new Mahasiswa("Muhammad Surya", "202410370110235"));
        daftarMahasiswa.add(new Mahasiswa("Ahmad Budi", "20241037101123"));
        daftarMahasiswa.add(new Mahasiswa("King Andi", "20241037101099"));
        daftarMahasiswa.add(new Mahasiswa("Queen Caca", "20241037101089"));
        daftarMahasiswa.add(new Mahasiswa("Prince Dede", "20241037101231"));
    }

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return daftarMahasiswa.stream()
                .anyMatch(mhs -> mhs.getNama().equalsIgnoreCase(inputNama)
                        && mhs.getNim().equals(inputNim));
    }

    @Override
    public void displayInfo() {
        System.out.println("\n=== Informasi Mahasiswa ===");
        super.displayInfo();
        System.out.println("NIM   : " + nim);
        System.out.println("Status: Mahasiswa Terdaftar");
    }

    // Implementasi aksi lapor barang
    @Override
    public void reportItem(Scanner scanner) {
        System.out.print("Masukkan Nama Barang          : ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Deskripsi Barang     : ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Masukkan Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println("\n>> Laporan berhasil dicatat:");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasi);
    }

    // Placeholder method
    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    // Menu aplikasi mahasiswa
    @Override
    public void displayAppMenu(Scanner scanner) {
        int pilihan;

        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next();
            }

            pilihan = scanner.nextInt();
            scanner.nextLine(); // bersihkan newline

            switch (pilihan) {
                case 1:
                    reportItem(scanner);
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil.\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 0);
    }
}
