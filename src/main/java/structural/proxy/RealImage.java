package structural.proxy;

public class RealImage implements Image{
    private String filename;
    RealImage(String filename){
        this.filename=filename;
        loadFormDisk( filename);
    }

    private void loadFormDisk(String filename) {
        System.out.println("Load from "+ filename);
    }


    @Override
    public void display() {
        System.out.println("Displaying from "+filename);
    }
}
