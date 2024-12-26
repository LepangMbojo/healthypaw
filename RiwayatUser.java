import java.util.Scanner;
public class RiwayatUser {
    private Riwayat top;

    public void header(){
        System.out.println("|+|=========================|+|");
        System.out.println("| |  /\\___/\\                | |"  );
        System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
        System.out.println("| |   > ^ <                 | |");
    }

    public void push(String namaDokter, String jenisHewan, int biayaKonsul, String status) {
        Riwayat newRiwayat = new Riwayat(namaDokter, jenisHewan, status, biayaKonsul);
        if (isEmpty()){
            top = newRiwayat;
        }
        else {
            newRiwayat.setNext(top);
            top = newRiwayat;
        }
    }

    public Riwayat pop() {
        if (isEmpty()) {
            return null;
        }
        Riwayat riwayatPop = top;
        top = top.getNext();
        return riwayatPop;
    }

    public void clear() {
        Riwayat current = top;
        while (current != null) {
            current = current.getNext();
            pop();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayRiwayat() {
        header();
        if (isEmpty()) {
            System.out.println("|+|=========================|+|");
            System.out.println("|+|    TIDAK ADA RIWAYAT    |+|");
            System.out.println("|+|=========================|+|");
            return;
        }
        System.out.println("|+|=========================|+|");
        System.out.println("|+|    RIWAYAT KONSULTASI   |+|");
        System.out.println("|+|=========================|+|");

        Riwayat current = top;
        while (current != null) {
            System.out.println("|+|=========================|+|");
            System.out.println("   Nama Dokter : " + current.namaDokter);
            System.out.println("   Jenis Hewan : " + current.jenisHewan);
            System.out.println("   Biaya Konsul: Rp " + current.biayaKonsul);
            System.out.println("   Status      : " + current.status);
            System.out.println("|+|=========================|+|");
            current = current.getNext();
        }
        while (true){
            System.out.print("Back/Clear : ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("back")){
                break;
            }
            else if (answer.equalsIgnoreCase("clear")){
                clear();
                break;
            }
            else {
                System.out.println("Error!!!");
            }
        }
        
    }
}