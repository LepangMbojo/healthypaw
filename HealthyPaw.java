import java.util.Scanner;

public class HealthyPaw {
    Scanner scanner = new Scanner(System.in);

    void tampilanAwal(){
        while (true) {
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         LOG-IN          | |");
            System.out.println("|+|=========================|+|");
            System.out.println("| |         SIG-UP          | |");
            System.out.println("|+|=========================|+|");

            System.out.print("FITUR: ");
            String answer = scanner.nextLine();
            
            if (answer.equalsIgnoreCase("log-in")){
                System.out.println("A");
                break;
            }
            else if (answer.equalsIgnoreCase("sign-uP")){
                System.out.println("B");
                break;
            }
            else {
                System.out.println("Errorr");
            }
        }
    }

    public void main(String[] args) {
        tampilanAwal();
    }
    
}