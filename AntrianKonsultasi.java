import java.util.Scanner;
public class AntrianKonsultasi {
    Scanner scanner = new Scanner(System.in);
    Antrian front, rear;
    DiagnosaTree diagnosa = new DiagnosaTree();

    public void enqueue(String username, String jenisHewan, double umur, double beratHewan) {
        Antrian newAntrian = new Antrian(username, jenisHewan, umur, beratHewan);
        if (rear == null) {
            front = newAntrian;
            rear = newAntrian;
        } else {
            rear.setNext(newAntrian);
            rear = newAntrian;
        }
    }

    public Antrian dequeue(){
        Antrian antrianNode = null;
        if (front == null){
            System.out.println("Antrian anda kosong");
        } 
        else {
            antrianNode = front;
            front = front.getNext();
        }
        return antrianNode;
    }

    public void daftar(Akun user){
        System.out.print("Masukkan Jenis Hewan: ");
        String jenisHewan = scanner.nextLine();
        System.out.print("Masukkan Umur Hewan: ");
        double umurHewan = scanner.nextDouble();
        System.out.print("Masukkan Berat Hewan: ");
        double beratHewan = scanner.nextDouble();
        enqueue(user.username, jenisHewan, umurHewan, beratHewan);
    }

    public void display(Akun user, DokterHewan dokter) {
        while (true) {
            System.out.println("|+|=========================|+|");
            System.out.println("| |  /\\___/\\                | |"  );
            System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
            System.out.println("| |   > ^ <                 | |");
            System.out.println("|+|=========================|+|");
            if (front == null) {
                System.out.println("  Antrian Kosong");
            }
            Antrian current = front;

            int count = 1;
            while (current != null) {
                System.out.println("   " + count + " | " + current.username + " | Jenis Hewan: " + current.jenisHewan + " | Umur: " + current.umur + " Tahun | Berat: " + current.beratHewan + " Kg");
                count++;
                current = current.getNext();
            }

            System.out.print("Back/Daftar/Next: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("daftar")){
                System.out.print("Melakukan Pembayaran (Ya/Tidak): ");
                String answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("ya")){
                    if (pembayaran(user, dokter)){
                        daftar(user);
                    }
                    else {
                        System.out.println("Dana Tidak Mencukupi");
                    }
                    answer = scanner.nextLine();
                }
            }   
            else if (choice.equalsIgnoreCase("back")){
                break;
            }
            else if (choice.equalsIgnoreCase("next")){
                Antrian antrianNode = dequeue();
                if (user.username == antrianNode.username){
                    diagnosa.Diagnosis(dokter);
                    user.daftarRiwayat.push(dokter.namaDokter, antrianNode.jenisHewan, dokter.biayaKonsul, "SELESAI");
                    break;
                }
            }
            else {
                System.out.println("Error!!");
            }
        }
    }

    public boolean pembayaran(Akun user, DokterHewan dokter){
        if (user.saldo >= dokter.biayaKonsul){
            user.saldo -= dokter.biayaKonsul;
            return true;
        }
        return false;
    }
}

