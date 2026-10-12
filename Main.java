import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilihan;
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            try { pilihan = Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { pilihan = 0; }
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // Validasi: maksimal 5 karakter dan tidak duplikat
                    if (kode.isEmpty() || kode.length() > 5) {
                        System.out.println("Kode buku harus 1 sampai 5 karakter!");
                        break;
                    }
                    if (list.adaKode(kode)) {
                        System.out.println("Kode buku sudah ada!");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine().trim();
                    list.push(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    if (list.getSize() < 5)
                        System.out.println("Info: minimal 5 buku, saat ini baru " + list.getSize() + ".");
                    break;
                case 2: list.pop(); break;
                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    list.cari(sc.nextLine().trim());
                    break;
                case 4: list.tampil(); break;
                case 5: System.out.println("Terima kasih!"); break;
                default: System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 5);
        sc.close();
    }
}