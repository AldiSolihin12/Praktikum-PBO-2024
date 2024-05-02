package FiturCRUD;

public final class MobilListrik extends Mobil {
    private int kapasitasBaterai;
    private int konsBaterai;

    public MobilListrik(String brand, String tipe, String warna, int tahun, int harga, String jenis, int kapasitasBaterai, int konsBaterai) {
        super(brand, tipe, warna, tahun, harga, jenis);
        this.kapasitasBaterai = kapasitasBaterai;
        this.konsBaterai = konsBaterai;
    }

    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }

    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public int getKonsBaterai() {
        return konsBaterai;
    }

    public void setKonsBaterai(int konsBaterai) {
        this.konsBaterai = konsBaterai;
    }

    @Override
    public final void tampilInformasi() {
        System.out.println("Brand Mobil  : " + getBrand());
        System.out.println("Tipe Mobil   : " + getTipe());
        System.out.println("Warna Mobil  : " + getWarna());
        System.out.println("Tahun Mobil  : " + getTahun());
        System.out.println("Jenis Mobil  : " + getJenis());
        System.out.println("Harga Mobil  : Rp." + getHarga());
        System.out.println("\nKapasitas baterai : " + this.kapasitasBaterai + " kWh");
        System.out.println("Konsumsi baterai  : " + this.konsBaterai + " KM/kWh");
    }
}
