public class Akun {
    public String username, password;
    private Akun next;

    public Akun(String username, String password){
        this.username = username;
        this.password = password;
        this.next = null;
    }

    public void setNext(Akun next){
        this.next = next;
    }

    public Akun getNext(){
        return this.next;
    }
}
