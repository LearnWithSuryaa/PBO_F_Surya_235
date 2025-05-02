# 📘 Dokumentasi Teknis - Sistem Manajemen Perpustakaan (Modul 4)

Proyek ini merupakan implementasi sistem manajemen perpustakaan berbasis Java yang menggunakan prinsip-prinsip OOP (Object-Oriented Programming). Tujuan utamanya adalah mengelola data buku, anggota, serta peminjaman buku menggunakan struktur dan relasi class.

---

## 1. Struktur Direktori

```
Modul_4/
├── bin/                        # Output file hasil kompilasi (.class)
├── lib/                        # Dependensi eksternal (jika diperlukan)
├── src/                        # Source code utama
│   ├── app/
│   │   └── Main.java           # Titik masuk aplikasi
│   └── perpustakaan/
│       ├── Anggota.java        # Representasi anggota perpustakaan
│       ├── Buku.java           # Superclass untuk semua jenis buku
│       ├── Fiksi.java          # Subclass buku fiksi
│       ├── NonFiksi.java       # Subclass buku non-fiksi
│       └── Peminjaman.java     # Manajemen peminjaman buku
├── README.md                   # Dokumentasi proyek
```

---

## 2. Struktur Class

### 2.1 `Buku.java`

Superclass yang mendefinisikan struktur umum sebuah buku.

```java
public class Buku {
    protected String judul;
    protected String penulis;
    protected int tahunTerbit;
    
    public Buku(String judul, String penulis, int tahunTerbit) { ... }
    public String getJudul() { ... }
    public void infoBuku() { ... }
}
```

### 2.2 `Fiksi.java` & `NonFiksi.java`

Merupakan subclass dari `Buku` yang menambahkan atribut kategori atau genre jika diperlukan. Dapat melakukan override method `infoBuku()`.

### 2.3 `Anggota.java`

Mewakili user dari sistem perpustakaan.

```java
public class Anggota {
    private String nama;
    private String idAnggota;
    private List<Buku> daftarPinjaman;

    public void pinjamBuku(Buku buku) { ... }
    public void kembalikanBuku(Buku buku) { ... }
}
```

### 2.4 `Peminjaman.java`

Mengelola data peminjaman dan pengembalian buku.

```java
public class Peminjaman {
    private Anggota anggota;
    private Buku buku;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
}
```

### 2.5 `Main.java`

Menjadi titik eksekusi program.

```java
public class Main {
    public static void main(String[] args) {
        // Inisialisasi data buku dan anggota
        // Simulasi proses peminjaman dan pengembalian
    }
}
```

---

## 3. Cara Kompilasi dan Menjalankan

```bash
# Kompilasi seluruh source code
javac -d bin src/perpustakaan/*.java src/app/Main.java

# Jalankan aplikasi
java -cp bin app.Main
```

---

## 4. Fitur yang Didukung

* Manajemen daftar buku (fiksi & non-fiksi)
* Pencatatan anggota perpustakaan
* Proses peminjaman & pengembalian
* Penerapan inheritance & polymorphism dalam class `Buku`

