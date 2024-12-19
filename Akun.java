public class Akun {
    public String username, password;
    public int saldo;
    public RiwayatUser daftarRiwayat;
    private Akun next;

    public Akun(String username, String password){
        this.username = username;
        this.password = password;
        this.saldo = 0;
        this.next = null;
        this.daftarRiwayat = new RiwayatUser();
    }

    public void setNext(Akun next){
        this.next = next;
    }

    public Akun getNext(){
        return this.next;
    }
}
