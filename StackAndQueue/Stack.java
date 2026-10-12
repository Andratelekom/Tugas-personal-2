// Stack.java (LIFO)
public class Stack {
    private Node top;
    private int size;

    // Simpan transaksi baru di puncak stack
    public void push(Node data) {
        Node baru = new Node(data.kode, data.nama, data.total);
        baru.next = top;
        top = baru;
        size++;
    }

    // Tampilkan transaksi dari terbaru ke terlama
    public void display() {
        if (top == null) { System.out.println("Belum ada riwayat transaksi."); return; }
        System.out.println("Riwayat Transaksi (terbaru di atas):");
        int i = 1;
        for (Node c = top; c != null; c = c.next)
            System.out.printf("%d. %s | %s | Rp%,.0f%n", i++, c.kode, c.nama, c.total);
        System.out.println("Total transaksi: " + size);
    }
}