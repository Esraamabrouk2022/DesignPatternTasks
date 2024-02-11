package creational.singlton;

public class SingltonThreadSaftey {
    private static SingltonThreadSaftey instance;
    String input;
    private SingltonThreadSaftey(String input){
        this.input=input;
    }
    public static SingltonThreadSaftey getInstance(String input){

        synchronized (SingltonThreadSaftey.class){
        if(instance==null){
            instance=new SingltonThreadSaftey(input);
        }}
        System.out.println(input);
        return instance;
    }
}
