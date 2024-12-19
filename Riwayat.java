public class Riwayat {
    public String namaDokter, jenisHewan, status;
    public int biayaKonsul;
    private Riwayat next;

    public Riwayat(String namaDokter, String jenisHewan, String status, int biayaKonsul){
        this.namaDokter = namaDokter;
        this.jenisHewan = jenisHewan;
        this.status = status;
        this.biayaKonsul = biayaKonsul;
        this.next = null;
    }

    public void setNext(Riwayat next){
        this.next = next;
    }

    public Riwayat getNext(){
        return this.next;
    }
}