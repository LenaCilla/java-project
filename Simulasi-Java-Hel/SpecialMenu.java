package PerbaikanSimulasiUTS;

class SpecialMenu extends Menu {
    private int diskon;

    public SpecialMenu(String kodeMenu, String namaMenu, int harga, int diskon) {
        super(kodeMenu, namaMenu, harga);
        this.diskon = diskon;
    }

    public int getDiskon() {
        return diskon;
    }
}

