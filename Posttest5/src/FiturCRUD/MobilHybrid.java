package FiturCRUD;

public final class MobilHybrid extends Mobil {
    private int kapasitasTangki;
    private int kapasitasBaterai;
    private String fiturRegen;

    public MobilHybrid(String brand, String tipe, String warna, int tahun, int harga, String jenis, int kapasitasTangki, int kapasitasBaterai, String fiturRegen) {
        super(brand, tipe, warna, tahun, harga, jenis);
        this.kapasitasTangki = kapasitasTangki;
        this.kapasitasBaterai = kapasitasBaterai;
        this.fiturRegen = fiturRegen;
    }

    public int getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(int kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public int getKapasitasBaterai() {
        return kapasitasBaterai;
    }
    
    public void setKapasitasBaterai(int kapasitasBaterai) {
        this.kapasitasBaterai = kapasitasBaterai;
    }
   
    public String getRegen() {
        return fiturRegen;
    }

    public void setRegen(String fiturRegen) {
        this.fiturRegen = fiturRegen;
    }

    @Override
    public final void tampilInformasi() {
        System.out.println("Brand Mobil  : " + this.getBrand());
        System.out.println("Tipe Mobil   : " + this.getTipe());
        System.out.println("Warna Mobil  : " + this.getWarna());
        System.out.println("Tahun Mobil  : " + this.getTahun());
        System.out.println("Jenis Mobil  : " + this.getJenis());
        System.out.println("Harga Mobil  : Rp." + this.getHarga());
        System.out.println("\nKapasitas bensin     : " + this.kapasitasTangki + " L");
        System.out.println("Kapasitas baterai    : " + this.kapasitasBaterai + " kWh");
        System.out.println("Regenerative Braking : " + this.fiturRegen);
    }
}
