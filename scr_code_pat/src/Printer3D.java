public class Printer3D extends Printer{

    public void getZ(){
        System.out.println("3D getZ");

    }

    public static void main(String[] args) {
        Printer p = new Printer3D();
        p.getX();
    }
}
