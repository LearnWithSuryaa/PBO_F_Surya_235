# Login System - Java

## Deskripsi
Program ini adalah sistem login sederhana berbasis Java yang memungkinkan pengguna untuk masuk sebagai Admin atau Mahasiswa. Admin menggunakan username dan password, sedangkan mahasiswa login dengan nama dan NIM yang telah terdaftar.

## Fitur
- **Login sebagai Admin** dengan username dan password yang sudah ditentukan.
- **Login sebagai Mahasiswa** dengan mencocokkan nama dan NIM yang sudah ada dalam database.
- **Validasi input** untuk memastikan hanya data yang valid yang bisa masuk ke sistem.

## Prasyarat
Pastikan Anda memiliki:
- Java Development Kit (JDK) terinstal di komputer Anda.
- Text editor atau IDE seperti VS Code, IntelliJ IDEA, atau Eclipse.

## Cara Menjalankan Program
1. **Kompilasi kode** dengan perintah berikut:
   ```sh
   javac LoginSystem.java
   ```
2. **Jalankan program** dengan perintah berikut:
   ```sh
   java LoginSystem
   ```
3. **Pilih jenis login:**
   - Masukkan `1` untuk login sebagai Admin.
   - Masukkan `2` untuk login sebagai Mahasiswa.
4. **Ikuti instruksi** untuk memasukkan kredensial login.

## Data Login
### Admin
- **Username:** `admin235`
- **Password:** `password235`

### Mahasiswa
| Nama | NIM |
|------|-------------|
| Muhammad Surya | 202410370110235 |
| Ahmad Budi | 202410370110123 |
| King Andi | 202410370110456 |
| Queen Caca | 202410370110789 |

## Struktur Kode
- **Deklarasi data admin** (username & password)
- **Deklarasi data mahasiswa** (nama & NIM dalam array 2D)
- **Input dari pengguna** untuk memilih mode login
- **Login Admin**: Validasi username & password
- **Login Mahasiswa**: Validasi nama & NIM
- **Looping untuk retry** jika login gagal

## Lisensi
Proyek ini bersifat open-source dan dapat digunakan untuk pembelajaran.

