public class Riwayat {
    public String namaDokter;
    public String tanggal;
    public int biayaKonsul;
    public Riwayat next;

    public Riwayat(String namaDokter, String tanggal, int biayaKonsul) {
        this.namaDokter = namaDokter;
        this.tanggal = tanggal;
        this.biayaKonsul = biayaKonsul;
        this.next = null;
    }
}