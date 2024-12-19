public class MenuUser {
    private Akun head, tail;

    public void signUp(String username, String password){
        Akun addAkun = new Akun(username, password);
        if (head == null){
            head = addAkun;
            tail = addAkun;
        }
        else {
            tail.setNext(addAkun);
            tail = addAkun;
        }
    }

    public boolean login(String username, String password) {
        Akun current = head;
        while (current != null) {
            if (current.username.equals(username) && current.password.equals(password)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean checkUsername(String username){
        Akun current = head;
        while (current != null) {
            if (current.username.equalsIgnoreCase(username)){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void topUpSaldo(Akun user, int topUpSaldo){
        user.saldo += topUpSaldo;
    }

    public Akun getAkun(String username){
        Akun current = head;
        while (current != null) {
            if (current.username.equalsIgnoreCase(username)){
                break;
            }
            current = current.getNext();
        }
        return current;
    }

    public void profil(Akun user){
        System.out.println("|+|=========================|+|");
        System.out.println("| |  /\\___/\\                | |"  );
        System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
        System.out.println("| |   > ^ <                 | |");
        System.out.println("|+|=========================|+|");
        System.out.println("   Username: " + user.username);
        System.out.println("   Saldo: Rp." + user.saldo);
        System.out.println("|+|=========================|+|");

    }
}
