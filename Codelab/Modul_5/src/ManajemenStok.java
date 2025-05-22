import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        List<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Data awal untuk testing
        daftarBarang.add(new Barang("Buku", 10));
        daftarBarang.add(new Barang("Pensil", 20));
        daftarBarang.add(new Barang("Penghapus", 15));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    // Tambah Barang Baru
                    try {
                        System.out.print("Nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Stok awal: ");
                        int stok = Integer.parseInt(scanner.nextLine());

                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input stok harus berupa angka!");
                    }
                    break;

                case "2":
                    // Tampilkan Semua Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\nDaftar Barang:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println((i + 1) + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }
                    }
                    break;

                case "3":
                    // Kurangi Stok Barang
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi stok.");
                        break;
                    }

                    try {
                        System.out.println("\nDaftar Barang:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println((i + 1) + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }

                        System.out.print("Masukkan nomor barang: ");
                        int nomor = Integer.parseInt(scanner.nextLine());
                        int indeks = nomor - 1; // konversi jadi 0-based

                        // Validasi nomor
                        if (indeks < 0 || indeks >= daftarBarang.size()) {
                            System.out.println("Nomor barang tidak valid.");
                            break;
                        }

                        Barang barang = daftarBarang.get(indeks);

                        System.out.print("Jumlah yang ingin dikurangi: ");
                        int jumlah = Integer.parseInt(scanner.nextLine());

                        if (jumlah > barang.getStok()) {
                            throw new StokTidakCukupException(
                                "Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok()
                            );
                        }

                        barang.setStok(barang.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");

                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka.");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem manajemen stok.");
                    break;

                default:
                    System.out.println("Pilihan tidak dikenal.");
            }
        }

        scanner.close();
    }
}
