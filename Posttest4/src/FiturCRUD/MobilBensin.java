package FiturCRUD;

public class MobilBensin extends Mobil {
    private int kapasitasTangki;
    private int konsumsiBensin;

    public MobilBensin(String brand, String tipe, String warna, int tahun, int harga, String jenis,int kapasitasTangki, int konsBensin) {
        super(brand, tipe, warna, tahun, harga, jenis);
        this.kapasitasTangki = kapasitasTangki;
        this.konsumsiBensin = konsBensin ;
    }

    public int getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(int kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }
    
    public int getKonsBensin() {
        return konsumsiBensin;
    }

    public void setKonsBensin(int konsBensin) {
        this.konsumsiBensin = konsBensin;
    }

    @Override
    public void tampilInformasi() {
        super.tampilInformasi();
        System.out.println("\nKapasitas bensin  : " + this.kapasitasTangki + " L");
        System.out.println("Konsumsi Bensin   : " + this.konsumsiBensin + " KM/L");
    }
}
