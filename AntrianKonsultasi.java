
public class AntrianKonsultasi {
    Antrian front, rear;

    public void enqueue(Antrian Hewan) {
        if (rear == null) {
            front = Hewan;
            rear = Hewan;
        } else {
            rear.setNext(Hewan);
            rear = Hewan;
        }
    }

    public void dequeue(){
        if (front == null){
            System.out.println("Antrian anda kosong");
        } else {
            front = front.getNext();
        }
    }
    public void displayQueue() {
        if (front == null) {
            System.out.println("Antrian pasien kosong.");
            return;
        }
        Antrian current = front;
        System.out.println("Daftar pasien yang menunggu:");

        while (current != null) {
            System.out.println("- " + current.username + " | Jenis Hewan: " + current.jenisHewan + " | Umur: " + current.umur + " | Berat: " + current.beratHewan + "kg");
            current = current.getNext();
        }
    }
}

