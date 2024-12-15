public class LogIn{
    private Akun head;

    public LogIn() {
        this.head = null;
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
}