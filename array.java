import java.util.Scanner;
import model.buku;

public class array {
    public static void main(String[] args) {
        buku[] koleksiBuku = new buku[5];
        koleksiBuku[0] = new buku("The Great Gatsby", "F. Scott Fitzgerald", "Scribner", 1925, true);
        koleksiBuku[1] = new buku("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, true);
        koleksiBuku[2] = new buku("1984", "George Orwell", "Secker & Warburg", 1949, true);
        koleksiBuku[3] = new buku("Pride and Prejudice", "Jane Austen", "T. Egerton", 1813, true);
        koleksiBuku[4] = new buku("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, true);

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Perpustakaan Sederhana ===");
            System.out.println("1. Lihat Koleksi Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            if (input.hasNextInt()) {
                pilihan = input.nextInt();
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                input.next();
                pilihan = -1;
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Koleksi Buku ===");
                    for (int i = 0; i < koleksiBuku.length; i++) {
                        String status = koleksiBuku[i].isTersedia() ? " (Tersedia)" : " (Dipinjam)";
                        System.out.println((i + 1) + ". " + koleksiBuku[i].getJudul() + status);
                    }
                    break;

                case 2:
                    input.nextLine();
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String judulCari = input.nextLine();
                    boolean found = false;
                    System.out.println();
                    for (buku b : koleksiBuku) {
                        if (b.getJudul().equalsIgnoreCase(judulCari)) {
                            b.getDetailBook();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nomor buku yang ingin dipinjam: ");
                    if (input.hasNextInt()) {
                        int pinjamIndex = input.nextInt() - 1;
                        if (pinjamIndex >= 0 && pinjamIndex < koleksiBuku.length) {
                            buku b = koleksiBuku[pinjamIndex];
                            if (b.isTersedia()) {
                                b.setTersedia(false);
                                System.out.println("Buku '" + b.getJudul() + "' berhasil dipinjam.");
                            } else {
                                System.out.println("Maaf, buku '" + b.getJudul() + "' sedang tidak tersedia.");
                            }
                        } else {
                            System.out.println("Nomor buku tidak valid.");
                        }
                    } else {
                        System.out.println("Input tidak valid. Silakan masukkan nomor buku.");
                        input.next();
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nomor buku yang ingin dikembalikan: ");
                    if (input.hasNextInt()) {
                        int kembaliIndex = input.nextInt() - 1;
                        if (kembaliIndex >= 0 && kembaliIndex < koleksiBuku.length) {
                            buku b = koleksiBuku[kembaliIndex];
                            if (!b.isTersedia()) {
                                b.setTersedia(true);
                                System.out.println("Buku '" + b.getJudul() + "' berhasil dikembalikan.");
                            } else {
                                System.out.println("Buku '" + b.getJudul() + "' sudah tersedia/belum pernah dipinjam.");
                            }
                        } else {
                            System.out.println("Nomor buku tidak valid.");
                        }
                    } else {
                        System.out.println("Input tidak valid. Silakan masukkan nomor buku.");
                        input.next(); 
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan perpustakaan sederhana. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
