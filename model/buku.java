package model;

public class buku {
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahunTerbit;
    private boolean tersedia;

    public buku(String judul, String penulis, String penerbit, int tahunTerbit, boolean tersedia) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = tersedia;
    }
    public void getDetailBook() {
        System.out.println("Judul       : " + judul);
        System.out.println("Penulis     : " + penulis);
        System.out.println("Penerbit    : " + penerbit);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Status      : " + (tersedia ? "Tersedia" : "Dipinjam"));
    }
}
