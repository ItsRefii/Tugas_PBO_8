import java.util.Scanner;
import model.buku;

public class array {
    public static void main(String[] args) {
        buku[] koleksiBuku = new buku[5];
        koleksiBuku[0] = new buku("Laskar Pelangi", "Andrea Hirata", 2005, false);
        koleksiBuku[1] = new buku("Bumi Manusia", "Pramoedya Ananta Toer", 1980, false);
        koleksiBuku[2] = new buku("5 cm", "Donny Dhirgantoro", 2005, false);
        koleksiBuku[3] = new buku("Negeri 5 Menara", "Ahmad Fuadi", 2009, false);
        koleksiBuku[4] = new buku("Ayat-Ayat Cinta", "Habiburrahman El Shirazy", 2004, false);

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== SISTEM PERPUSTAKAAN =====");
            System.out.println("1. Lihat semua Buku");
            System.out.println("2. Cari Buku berdasarkan judul");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Buku ---");
                    for (buku b : koleksiBuku) {
                        b.getDetailBook();
                    }
                    break;

                case 2:
                    System.out.print("Masukkan judul Buku yang dicari: ");
                    String cari = input.nextLine();
                    boolean ditemukan = false;
                    for (buku b : koleksiBuku) {
                        if (b.judul.equalsIgnoreCase(cari)) {
                            System.out.println("\nBuku ditemukan:");
                            b.getDetailBook();
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Buku dengan judul \"" + cari + "\" tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan judul Buku yang ingin dipinjam: ");
                    String pinjam = input.nextLine();
                    boolean ada = false;

                    for (buku b : koleksiBuku) {
                        if (b.judul.equalsIgnoreCase(pinjam)) {
                            ada = true;
                            if (!b.isDipinjam) {
                                b.isDipinjam = true;
                                System.out.println("Buku \"" + b.judul + "\" berhasil dipinjam!");
                            } else {
                                System.out.println("Maaf, buku \"" + b.judul + "\" sedang dipinjam orang lain.");
                            }
                            break;
                        }
                    }

                    if (!ada) {
                        System.out.println("Buku tidak ditemukan di koleksi.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan judul Buku yang dikembalikan: ");
                    String kembali = input.nextLine();
                    boolean ditemukanKembali = false;

                    for (buku b : koleksiBuku) {
                        if (b.judul.equalsIgnoreCase(kembali)) {
                            ditemukanKembali = true;
                            if (b.isDipinjam) {
                                b.isDipinjam = false;
                                System.out.println("Buku \"" + b.judul + "\" berhasil dikembalikan!");
                            } else {
                                System.out.println("Buku \"" + b.judul + "\" belum pernah dipinjam.");
                            }
                            break;
                        }
                    }

                    if (!ditemukanKembali) {
                        System.out.println("Buku tidak ditemukan di koleksi.");
                    }
                    break;

                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);

        input.close();
    }
}
