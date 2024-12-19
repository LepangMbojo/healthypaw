import java.util.Scanner;

public class HealthyPaw {
    Scanner scanner = new Scanner(System.in);
    MenuUser HPaw = new MenuUser();
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
                tampilanMainMenu(username);
            }
            else {
                System.out.println("Username atau Password Salah");
                System.out.print("Continue/Back: ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("back")){
                    break;
                }
            }
        }
    }

    void tampilanMainMenu(String username){
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
            System.out.println("| |          PROFIL         | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |       TOP UP SALDO      | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         LOG-OUT         | |");
            System.out.println("|+|=========================|+|");
            System.out.print("FITUR: ");
            String answer = scanner.nextLine();
            
            if (answer.equalsIgnoreCase("konsultasi")){
                menuKonsultasi(HPaw.getAkun(username));
            }
            else if (answer.equalsIgnoreCase("riwayat")){
                Akun user = HPaw.getAkun(username);
                user.daftarRiwayat.displayRiwayat();
                answer = scanner.nextLine();
            }
            else if (answer.equalsIgnoreCase("profil")){
                HPaw.profil(HPaw.getAkun(username));
                answer = scanner.nextLine();
            }
            else if (answer.equalsIgnoreCase("top up saldo")){
                System.out.print("Masukkan Nominal: ");
                int topUpSaldo = scanner.nextInt();
                HPaw.topUpSaldo(HPaw.getAkun(username), topUpSaldo);
                answer = scanner.nextLine();
            }
            else if (answer.equalsIgnoreCase("log-out")){
                tampilanAwal();
            }
            else {
                System.out.println("\nErrorr!!");
            }
        }
    }

    void menuKonsultasi(Akun user){
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
            System.out.println("| |          BACK           | |");
            System.out.println("|+|=========================|+|");
            System.out.print("FITUR: ");
            String answer = scanner.nextLine();
            
            if (answer.equalsIgnoreCase("list dokter")){
                HPawKonsul.navigateDoctors(user);
            }
            else if (answer.equalsIgnoreCase("cari dokter")){
                System.out.print("Masukkan Nama Dokter: ");
                String namaDokter = scanner.nextLine();
                HPawKonsul.searchDoctor(namaDokter, user);
            }
            else if (answer.equalsIgnoreCase("back")){
               break;
            }
            else {
                System.out.println("\nErrorr!!");
            }
        }
    }

    public void main(String[] args) {
        HPawKonsul.setDokter();
        tampilanAwal();
    }
}