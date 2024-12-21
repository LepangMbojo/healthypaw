public class Antrian {
    public String username, jenisHewan;
    public double umur, beratHewan;
    private Antrian next;

    public Antrian(String username, String jenisHewan, double umur, double beratHewan){
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
