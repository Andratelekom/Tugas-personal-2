// LinkedList.java
public class LinkedList {
    private Node head;
    private int size;

    // Tambah buku di akhir daftar (push)
    public void push(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (head == null) head = baru;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = baru;
        }
        size++;
    }

    // Hapus buku terakhir (pop)
    public void pop() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        Node hapus;
        if (head.next == null) {
            hapus = head;
            head = null;
        } else {
            Node cur = head;
            while (cur.next.next != null) cur = cur.next;
            hapus = cur.next;
            cur.next = null;
        }
        size--;
        System.out.println("Buku terakhir dihapus: " + hapus.kodeBuku + " | " + hapus.judul);
    }

    // Cari buku berdasarkan kode
    public void cari(String kode) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.kodeBuku.equalsIgnoreCase(kode)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode: " + cur.kodeBuku + " | Judul: " + cur.judul + " | Penulis: " + cur.penulis);
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // Cek kode duplikat
    public boolean adaKode(String kode) {
        for (Node cur = head; cur != null; cur = cur.next)
            if (cur.kodeBuku.equalsIgnoreCase(kode)) return true;
        return false;
    }

    // Tampilkan semua buku sesuai urutan input
    public void tampil() {
        if (head == null) {
            System.out.println("Daftar buku kosong.");
            return;
        }
        System.out.println("Daftar Buku:");
        for (Node cur = head; cur != null; cur = cur.next)
            System.out.println("Kode: " + cur.kodeBuku + " | Judul: " + cur.judul + " | Penulis: " + cur.penulis);
        System.out.println("Total Buku: " + size);
    }

    public int getSize() { return size; }
}