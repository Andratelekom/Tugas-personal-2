// Queue.java (FIFO)
public class Queue {
    private Node front, rear;
    private int size;

    // Tambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, double total) {
        Node baru = new Node(kode, nama, total);
        if (rear == null) front = rear = baru;
        else { rear.next = baru; rear = baru; }
        size++;
    }

    // Ambil pelanggan dari depan antrian
    public Node dequeue() {
        if (front == null) return null;
        Node n = front;
        front = front.next;
        if (front == null) rear = null;
        n.next = null;
        size--;
        return n;
    }

    public boolean adaKode(String kode) {
        for (Node c = front; c != null; c = c.next)
            if (c.kode.equalsIgnoreCase(kode)) return true;
        return false;
    }

    // Tampilkan antrian dari depan ke belakang
    public void tampil() {
        if (front == null) { System.out.println("Antrian kosong."); return; }
        System.out.println("Antrian saat ini:");
        int i = 1;
        for (Node c = front; c != null; c = c.next)
            System.out.printf("%d. %s | %s | Rp%,.0f%n", i++, c.kode, c.nama, c.total);
        System.out.println("Jumlah antrian: " + size);
    }

    public int getSize() { return size; }
}