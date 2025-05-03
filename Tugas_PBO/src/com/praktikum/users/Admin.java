package com.praktikum.users;

import com.praktikum.actions.AdminAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements AdminAction {
    private String password;

    // Daftar admin yang terdaftar
    private static final List<Admin> daftarAdmin = new ArrayList<>();

    // Inisialisasi daftar admin
    static {
        daftarAdmin.add(new Admin("Admin235", "Password235"));
        daftarAdmin.add(new Admin("master", "master235"));
    }

    // Konstruktor
    public Admin(String nama, String password) {
        super(nama);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Override method login
    @Override
    public boolean login(String inputNama, String inputPassword) {
        return daftarAdmin.stream()
                .anyMatch(admin -> admin.getNama().equalsIgnoreCase(inputNama)
                        && admin.getPassword().equals(inputPassword));
    }

    // Implementasi method dari interface AdminAction
    @Override
    public void manageItem() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUser() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    // Menu aplikasi admin
    @Override
    public void displayAppMenu(Scanner scanner) {
        int pilihan;

        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid: ");
                scanner.next(); // buang input tidak valid
            }

            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    manageItem(); // Sesuai interface
                    break;
                case 2:
                    manageUser(); // Sesuai interface
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
