public class Riwayat {
    public String riwayatUser;
    private Riwayat next;

    public Riwayat(String riwayatUser){
        this.riwayatUser = riwayatUser;
        this.next = null;
    }

    public void setNext(Riwayat next){
        this.next = next;
    }

    public Riwayat getNext(){
        return this.next;
    }
}
