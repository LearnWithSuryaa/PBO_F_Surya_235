# Program Input Data Diri - Java

## Deskripsi
Program ini merupakan aplikasi berbasis Java yang meminta pengguna untuk memasukkan data diri, termasuk nama, jenis kelamin, dan tahun lahir. Program juga memiliki validasi untuk memastikan input yang benar dan menghitung umur pengguna berdasarkan tahun saat ini.

## Fitur
- **Input nama** dengan validasi agar tidak kosong.
- **Input jenis kelamin** hanya menerima 'p' untuk perempuan dan 'l' untuk laki-laki.
- **Input tahun lahir** hanya menerima angka dalam rentang yang wajar (1900 hingga tahun saat ini).
- **Perhitungan umur otomatis** berdasarkan tahun lahir dan tahun saat ini.
- **Menampilkan data yang telah dimasukkan** dengan format yang rapi.

## Prasyarat
Sebelum menjalankan program ini, pastikan Anda memiliki:
- Java Development Kit (JDK) terinstal di komputer Anda.
- Text editor atau IDE seperti VS Code, IntelliJ IDEA, atau Eclipse.

## Cara Menjalankan Program
1. **Kompilasi kode** dengan perintah berikut:
   ```sh
   javac Main.java
   ```
2. **Jalankan program** dengan perintah berikut:
   ```sh
   java Main
   ```
3. **Masukkan data yang diminta**
   - Nama (tidak boleh kosong)
   - Jenis kelamin (hanya 'p' atau 'l')
   - Tahun lahir (harus angka antara 1900 dan tahun saat ini)
4. **Lihat hasil** berupa tampilan data diri dan perhitungan umur otomatis.

## Struktur Kode
- **Menggunakan Scanner** untuk menerima input dari pengguna.
- **Validasi input**:
  - Nama tidak boleh kosong.
  - Jenis kelamin harus 'p' atau 'l'.
  - Tahun lahir harus berupa angka yang valid.
- **Menggunakan `LocalDate.now().getYear()`** untuk mendapatkan tahun saat ini.
- **Perhitungan umur** dilakukan dengan mengurangkan tahun lahir dari tahun sekarang.
- **Menampilkan data dengan format yang rapi**.
