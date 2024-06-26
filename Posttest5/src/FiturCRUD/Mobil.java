package FiturCRUD;

public abstract class Mobil {
    private String brand;
    private String tipe;
    private String warna;
    private int harga;
    private int tahun;
    private String jenis;

    public Mobil(String brand, String tipe, String warna, int tahun, int harga, String jenis){
        this.brand = brand;
        this.tipe = tipe;
        this.warna = warna;
        this.tahun = tahun;
        this.harga = harga;
        this.jenis = jenis;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBrand() {
        return brand;
    }

    public String getTipe() {
        return tipe;
    }

    public String getWarna() {
        return warna;
    }

    public int getHarga() {
        return harga;
    }

    public int getTahun() {
        return tahun;
    }

    public String getJenis() {
        return jenis;
    }

    public abstract void tampilInformasi();
}