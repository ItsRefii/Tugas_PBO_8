package model;

public class buku {
    public String judul;
    public String penulis;
    public int tahunTerbit;
    public boolean isDipinjam;

    public buku(String judul, String penulis, int tahunTerbit, boolean isDipinjam) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.isDipinjam = isDipinjam;
    }

    public void getDetailBook() {
        System.out.println("Judul       : " + judul);
        System.out.println("Penulis     : " + penulis);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Status      : " + (isDipinjam ? "Sedang Dipinjam" : "Tersedia"));
        System.out.println("----------------------------");
    }
}
