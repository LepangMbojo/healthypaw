import java.util.Scanner;

public class Konsultasi {
    DokterHewan head,tail;
    Scanner scanner = new Scanner(System.in);

    void header(){
        System.out.println("|+|=========================|+|");
        System.out.println("| |  /\\___/\\                | |"  );
        System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
        System.out.println("| |   > ^ <                 | |");
    }

    public void add(String namaDokter, String jadwal, int umurDokter, int biayaKonsul, double rating) {
        DokterHewan DokterBaru = new DokterHewan(namaDokter, jadwal, umurDokter, biayaKonsul, rating);

        if (head == null) {
            head = DokterBaru;
            tail = DokterBaru;
        } else {
            tail.setNext(DokterBaru);
            DokterBaru.setPrev(tail);
            DokterBaru.setNext(head);
            tail = DokterBaru;
            head.setPrev(tail);
        }
    }

    public void selectionSort() {
        DokterHewan start = head;

        do {
            DokterHewan minNode = start;
            DokterHewan curr = start.getNext();

            while (curr != head) {
                if (curr.rating < minNode.rating) {
                    minNode = curr;
                }
                curr = curr.getNext();
            }

            swapNodeData(start, minNode);

            start = start.getNext();
        } while (start != head);
    }

    public void swapNodeData(DokterHewan node1, DokterHewan node2) {

        String tempnamadokter = node1.namaDokter;
        node1.namaDokter = node2.namaDokter;
        node2.namaDokter = tempnamadokter;

        String tempjadwal = node1.jadwal;
        node1.jadwal = node2.jadwal;
        node2.jadwal = tempjadwal;

        int tempumurDokter = node1.umurDokter;
        node1.umurDokter = node2.umurDokter;
        node2.umurDokter = tempumurDokter;

        int tempbiayaKonsul = node1.biayaKonsul;
        node1.biayaKonsul = node2.biayaKonsul;
        node2.biayaKonsul = tempbiayaKonsul;

        double temprating = node1.rating;
        node1.rating = node2.rating;
        node2.rating = temprating;
    }

    public void navigateDoctors(Akun user) {
        if (head == null) {
            header();
            System.out.println("|+|=========================|+|");
            System.out.println("| |    TIDAK ADA DOKTER     | |");
            System.out.println("|+|=========================|+|");
            return;
        }
        DokterHewan current = head;
        displayDoctor(current);

            while (true) {
            System.out.print("Next/Prev/Back/Enter/Urutkan: ");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("next")){
                current = displayDoctor(current.getNext());
            }
            else if (choice.equalsIgnoreCase("prev")){
                current = displayDoctor(current.getPrev());
            }
            else if (choice.equalsIgnoreCase("enter")){
                current.daftarAntrian.display(user, current);
                break;
            }
            else if (choice.equalsIgnoreCase("back")){
                break;
            }
            else if (choice.equalsIgnoreCase("urutkan")){
                selectionSort();
            }
            else {
                System.out.println("Error!!");
            }
        }
    }

    private DokterHewan displayDoctor(DokterHewan current) {
        if (current == null) {
            return null;
        }
        header();
        System.out.println("|+|=========================|+|");
        System.out.println("   Nama Dokter : " + current.namaDokter);
        System.out.println("   Jadwal      : " + current.jadwal);
        System.out.println("   Umur        : " + current.umurDokter + " Tahun");
        System.out.println("   Biaya Konsul: Rp " + current.biayaKonsul);
        System.out.println("   Rating      : " + current.rating);
        System.out.println("|+|=========================|+|");
    
       return current;
    }

    public void searchDoctor(String targetName, Akun user) {
        while (true){
            header();
            if (head == null) {
                System.out.println("|+|=========================|+|");
                System.out.println("| |    TIDAK ADA DOKTER     | |");
                System.out.println("|+|=========================|+|");
                return;
            }

            DokterHewan current = head;

            System.out.println("|+|=========================|+|");
            System.out.println("| |  HASIL PENCARIAN DOKTER | |");
            System.out.println("|+|=========================|+|");

            do {
                if (current.namaDokter.equalsIgnoreCase(targetName)) {
                    System.out.println("|+|=========================|+|");
                    System.out.println("   Nama Dokter : " + current.namaDokter);
                    System.out.println("   Jadwal      : " + current.jadwal);
                    System.out.println("   Umur        : " + current.umurDokter + " Tahun");
                    System.out.println("   Biaya Konsul: Rp " + current.biayaKonsul);
                    System.out.println("   Rating      : " + current.rating);
                    System.out.println("|+|=========================|+|");
                    break;
                }
                current = current.getNext();
            } while (current != head);  

            System.out.print("Back/Enter: ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("enter")){
                current.daftarAntrian.display(user, current);
            }
            else if (choice.equalsIgnoreCase("back")){
                break;
            }
            else {
                System.out.println("Error!!");
            }
        }
    }

    public void setDokter(){
        add("Dr. Farah", "Rabu 09.00 - 12.00", 32, 60000, 4.6);
        add("Dr. Kamal", "Kamis 10.00 - 13.00", 40, 65000, 4.4);
        add("Dr. Rina", "Senin 08.00 - 11.00", 29, 70000, 4.7);
        add("Dr. Anis", "Selasa 14.00 - 18.00", 35, 50000, 4.9);
        add("Dr. Zaky", "Sabtu 09.00 - 14.00", 33, 75000, 4.5);
        add("Dr. Mira", "Minggu 15.00 - 18.00", 27, 55000, 4.6);
        add("Dr. Dani", "Jumat 07.00 - 11.00", 38, 60000, 4.8);
        add("Dr. Hana", "Kamis 13.00 - 16.00", 30, 70000, 4.4);
        add("Dr. Arya", "Rabu 16.00 - 20.00", 31, 65000, 4.7);
        add("Dr. Siska", "Minggu 08.00 - 12.00", 29, 55000, 4.9);
    }

    public void display(){
        DokterHewan current = head;
        while (current != null){
            System.out.println("|+|=========================|+|");
            System.out.println("   Nama Dokter : " + current.namaDokter);
            System.out.println("   Jadwal      : " + current.jadwal);
            System.out.println("   Umur        : " + current.umurDokter + " Tahun");
            System.out.println("   Biaya Konsul: Rp " + current.biayaKonsul);
            System.out.println("   Rating      : " + current.rating);
            System.out.println("|+|=========================|+|");
            if (current == tail){
                break;
            }
            current = current.getNext();
        }
    }
}
