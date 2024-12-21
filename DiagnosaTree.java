import java.util.Scanner;

public class DiagnosaTree {
    public Diagnosa root;
    Scanner scanner = new Scanner(System.in);
    
    public void addNode(String diagnosaPenyakit, Diagnosa parentNode){
        Diagnosa newNode = new Diagnosa(diagnosaPenyakit);
        if (root == null) {
            root = newNode;
            return;
        }

        if (parentNode.getLeft() == null) { 
            parentNode.setLeft(newNode);
        }
        else if (parentNode.getRight() == null) { 
            parentNode.setRight(newNode);
        }
    }

    public void setDiagnosa(){
        addNode("Apakah Hewan Anda Terlihat Lesu atau Tidak Aktif??", root);
        addNode("Apakah Hewan Anda Sering Muntah-Muntah??", root);
        addNode("Apakah Hewan Anda Memiliki Masalah Kulit Seperti Gatal atau Kerontokan Bulu??", root);
        addNode("Apakah Hewan Anda Memiliki Perut yang Buncit atau Berat Badan Menurun??", root.getLeft());
        addNode("Apakah Hewan Anda Demam atau Batuk-Batuk??", root.getLeft());
        addNode("Apakah Kulit Hewan Anda Memiliki Luka Terbuka atau Bernanah??", root.getRight());
        addNode("Hewan Anda Tampak Sehat. Jaga Pola Makan dan Kebersihan.", root.getRight());
        addNode("Hewan Anda Mengalami Cacingan. Segera Berikan Obat Cacing", root.getLeft().getLeft());
        addNode("Hewan Anda Mengalami Keracunan Makanan. Berikan Obat yang Sesuai", root.getLeft().getLeft());
        addNode("Hewan Anda Terkena Virus Seperti Distemper. Segera Bawa Ke Rumah Sakit", root.getLeft().getRight());
        addNode("Hewan Anda Terkena Infeksi Bakteri. Berikan Antibiotik Sesuai Anjuran dari Dokter", root.getLeft().getRight());
        addNode("Hewan Anda Mengalami Infeksi Kulit Seperti Dermatitis atau Jamur. Gunakan Obat Anti Jamur atau Obat yang Telah Diresepkan", root.getRight().getLeft());
        addNode("Hewan Anda Memiliki Alergi Kulit. Hindari Penyebab atau Faktor Pemicu Alergi", root.getRight().getLeft());
    }

    private void startDiagnosa(Diagnosa nodeDiagnosa) {
        if (nodeDiagnosa.getLeft() == null && nodeDiagnosa.getRight() == null) {
            System.out.println(nodeDiagnosa.diagnosaPenyakit);
            return;
        }

        System.out.println(nodeDiagnosa.diagnosaPenyakit);
        System.out.print("Ya/Tidak: ");
        
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("ya")) {
            startDiagnosa(nodeDiagnosa.getLeft());
        } 
        else if (answer.equalsIgnoreCase("tidak")) {
            startDiagnosa(nodeDiagnosa.getRight());
        } 
        else {
            System.out.println("Error!!");
            startDiagnosa(nodeDiagnosa);
        }
    }

    public void Diagnosis(DokterHewan dokter){
        System.out.println("|+|=========================|+|");
        System.out.println("| |  /\\___/\\                | |"  );
        System.out.println("| | ( 0 . 0 )   HEALTHYPAW  | |");
        System.out.println("| |   > ^ <                 | |");
        System.out.println("|+|=========================|+|");
        System.out.println("| |        KONSULTASI       | |");
        System.out.println("|+|=========================|+|");
        System.out.println("   Nama Dokter: " + dokter.namaDokter);
        setDiagnosa();
        startDiagnosa(root);
        String answer = scanner.nextLine();
    }
}
