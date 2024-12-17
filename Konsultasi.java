import java.util.Scanner;

public class Konsultasi {
    DokterHewan head,tail;

    public void add(String namaDokter, String jadwal, int umurDokter, int biayaKonsul, double rating) {
        DokterHewan DokterBaru = new DokterHewan(namaDokter, jadwal, umurDokter, biayaKonsul, rating);

        if (head == null) {
            head = DokterBaru;
            tail = DokterBaru;
        } 
        else {
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

    public void navigateDoctors() {
        if (head == null) {
            System.out.println("|+|=========================|+|");
            System.out.println("| |    TIDAK ADA DOKTER     | |");
            System.out.println("|+|=========================|+|");
            return;
        }
    
        DokterHewan current = head;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
    
        while (!exit) {
            
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║       PILIH AKSI         ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1. Next Dokter           ║");
            System.out.println("║ 2. Sebelumnya Dokter     ║");
            System.out.println("║ 3. Cari Dokter           ║");
            System.out.println("║ 4. Keluar                ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Masukkan pilihan (1/2/3/4): ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (choice) {
                case 1:
                    current = displayDoctor(current.getNext());
                    break;
                case 2:
                    current = displayDoctor(current.getPrev());
                    break;
                case 3:
                    System.out.print("Masukkan nama dokter yang ingin dicari: ");
                    String targetName = scanner.nextLine();
                    searchDoctor(targetName);
                    break;
                case 4:
                    exit = true;
                    System.out.println("\nTerima kasih telah menggunakan layanan ini!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan masukkan 1, 2, 3, atau 4.");
            }
        }
    
        scanner.close();
    }
    private DokterHewan displayDoctor(DokterHewan current) {
        if (current == null) {
            return null;
        }
    
        System.out.println("\n==============================================");
        System.out.println("Nama Dokter : " + current.namaDokter);
        System.out.println("Jadwal      : " + current.jadwal);
        System.out.println("Umur        : " + current.umurDokter + " tahun");
        System.out.println("Biaya Konsul: Rp " + current.biayaKonsul);
        System.out.println("Rating      : " + current.rating);
        System.out.println("==============================================");
    
       return current;
    }

    public void searchDoctor(String targetName) {
        if (head == null) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ Tidak ada data dokter.     ║");
            System.out.println("╚════════════════════════════╝");
            return;
        }

        DokterHewan curr = head;

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      HASIL PENCARIAN DOKTER        ║");
        System.out.println("╚════════════════════════════════════╝");

        do {
            if (curr.namaDokter.equalsIgnoreCase(targetName)) {
                System.out.println("\n==============================================");
                System.out.println("Nama Dokter : " + curr.namaDokter);
                System.out.println("Jadwal      : " + curr.jadwal);
                System.out.println("Umur        : " + curr.umurDokter + " tahun");
                System.out.println("Biaya Konsul: Rp " + curr.biayaKonsul);
                System.out.println("Rating      : " + curr.rating);
                System.out.println("==============================================");
                break;
            }
            curr = curr.getNext();
        } while (curr != head); 

    }
}
