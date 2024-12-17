public class Antrian {
    public String username, jenisHewan;
    public int umur, beratHewan;
    private Antrian next;

    public Antrian(String username, String jenisHewan, int umur, int beratHewan){
        this.username = username;
        this.jenisHewan = jenisHewan;
        this.umur = umur;
        this.beratHewan = beratHewan;
        this.next = null;
    }

    public void setNext(Antrian next){
        this.next = next;
    }

    public Antrian getNext(){
        return this.next;
    }
}
