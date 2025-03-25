# 🏆 **Game Pertarungan: Pahlawan vs. Musuh**  

Game ini adalah implementasi **Object-Oriented Programming (OOP)** dalam **Java**, yang mensimulasikan pertarungan antara **Pahlawan** dan **Musuh**. Saya menggunakan konsep **inheritance**, **method overriding**, dan **encapsulation** untuk membangun sistem yang fleksibel dan adil.  

---

## 📌 **Penjelasan Setiap Kelas**
### 1️⃣ **Superclass: `KarakterGame`**
`KarakterGame` adalah kelas induk yang memiliki atribut dan metode dasar untuk karakter dalam game.  
Saya menggunakan **encapsulation** dengan menjadikan atribut `private` dan menyediakan metode `getter` serta `setter`.

```java
abstract class KarakterGame {
    private String nama;
    private int kesehatan;
    private String jenisSerangan;

    public KarakterGame(String nama, int kesehatan, String jenisSerangan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
        this.jenisSerangan = jenisSerangan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public String getJenisSerangan() {
        return jenisSerangan;
    }

    public abstract void serang(KarakterGame target);
}
```
#### 🔹 **Poin Penting**
✅ Menggunakan **encapsulation** untuk melindungi data.  
✅ `serang(KarakterGame target)` dibuat sebagai **abstract method**, sehingga harus diimplementasikan ulang di subclass.  

---

### 2️⃣ **Subclass: `Pahlawan`**
Class `Pahlawan` mewarisi (`extends`) class `KarakterGame` dan mengimplementasikan metode `serang()` dengan **method overriding**.  
Saya menggunakan **random damage** agar pertarungan lebih adil.

```java
class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan, String jenisSerangan) {
        super(nama, kesehatan, jenisSerangan);
    }

    @Override
    public void serang(KarakterGame target) {
        Random rand = new Random();
        int damage = rand.nextInt(11) + 15; // damage acak antara 15-25
        System.out.println(getNama() + " menyerang " + target.getNama() + " dengan " + getJenisSerangan() + " sebesar " + damage + " damage!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
```
#### 🔹 **Poin Penting**
✅ **Inheritance** → `Pahlawan` mewarisi atribut dan metode dari `KarakterGame`.  
✅ **Method Overriding** → `serang()` diubah dengan damage acak.  
✅ **Random Damage** → Damage bervariasi antara **15-25** untuk keadilan.  

---

### 3️⃣ **Subclass: `Musuh`**
Class `Musuh` memiliki struktur yang sama dengan class `Pahlawan`, tetapi tetap mempertahankan fleksibilitas dengan nama dan serangan yang bisa diinput pengguna.

```java
class Musuh extends KarakterGame {
    public Musuh(String nama, int kesehatan, String jenisSerangan) {
        super(nama, kesehatan, jenisSerangan);
    }

    @Override
    public void serang(KarakterGame target) {
        Random rand = new Random();
        int damage = rand.nextInt(11) + 15; // damage acak antara 15-25
        System.out.println(getNama() + " menyerang " + target.getNama() + " dengan " + getJenisSerangan() + " sebesar " + damage + " damage!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
```
#### 🔹 **Poin Penting**
✅ **Method Overriding** untuk `serang()`.  
✅ **Random Damage** tetap sama agar pertarungan adil.  

---

### 4️⃣ **Kelas Utama: `App`**
Kelas utama yang menangani input dan jalannya pertarungan.  
Saya menambahkan sistem **jumlah ronde** agar permainan lebih dinamis.

```java
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Pahlawan
        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = scanner.nextLine();
        System.out.print("Masukkan jenis serangan Pahlawan: ");
        String jenisSeranganPahlawan = scanner.nextLine();
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150, jenisSeranganPahlawan);

        // Input Musuh
        System.out.print("Masukkan nama Musuh: ");
        String namaMusuh = scanner.nextLine();
        System.out.print("Masukkan jenis serangan Musuh: ");
        String jenisSeranganMusuh = scanner.nextLine();
        Musuh musuh = new Musuh(namaMusuh, 150, jenisSeranganMusuh);

        // Input jumlah ronde
        System.out.print("Masukkan jumlah ronde pertarungan: ");
        int jumlahRonde = scanner.nextInt();

        // Pertarungan
        for (int ronde = 1; ronde <= jumlahRonde; ronde++) {
            if (pahlawan.getKesehatan() <= 0 || musuh.getKesehatan() <= 0) {
                break;
            }

            System.out.println("\n--- Ronde " + ronde + " ---");

            // Pahlawan menyerang
            pahlawan.serang(musuh);

            // Cek apakah Musuh masih hidup sebelum menyerang balik
            if (musuh.getKesehatan() > 0) {
                musuh.serang(pahlawan);
            }
        }

        // Penentuan pemenang
        if (pahlawan.getKesehatan() > 0) {
            System.out.println("\n" + pahlawan.getNama() + " (Pahlawan) menang!");
        } else if (musuh.getKesehatan() > 0) {
            System.out.println("\n" + musuh.getNama() + " (Musuh) menang!");
        } else {
            System.out.println("\nPertarungan berakhir seri!");
        }

        scanner.close();
    }
}
```
#### 🔹 **Poin Penting**
✅ **Menggunakan Scanner** untuk input **nama**, **jenis serangan**, dan **jumlah ronde**.  
✅ **Looping dengan batasan ronde** untuk membatasi durasi permainan.  
✅ **Cek kesehatan karakter** agar tidak menyerang jika sudah kalah.  
✅ **Otomatis menentukan pemenang** berdasarkan sisa kesehatan.  

---

## 📌 **Konsep OOP yang Saya Gunakan**
| **Konsep**         | **Implementasi dalam Game**                                  |
|-------------------|-------------------------------------------------------------|
| **Encapsulation** | Atribut `nama`, `kesehatan`, dan `jenisSerangan` dibuat `private` dan hanya bisa diakses lewat metode `getter` & `setter`. |
| **Inheritance**   | `Pahlawan` dan `Musuh` mewarisi atribut & metode dari `KarakterGame`. |
| **Method Overriding** | Metode `serang()` diubah agar masing-masing karakter memiliki cara serangan berbeda. |
| **Polymorphism**  | `serang()` dapat dipanggil dari referensi `KarakterGame`, tetapi eksekusinya sesuai dengan subclass masing-masing. |

---

## 🚀 **Kesimpulan**
Saya menggunakan pendekatan OOP untuk membuat game ini **modular, fleksibel, dan adil**. Dengan **damage random, input dinamis, dan sistem ronde**, permainan menjadi lebih seru dan bisa disesuaikan sesuai keinginan pemain.