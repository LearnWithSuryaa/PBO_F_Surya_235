class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // Konstruktor untuk menginisialisasi atribut
    RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Method untuk menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo + "\n");
    }

    // Method untuk menyetor uang
    void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo + "\n");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!" + "\n");
        }
    }

    // Method untuk menarik uang
    void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo + "\n");
        } else if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + jumlah
                    + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo + "\n");
        } else {
            System.out.println("Jumlah penarikan harus lebih dari 0!" + "\n");
        }
    }
}

public class Codelab_2 {
    public static void main(String[] args) {
        // Membuat dua objek RekeningBank
        RekeningBank rekening1 = new RekeningBank("202410370110235", "Surya", 2000000.0);
        RekeningBank rekening2 = new RekeningBank("202410370110246", "Chicka", 1000000.0);
        
        // Menampilkan informasi awal rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan transaksi setor uang
        rekening1.setorUang(200000.0);
        rekening2.setorUang(500000.0);

        // Melakukan transaksi tarik uang
        rekening1.tarikUang(800000.0);
        rekening2.tarikUang(300000.0);

        // Menampilkan informasi akhir rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}