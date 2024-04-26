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
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    registrasi();
                    break;
                case "3":
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
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    tambahMobil();
                    break;
                case "2":
                    cls();
                    tampilkanMobil(true, "semua");
                    System.out.println("\nTekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case "3":
                    editMobil();
                    break;
                case "4":
                    hapusMobil();
                    break;
                case "5":
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
            System.out.println("2. Tampilkan Berdasarkan Kategori");
            System.out.println("3. Cari Mobil");
            System.out.println("4. Logout");
            System.out.println("===========================================");
            System.out.print("Pilihan Anda : ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cls();
                    tampilkanMobil(true, "semua");
                    System.out.println("\nTekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case "2":
                    cls();
                    tampilKategori();
                    break;
                case "3":
                    cls();
                    menuCari();
                    break;
                case "4":
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
        String username = scanner.nextLine();
        
        if (cekUsername(username)) {
            System.out.println("\n===========================================");
            System.out.println("\nUsername sudah dipakai. Silakan gunakan username lain !");
            TimeUnit.SECONDS.sleep(1);
            cls();
            return;
        }

        System.out.print("Masukkan password : ");
        String password = scanner.nextLine();
        System.out.println("\n===========================================");
        listAkun.add(new Akun(username, password, false));
        System.out.println("\nRegistrasi berhasil !");
        TimeUnit.SECONDS.sleep(1);
    }

    protected static boolean cekUsername(String username) {
        for (Akun akun : listAkun) {
            if (akun.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static Akun login() throws InterruptedException{
        cls();
        System.out.println("===========================================");
        System.out.println("|           Shutoko Performance           |");
        System.out.println("===========================================");
        System.out.print("\nUsername : ");
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
        System.out.print("Brand : ");
        String brand = scanner.nextLine();
        System.out.print("Tipe  : ");
        String tipe = scanner.nextLine();
        System.out.print("Warna : ");
        String warna = scanner.nextLine();
        System.out.print("Tahun : ");
        int tahun = getValidIntegerInput();
        System.out.print("Harga : ");
        int harga = getValidIntegerInput();
      
        String jenis;
        do {
            System.out.print("\nJenis (Bensin/Listrik/Hybrid) : ");
            jenis = scanner.nextLine();
            if (jenis.isEmpty() || (!jenis.toLowerCase().equals("bensin") ^ !jenis.toLowerCase().equals("listrik") ^ !jenis.toLowerCase().equals("hybrid"))) {
                System.out.println("Jenis mobil tidak valid !");
            }
        } while (jenis.isEmpty() || !jenis.toLowerCase().equals("bensin") ^ !jenis.toLowerCase().equals("listrik") ^ !jenis.toLowerCase().equals("hybrid"));

        switch (jenis.toLowerCase()) {
            case "bensin":
                System.out.print("Kapasitas Tangki : ");
                int kapasitasTangki = getValidIntegerInput();
                System.out.print("Konsumsi Bensin  : ");
                int konsBensin = getValidIntegerInput();
                MobilBensin mobilBensin = new MobilBensin(brand, tipe, warna, tahun, harga, "Bensin", kapasitasTangki, konsBensin);
                listMobil.add(mobilBensin);
                break;
            case "listrik":
                System.out.print("Kapasitas Baterai : ");
                int kapasitasBaterai = getValidIntegerInput();
                System.out.print("Konsumsi Baterai  : ");
                int konsBaterai = getValidIntegerInput();
                MobilListrik mobilListrik = new MobilListrik(brand, tipe, warna, tahun, harga, "Listrik", kapasitasBaterai, konsBaterai);
                listMobil.add(mobilListrik);
                break;
            case "hybrid":
                System.out.print("Kapasitas Tangki     : ");
                int kapasitasTangkiHybrid = getValidIntegerInput();
                System.out.print("Kapasitas Baterai    : ");
                int kapasitasBateraiHybrid = getValidIntegerInput();
                
                String regen;
                
                do {
                    System.out.print("Regenerative Braking (Ya/Tidak) : ");
                    regen = scanner.nextLine();
        
                    if (regen.equalsIgnoreCase("ya")) { 
                        regen = "Support";                       
                        break; 
                    } else if (regen.equalsIgnoreCase("tidak")) {                        
                        regen = "Not Support";
                        break; 
                    } else {
                        System.out.println("Masukkan tidak valid. Harap masukkan 'ya' atau 'tidak'.");
                    }
                } while (true);

                MobilHybrid mobilHybrid = new MobilHybrid(brand, tipe, warna, tahun, harga, "Hybrid", kapasitasTangkiHybrid, kapasitasBateraiHybrid, regen);
                listMobil.add(mobilHybrid);
                break;
        }
        
        System.out.println("\n===========================================");
        System.out.println("Mobil berhasil ditambahkan !");
        TimeUnit.SECONDS.sleep(1);
    }

    private static void tampilkanMobil(boolean header, String jenis) {
        if (header == true){
            System.out.println("===========================================");
            System.out.println("|      List Mobil Shutoko Performance     |");
            System.out.println("===========================================");
        }
        if (listMobil.isEmpty() && jenis == "semua") {
            System.out.println("Tidak ada mobil yang tersedia !");
        } 

        boolean found = false;
        int i = 1;
        for (Mobil mobil : listMobil) {
            if (jenis.equalsIgnoreCase("semua")) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            } else if (jenis.equalsIgnoreCase("bensin") && mobil instanceof MobilBensin) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            } else if (jenis.equalsIgnoreCase("listrik") && mobil instanceof MobilListrik) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            } else if (jenis.equalsIgnoreCase("hybrid") && mobil instanceof MobilHybrid) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            }
        }

        if (!found && jenis != "semua") {
            System.out.println("Tidak ada jenis mobil " + jenis + " yang tersedia !");
        }
    }

    // Overloading method tampilkanMobil untuk pencarian berdasarkan tipe
    private static void tampilkanMobil(String tipe, boolean isTipe) {
        if (isTipe) {
            cls();
            System.out.println("===========================================");
            System.out.println("|      List Mobil Shutoko Performance     |");
            System.out.println("===========================================");
            boolean found = false;
            int i = 1;
            for (Mobil mobil : listMobil) {
                if (mobil.getTipe().toLowerCase().contains(tipe.toLowerCase())) {
                    found = true;
                    System.out.println("\nMobil ke-" + i++ + "        \n");
                    mobil.tampilInformasi();
                    System.out.println("\n-------------------------------------------");
                }
            }

            if (!found) {
                System.out.println("Tidak ada mobil dengan brand " + tipe + " yang tersedia !");
            }   
        }
    }

    // Overloading method tampilkanMobil untuk pencarian berdasarkan brand
    private static void tampilkanMobil(String brand) {
        cls();
        System.out.println("===========================================");
        System.out.println("|      List Mobil Shutoko Performance     |");
        System.out.println("===========================================");
        
    
        boolean found = false;
        int i = 1;
        for (Mobil mobil : listMobil) {
            if (mobil.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            }
        }   
        if (!found) {
            System.out.println("Tidak ada mobil dengan brand " + brand + " yang tersedia !");
        }
    }
    
    // Overloading method tampilkanMobil untuk pencarian berdasarkan tahun
    private static void tampilkanMobil(int tahun) {
        cls();
        System.out.println("===========================================");
        System.out.println("|      List Mobil Shutoko Performance     |");
        System.out.println("===========================================");
        boolean found = false;
        int i = 1;
        for (Mobil mobil : listMobil) {
            if (mobil.getTahun() == tahun) {
                found = true;
                System.out.println("\nMobil ke-" + i++ + "        \n");
                mobil.tampilInformasi();
                System.out.println("\n-------------------------------------------");
            }
        }
        if (!found) {
            System.out.println("Tidak ada mobil yang diproduksi pada tahun " + tahun + " yang tersedia !");
        }
    }

    public static void tampilKategori() throws InterruptedException {
        boolean isRunning = true;
        while (isRunning) {
            cls();
            System.out.println("===========================================");
            System.out.println("|           Shutoko Performance           |");
            System.out.println("===========================================");
            System.out.println("1. Tampilkan Mobil Bensin");
            System.out.println("2. Tampilkan Mobil Listrik");
            System.out.println("3. Tampilkan Mobil Hybrid");
            System.out.println("4. Kembali");
            System.out.println("===========================================");
            System.out.print("Pilihan Anda : ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    cls();
                    tampilkanMobil(true, "bensin");
                    System.out.println("\nTekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case "2":
                    cls();
                    tampilkanMobil(true, "listrik");
                    System.out.println("\nTekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case "3":
                    cls();
                    tampilkanMobil(true, "hybrid");
                    System.out.println("\nTekan enter untuk kembali ke menu !");
                    scanner.nextLine();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid !");
                    TimeUnit.SECONDS.sleep(1);
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
        tampilkanMobil(false, "semua");
        System.out.print("Pilih nomor mobil yang akan diedit : ");
        int index = getValidIntegerInput();
        index -= 1;
        if (index < 0 || index >= listMobil.size()) {
            System.out.println("Nomor mobil tidak valid !");
            TimeUnit.SECONDS.sleep(1);
            return;
        }

        Mobil mobil = listMobil.get(index);
        System.out.print("\nBrand : ");
        String brand = scanner.nextLine();
        System.out.print("Tipe  : ");
        String tipe = scanner.nextLine();
        System.out.print("Warna : ");
        String warna = scanner.nextLine();
        System.out.print("Tahun : ");
        String tahunInput = scanner.nextLine();
        System.out.print("Harga : ");
        String hargaInput = scanner.nextLine();

        if (!brand.isEmpty()) {
            mobil.setBrand(brand);
        }
        if (!tipe.isEmpty()) {
            mobil.setTipe(tipe);
        }
        if (!warna.isEmpty()) {
            mobil.setWarna(warna);
        }
        if (!tahunInput.isEmpty()) {
            int tahun = Integer.parseInt(tahunInput);
            mobil.setTahun(tahun);
        }
        if (!hargaInput.isEmpty()) {
            int harga = Integer.parseInt(hargaInput);
            mobil.setHarga(harga);
        }

        if (mobil instanceof MobilBensin) {
            MobilBensin mobilBensin = (MobilBensin) mobil;
            System.out.print("\nKapasitas Tangki : ");
            String inpTangki = scanner.nextLine();
            System.out.print("Konsumsi Bensin   : ");
            String inpBensin = scanner.nextLine();
           
            if (!inpTangki.isEmpty()) {
                int tangki = Integer.parseInt(inpTangki);
                mobilBensin.setKapasitasTangki(tangki);
            }
            if (!inpBensin.isEmpty()) {
                int bensin = Integer.parseInt(inpBensin);
                mobilBensin.setKonsBensin(bensin);
            }
        } else if (mobil instanceof MobilListrik) {
            MobilListrik mobilListrik = (MobilListrik) mobil;
            System.out.print("\nKapasitas Baterai : ");
            String inpBaterai = scanner.nextLine();
            System.out.print("Konsumsi Baterai  : ");
            String inpKonsBaterai = scanner.nextLine();
           
            if (!inpBaterai.isEmpty()) {
                int baterai = Integer.parseInt(inpBaterai);
                mobilListrik.setKapasitasBaterai(baterai);
            }
            if (!inpKonsBaterai.isEmpty()) {
                int konsBaterai = Integer.parseInt(inpKonsBaterai);
                mobilListrik.setKapasitasBaterai(konsBaterai);
            }
        } else if (mobil instanceof MobilHybrid) {
            MobilHybrid mobilHybrid = (MobilHybrid) mobil;
            System.out.print("\nKapasitas Tangki : ");
            String inpTangki = scanner.nextLine();
            System.out.print("Kapasitas Baterai : ");
            String inpBaterai = scanner.nextLine();
            System.out.print("Regenerative Braking (Ya/Tidak) : ");
            String regen = scanner.nextLine();
            if (regen.equalsIgnoreCase("ya")) { 
                regen = "Support";  
                mobilHybrid.setRegen(regen);                                             
            } else if (regen.equalsIgnoreCase("tidak")) {                        
                regen = "Not Support";                        
                mobilHybrid.setRegen(regen);                                             
            }
           
            if (!inpTangki.isEmpty()) {
                int tangki = Integer.parseInt(inpTangki);
                mobilHybrid.setKapasitasTangki(tangki);
            }
            if (!inpBaterai.isEmpty()) {
                int baterai = Integer.parseInt(inpBaterai);
                mobilHybrid.setKapasitasBaterai(baterai);
            }
        }

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
        tampilkanMobil(false, "semua");
        System.out.print("Pilih nomor mobil yang akan dihapus : ");
        int index = getValidIntegerInput();
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

    public static void menuCari() throws InterruptedException {
        System.out.println("===========================================");
        System.out.println("|            Menu Pencarian Mobil         |");
        System.out.println("===========================================");
        System.out.println("1. Cari berdasarkan Tipe");
        System.out.println("2. Cari berdasarkan Brand");
        System.out.println("3. Cari berdasarkan Tahun");
        System.out.println("4. Kembali ke Menu Utama");
        System.out.println("===========================================");
        System.out.print("Pilihan Anda : ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Masukkan Tipe Mobil : ");
                String tipe = scanner.nextLine();
                tampilkanMobil(tipe, true);
                System.out.println("\nTekan enter untuk kembali ke menu !");
                scanner.nextLine();
                break;
            case "2":
                System.out.print("Masukkan Brand Mobil : ");
                String brand = scanner.nextLine();
                tampilkanMobil(brand);
                System.out.println("\nTekan enter untuk kembali ke menu !");
                scanner.nextLine();
                break;
            case "3":
                System.out.print("Masukkan Tahun Mobil : ");
                int tahun = getValidIntegerInput();
                tampilkanMobil(tahun);
                System.out.println("\nTekan enter untuk kembali ke menu !");
                scanner.nextLine();
                break;
            case "4":
                menuUser();
                break;
            default:
                System.out.println("Pilihan tidak valid !");
                TimeUnit.SECONDS.sleep(1);
        }
    }    

    // Default access modifier
    static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int getValidIntegerInput() {
        int input = 0;
        boolean isValid = false;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("\nInput harus berupa angka !");
                System.out.print("Input : ");
            }
        } while (!isValid);
        return input;
    }
}
