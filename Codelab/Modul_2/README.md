# 🚀 Simulasi OOP Java - Hewan & Rekening Bank

Selamat datang di **Simulasi OOP Java**, tempat di mana saya belajar tentang **Encapsulation, Inheritance, dan Method dalam Java** dengan contoh **data hewan dan rekening bank**! 🐱💰

## 🎯 Fitur Utama
- **List Hewan** 🦁
  - Membuat objek hewan dengan nama, jenis, dan suara khasnya.
  - Menggunakan **Encapsulation** untuk menjaga data tetap aman.
  - **Method `tampilkanInfo()`** untuk menampilkan detail hewan.
  
- **Simulasi Rekening Bank** 💳
  - Membuat akun bank dengan nomor rekening, nama pemilik, dan saldo awal.
  - **Setor & Tarik Uang** dengan validasi agar tidak salah input.
  - **Menggunakan `DecimalFormat`** untuk tampilan saldo lebih rapi.

---

## 📜 Cara Pakai

1. **Clone atau download repo ini**
   ```bash
   git clone https://github.com/username/Simulasi-OOP-Java.git
   cd Simulasi-OOP-Java
   ```
2. **Jalankan file `Codelab_1.java` dan `Codelab_2.java` di IDE favorit saya** (NetBeans, IntelliJ, VS Code, atau pakai terminal langsung dengan Java).
3. **Nikmati simulasi OOP Java dengan output yang rapi dan proper!** 🎉

---

## 🛠 Teknologi yang Dipakai
- **Java** (Core OOP: Encapsulation, Inheritance, Method)
- **DecimalFormat** untuk tampilan saldo yang lebih rapi
- **Basic console-based UI** untuk interaksi yang simpel

---

## 📝 Penjelasan Singkat Kode

### **1️⃣ Kelas Hewan (`Hewan.java`)**
- **Encapsulation:** Variabel `nama`, `jenis`, dan `suara` dibuat `private`.
- **Getter Methods:** Mengakses data dengan method `getNama()`, `getJenis()`, dan `getSuara()`.
- **Method `tampilkanInfo()`** ➝ Menampilkan informasi hewan.

### **2️⃣ Kelas Rekening Bank (`RekeningBank.java`)**
- **Encapsulation:** Variabel `nomorRekening`, `namaPemilik`, dan `saldo` dibuat `private`.
- **Method `setorUang()` dan `tarikUang()`** ➝ Transaksi dengan validasi saldo.
- **Menggunakan `DecimalFormat`** agar saldo lebih rapi (`Rp1.000.000,00`).

---

## 📌 Contoh Output

### **Hewan** 🐶🐱
```bash
Nama: Kucing
Jenis: Mamalia
Suara: Nyann~~

Nama: Anjing
Jenis: Mamalia
Suara: Woof-Woof!!
```

### **Rekening Bank** 💰
```bash
Nomor Rekening: 202410370110235
Nama Pemilik: Surya
Saldo: Rp2.000.000,00

Nomor Rekening: 202410370110246
Nama Pemilik: Chicka
Saldo: Rp1.000.000,00

Surya menyetor Rp200.000,00. Saldo sekarang: Rp2.200.000,00
Chicka menyetor Rp500.000,00. Saldo sekarang: Rp1.500.000,00

Surya menarik Rp800.000,00. (Berhasil) Saldo sekarang: Rp1.400.000,00
Chicka menarik Rp300.000,00. (Berhasil) Saldo sekarang: Rp1.200.000,00
```

---

## 📢 Kenapa Gak Pakai `@Override` Pada Program Rekening Bank?
Karena saya **tidak menggunakan inheritance** dalam kode ini, jadi `@Override` tidak diperlukan. Saya hanya fokus ke **Encapsulation (Private Variables + Getters)** untuk keamanan data hewan dan rekening bank.

---

## 🤝 Kontribusi
Pengen upgrade fitur ini? **Pull request aja!** Atau kalau ada bug/error, boleh open issue. 🙌

---

### 🔥 Enjoy coding & selamat belajar OOP di Java! 🔥

