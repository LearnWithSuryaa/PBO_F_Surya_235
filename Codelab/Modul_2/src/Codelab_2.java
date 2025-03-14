import java.text.DecimalFormat;

class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Formatter untuk menampilkan saldo dalam format uang
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");

    // Konstruktor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Getter untuk membaca atribut
    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + df.format(saldo) + "\n");
    }

    // Method untuk menyetor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor Rp" + df.format(jumlah) + ". Saldo sekarang: Rp" + df.format(saldo) + "\n");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!\n");
        }
    }

    // Method untuk menarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + df.format(jumlah) + ". (Berhasil) Saldo sekarang: Rp" + df.format(saldo) + "\n");
        } else if (jumlah > saldo) {
            System.out.println(namaPemilik + " menarik Rp" + df.format(jumlah)
                    + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + df.format(saldo) + "\n");
        } else {
            System.out.println("Jumlah penarikan harus lebih dari 0!\n");
        }
    }
}

public class Codelab_2 {
    public static void main(String[] args) {
        // Menggunakan nama pemilik asli
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

/*
Catatan:
1. Sama seperti sebelumnya saya menggunakan Enkapsulasi (private + getter)  
   - pada atribut nomorRekening, namaPemilik, dan saldo saya buat private untuk mencegah perubahan langsung dari luar class.  
   - Ini menjaga integritas data dan memastikan perubahan hanya bisa dilakukan melalui metode yang telah ditentukan.  

2. Saya juga menggunakan DecimalFormat untuk Saldo  
   - Untuk memastikan saldo ditampilkan dalam format uang yang lebih mudah dibaca, misalnya Rp2,000,000.00 dibanding 2000000.0.  

3. Menambahkan validasi pada Metode setorUang() dan tarikUang()  
   - pada metode setorUang() saya menambahkan validasi inputan hanya menerima jumlah positif.  
   - pada metide tarikUang() saya memastikan saldo cukup sebelum melakukan penarikan, mencegah saldo menjadi negatif.
*/
