public class Diagnosa {
    public String diagnosaPenyakit;
    private Diagnosa right, left;

    public Diagnosa(String diagnosaPenyakit){
        this.diagnosaPenyakit = diagnosaPenyakit;
        this.right = null;
        this.left = null;
    }

    public void setRight(Diagnosa right){
        this.right = right;
    }

    public Diagnosa getRight(){
        return this.right;
    }

    public void setLeft(Diagnosa left){
        this.left = left;
    }

    public Diagnosa getLeft(){
        return this.left;
    }


}
