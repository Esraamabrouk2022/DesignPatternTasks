package creational.singlton;

public class Singlton {
    private static Singlton instance;
    String input;
    private Singlton(String input){
        this.input=input;
    }
    public static Singlton getInstance(String input){
        if(instance==null){
            instance=new Singlton(input);
        }
        System.out.println(input);
        return instance;
    }


}
