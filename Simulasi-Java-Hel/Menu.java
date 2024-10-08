package PerbaikanSimulasiUTS;

public class Menu{
    private String kodeMenu;
    private String namaMenu;
    private int harga;

    public Menu(String kodeMenu, String namaMenu, int harga) {
        this.kodeMenu = kodeMenu;
        this.namaMenu = namaMenu;
        this.harga = harga;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getHarga() {
        return harga;
    }
}

