public class DokterHewan {
    public String namaDokter, jadwal;
    public int umurDokter, biayaKonsul;
    public double rating;

    public AntrianKonsultasi daftarAntrian;
    private DokterHewan next, prev;

    public DokterHewan(String namaDokter, String jadwal, int umurDokter, int biayaKonsul, double rating){
        this.namaDokter = namaDokter;
        this.jadwal = jadwal;
        this.umurDokter = umurDokter;
        this.biayaKonsul = biayaKonsul;
        this.rating = rating;
        this.next = null;
        this.daftarAntrian = new AntrianKonsultasi();
    }

    public void setNext(DokterHewan next){
        this.next = next;
    }

    public DokterHewan getNext(){
        return this.next;
    }

    public void setPrev(DokterHewan prev){
        this.prev = prev;
    }

    public DokterHewan getPrev(){
        return this.prev;
    }

}