public class RiwayatUser {
    private Riwayat top;

    public RiwayatUser() {
        this.top = null;
    }
    public void push(String namaDokter, String tanggal, int biayaKonsul) {
        Riwayat newNode = new Riwayat(namaDokter, tanggal, biayaKonsul);
        newNode.next = top;
        top = newNode;
    }
    public Riwayat pop() {
        if (isEmpty()) {
            return null;
        }
        Riwayat poppedNode = top;
        top = top.next;
        return poppedNode;
    }
    public void clear() {
        top = null;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void displayRiwayat() {
        if (isEmpty()) {
            System.out.println("╔══════════════════════════╗");
            System.out.println("║ Tidak ada riwayat.       ║");
            System.out.println("╚══════════════════════════╝");
            return;
        }

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         RIWAYAT KONSULTASI        ║");
        System.out.println("╚════════════════════════════════════╝");

        Riwayat current = top;
        int index = 1;
        while (current != null) {
            System.out.println("\n==============================================");
            System.out.println("Riwayat ke-" + index);
            System.out.println("Nama Dokter : " + current.namaDokter);
            System.out.println("Tanggal     : " + current.tanggal);
            System.out.println("Biaya Konsul: Rp " + current.biayaKonsul);
            System.out.println("==============================================");
            
            current = current.next;
            index++;
        }
    }
    public Riwayat peek() {
        return top;
    }
    public int size() {
        int count = 0;
        Riwayat current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}