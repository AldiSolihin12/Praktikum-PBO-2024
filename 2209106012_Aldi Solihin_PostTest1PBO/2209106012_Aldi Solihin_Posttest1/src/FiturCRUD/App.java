package FiturCRUD;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    private static ArrayList<Mobil> listMobil = new ArrayList<>();
    private static ArrayList<Akun> listAkun = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException{
        listAkun.add(new Akun("admin", "admin", true));

        boolean isRunning = true;
        while (isRunning) {
            cls();
            System.out.println("===========================================");
            System.out.println("|      Welcome to Shutoko Performance     |");
            System.out.println("===========================================");
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.println("3. Keluar Program");
            System.out.println("===========================================");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    registrasi();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Terima kasih !");
                    break;        
                default:
                    System.out.println("Pilihan tidak valid !");
                    TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    public static void menuAdmin() throws InterruptedException {
        boolean isRunning = true;
        while (isRunning) {
            cls();
            System.out.println("===========================================");
            System.out.println("|        Admin Shutoko Performance        |");
            System.out.println("===========================================");
            System.out.println("1. Tambah Data Mobil");
            System.out.println("2. Tampilkan Data Mobil");
            System.out.println("3. Edit Data Mobil");
            System.out.println("4. Hapus Data Mobil");
            System.out.println("5. Logout");
            System.out.println("===========================================");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tambahMobil();
                    break;
                case 2:
                    cls();
                    scanner.nextLine();
                    tampilkanMobil(true);
                    System.out.println("Tekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case 3:
                    editMobil();
                    break;
                case 4:
                    hapusMobil();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid !");
                    TimeUnit.SECONDS.sleep(1);
            }
        }
    } 

    public static void menuUser() throws InterruptedException {
        boolean isRunning = true;
        while (isRunning) {
            cls();
            System.out.println("===========================================");
            System.out.println("|           Shutoko Performance           |");
            System.out.println("===========================================");
            System.out.println("1. Tampilkan Data Mobil");
            System.out.println("2. Logout");
            System.out.println("===========================================");
            System.out.print("Pilihan Anda : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cls();
                    scanner.nextLine();
                    tampilkanMobil(true);
                    System.out.println("Tekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case 2:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid !");
                    TimeUnit.SECONDS.sleep(1);
            }
        }
    } 

    private static void registrasi() throws InterruptedException {
        cls();
        System.out.println("===========================================");
        System.out.println("|           Shutoko Performance           |");
        System.out.println("===========================================");
        System.out.print("\nMasukkan username : ");
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.print("Masukkan password : ");
        String password = scanner.nextLine();
        System.out.println("\n===========================================");
        listAkun.add(new Akun(username, password, false));
        System.out.println("\nRegistrasi berhasil !");
        TimeUnit.SECONDS.sleep(1);
    }

    private static Akun login() throws InterruptedException{
        cls();
        System.out.println("===========================================");
        System.out.println("|           Shutoko Performance           |");
        System.out.println("===========================================");
        System.out.print("\nUsername : ");
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        System.out.println("\n===========================================");
        
        boolean loginBerhasil = false;

        for (Akun akun : listAkun) {
            if (akun.getUsername().equals(username) && akun.getPassword().equals(password)) {
                System.out.println("\nLogin berhasil, selamat datang di Shutoko Performance !");
                loginBerhasil = true;
                TimeUnit.SECONDS.sleep(1);
                if (akun.isAdmin()) {
                    menuAdmin();
                    break;
                } else {
                    menuUser();
                    break;
                }
            }
        }
        if (!loginBerhasil){
            System.out.println("Login gagal. Periksa kembali username dan password Anda !");
            TimeUnit.SECONDS.sleep(1);
        }
        return null;
    }

    private static void tambahMobil() throws InterruptedException {
        cls();
        System.out.println("===========================================");
        System.out.println("|            Tambah Data Mobil            |");
        System.out.println("===========================================");
        scanner.nextLine();
        System.out.print("Brand : ");
        String brand = scanner.nextLine();
        System.out.print("Tipe  : ");
        String tipe = scanner.nextLine();
        System.out.print("Warna : ");
        String warna = scanner.nextLine();
        System.out.print("Tahun : ");
        int tahun = scanner.nextInt();
        System.out.print("Harga : ");
        int harga = scanner.nextInt();
        Mobil mobil = new Mobil(brand, tipe, warna, tahun, harga);
        listMobil.add(mobil);
        System.out.println("\n===========================================");
        System.out.println("Mobil berhasil ditambahkan !");
        TimeUnit.SECONDS.sleep(1);
    }

    private static void tampilkanMobil(boolean header) {
        if (header == true){
            System.out.println("===========================================");
            System.out.println("|      List Mobil Shutoko Performance     |");
            System.out.println("===========================================");
        }
        if (listMobil.isEmpty()) {
            System.out.println("Tidak ada mobil yang tersedia !");
        } else { 
            for (int i = 0; i < listMobil.size(); i++) {
                System.out.println("\nMobil ke-"+ (i+1) + "        ");
                System.out.println("Brand Mobil  : " + listMobil.get(i).brand);
                System.out.println("Tipe Mobil   : " + listMobil.get(i).tipe);
                System.out.println("Warna Mobil  : " + listMobil.get(i).warna);
                System.out.println("Tahun Mobil  : " + listMobil.get(i).tahun);
                System.out.println("Harga Mobil  : Rp." + listMobil.get(i).harga);
                System.out.println("\n-------------------------------------------");
            }
        }
    }

    private static void editMobil() throws InterruptedException {
        cls();
        System.out.println("===========================================");
        System.out.println("|             Edit Data Mobil             |");
        System.out.println("===========================================");
        if (listMobil.isEmpty()) {
            System.out.println("Tidak ada data mobil untuk diedit !");
            TimeUnit.SECONDS.sleep(1);
            return;
        }
        tampilkanMobil(false);
        System.out.print("Pilih nomor mobil yang akan diedit : ");
        int index = scanner.nextInt();
        index -= 1;
        if (index < 0 || index >= listMobil.size()) {
            System.out.println("Nomor mobil tidak valid !");
            TimeUnit.SECONDS.sleep(1);
            return;
        }

        scanner.nextLine();
        System.out.print("\nBrand : ");
        String brand = scanner.nextLine();
        System.out.print("Tipe  : ");
        String tipe = scanner.nextLine();
        System.out.print("Warna : ");
        String warna = scanner.nextLine();
        System.out.print("Tahun : ");
        int tahun = scanner.nextInt();
        System.out.print("Harga : ");
        int harga = scanner.nextInt();
        
        Mobil mobilBaru = new Mobil(brand, tipe, warna, tahun, harga);
        listMobil.set(index, mobilBaru);
        System.out.println("\n===========================================");
        System.out.println("Data Mobil berhasil diubah !");
        TimeUnit.SECONDS.sleep(1);
    }

    private static void hapusMobil() throws InterruptedException {
        cls();
        System.out.println("===========================================");
        System.out.println("|            Hapus Data Mobil             |");
        System.out.println("===========================================");
        if (listMobil.isEmpty()) {
            System.out.println("Tidak ada data mobil untuk dihapus !");
            TimeUnit.SECONDS.sleep(1);
            return;
        }
        tampilkanMobil(false);
        System.out.print("Pilih nomor mobil yang akan dihapus : ");
        int index = scanner.nextInt();
        index -= 1;
        if (index < 0 || index >= listMobil.size()) {
            System.out.println("Nomor mobil tidak valid !");
            TimeUnit.SECONDS.sleep(1);
            return;
        }
        listMobil.remove(index);
        System.out.println("\nMobil berhasil dihapus !");
        TimeUnit.SECONDS.sleep(1);
    }

    static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
