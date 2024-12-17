import java.util.Scanner;

public class HealthyPaw {
    Scanner scanner = new Scanner(System.in);
    MenuAwal HPaw = new MenuAwal();
    Konsultasi HPawKonsul = new Konsultasi();

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
                tampilanLogIn();
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
            if (HPaw.login(username, password)){
                tampilanMainMenu();
            }
            else {
                System.out.println("Username atau Password Salah");
            }
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
                HPawKonsul.navigateDoctors();
            }
            else if (answer.equalsIgnoreCase("riwayat")){
                System.out.println("A");
                break;
            }
            else if (answer.equalsIgnoreCase("log-out")){
                tampilanAwal();
            }
            else {
                System.out.println("\nErrorr!!");
            }
        }
    }

    void menuKonsultasi(){
        while (true) {
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |       LIST DOKTER       | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |       CARI DOKTER       | |");
            System.out.println("|+|=========================|+|");
        }
    }

    public void main(String[] args) {
        HPawKonsul.add("Dr. Halid", "Senin 13.00 - 16.00", 27, 50000, 4.5);
        HPawKonsul.add("Dr. Cikey", "Jumat 08.00 - 16.00", 27, 75000, 4.7);
        HPawKonsul.add("Dr. Jaye", "Selasa 13.00 - 20.00", 27, 50000, 4.8);

        System.out.println(HPawKonsul.head.namaDokter);
        System.out.println(HPawKonsul.tail.namaDokter);
        // tampilanAwal();
        HPawKonsul.navigateDoctors();
    }
    
}