package FiturCRUD;

public class MobilListrik extends Mobil {
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
    public void tampilInformasi() {
        super.tampilInformasi();
        System.out.println("\nKapasitas baterai : " + this.kapasitasBaterai + " kWh");
        System.out.println("Konsumsi baterai  : " + this.konsBaterai + " KM/kWh");
    }
}
