class Hewan {
    // Atribut private untuk enkapsulasi
    private String nama;  
    private String jenis;
    private String suara;

    // Konstruktor
    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    // Getter untuk membaca data
    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public String getSuara() {
        return suara;
    }

    // Override metode toString untuk representasi objek
    @Override
    public String toString() {
        return "Nama: " + nama + "\nJenis: " + jenis + "\nSuara: " + suara + "\n";
    }
}

public class Codelab_1 {
    public static void main(String[] args) {
        // Membuat objek hewan
        Hewan hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
        Hewan hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        // Menampilkan informasi hewan dengan toString()
        System.out.println(hewan1);
        System.out.println(hewan2);
    }
}

/*
Note:
1. Saya menggunakan @Override pada toString()  
   - toString() adalah metode bawaan dari class Object.  
   - Dengan override, saya bisa menentukan bagaimana objek Hewan direpresentasikan sebagai String.  
   - Dengan ini saya dapat mempermudah pencetakan objek tanpa harus membuat metode khusus seperti tampilkanInfo().  

2. Saya juga menggunakan Enkapsulasi (private + getter)  
   - Atribut dibuat private untuk melindungi data agar tidak bisa diubah langsung dari luar class.  
   - Hanya bisa diakses dengan metode getter (getNama(), getJenis(), getSuara()), mengimplementasikan prinsip OOP yang dijelaskan pada saat praktikum.  
   - Mempermudah jika perlu mengubah nilai, dengan cara menambahkan setter untuk memberikan kontrol lebih lanjut.  
*/
