import java.util.Scanner;

public class HealthyPaw {
    Scanner scanner = new Scanner(System.in);
    MenuAwal HPaw = new MenuAwal();

    void tampilanAwal(){
        while (true) {
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         LOG-IN          | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         SIGN-UP         | |");
            System.out.println("|+|=========================|+|");

            System.out.print("FITUR: ");
            String answer = scanner.nextLine();
            
            if (answer.equalsIgnoreCase("log-in")){
                System.out.println("A");
                break;
            }
            else if (answer.equalsIgnoreCase("sign-uP")){
                tampilanSignUp();
            }
            else {
                System.out.println("\nErrorr!!");
            }
        }
    }

    void tampilanSignUp(){
        while (true){
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         SIGN-UP         | |");
            System.out.println("|+|=========================|+|");
            System.out.print("   Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("   Masukkan Password: ");
            String password = scanner.nextLine();

            if (HPaw.checkUsername(username)){
                HPaw.signUp(username, password);
                System.out.println("\n  Akun berhasil didaftarkan!! ");
                break;
            }
            else {
                System.out.println("\n  Username telah digunakan. Silakan pilih username yang lain!!");
            }
        }
    }

    void tampilanLogIn(){
        while (true){
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         LOG-IN          | |");
            System.out.println("|+|=========================|+|");
            System.out.print("   Masukkan Username: ");
            String username = scanner.nextLine();
            System.out.print("   Masukkan Password: ");
            String password = scanner.nextLine();
        }
    }

    void tampilanMainMenu(){
        while (true){
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |        KONSULTASI       | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         RIWAYAT         | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         LOG-OUT         | |");
            System.out.println("|+|=========================|+|");
            System.out.print("FITUR: ");
            String answer = scanner.nextLine();
            
            if (answer.equalsIgnoreCase("konsultasi")){
                System.out.println("A");
                break;
            }
            else if (answer.equalsIgnoreCase("riwayat")){
                System.out.println("A");
                break;
            }
            else if (answer.equalsIgnoreCase("log-out")){
                System.out.println("A");
            }
            else {
                System.out.println("\nErrorr!!");
            }
        }
    }

    public void main(String[] args) {
        tampilanAwal();
    }
    
}