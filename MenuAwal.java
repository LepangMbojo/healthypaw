public class MenuAwal {
    private Akun head, tail;

    public void signUp(String username, String password){
        Akun addAkun  = new Akun(username, password);
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
}
