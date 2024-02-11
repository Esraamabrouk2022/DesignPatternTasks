import creational.creationalFactory.Shape;
import creational.creationalFactory.ShapeFactory;
import creational.multiThread.SharedCounter;
import creational.singlton.Singlton;
import creational.singlton.SingltonThreadSaftey;
import structural.adapter.SocketAdapter;
import structural.adapter.SocketClassAdapterImpl;
import structural.adapter.Volt;
import structural.proxy.Image;
import structural.proxy.ProxyImage;

public class Main {
    public static void main(String[] args) {
        //creationFactory();
       testProxy();
       // testClassAdapter();
    }

    static void testSinglton() {

        Singlton singlton = Singlton.getInstance("First");
        Singlton singlton2 = Singlton.getInstance("First");
    }

    static void testSingltonThreadSaftey() {
        SingltonThreadSaftey singltonThreadSaftey = SingltonThreadSaftey.getInstance("first");
        SingltonThreadSaftey singltonThreadSaftey2 = SingltonThreadSaftey.getInstance("first");
    }

    static void counterMultiThread() {
        SharedCounter counter = new SharedCounter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("incrementThread : " + counter.getValue());
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("decrementThread : " + counter.getValue());
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getValue());
    }

    static void creationFactory() {

            ShapeFactory shapeFactory = new ShapeFactory();
            Shape shape1 = shapeFactory.getShape("circle");
            shape1.draw();
            shape1 = shapeFactory.getShape("square");
            shape1.draw();
            shape1 = shapeFactory.getShape("rectangle");
            shape1.draw();


    }
    //structural

    static void testClassAdapter(){
        SocketAdapter socketAdapter=new SocketClassAdapterImpl();
        Volt v1=socketAdapter.get3Volt();
        Volt v2=socketAdapter.get12Volt();
        Volt v3=socketAdapter.get120Volt();
        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
        System.out.println(v3.getValue());

    }
    static void testObjectAdapter(){
        SocketAdapter socketAdapter=new SocketClassAdapterImpl();
        Volt v1=socketAdapter.get3Volt();
        Volt v2=socketAdapter.get12Volt();
        Volt v3=socketAdapter.get120Volt();
        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
        System.out.println(v3.getValue());
    }
    static void testProxy(){
        Image image=new ProxyImage("file name lol !");
        image.display();

        image.display();


    }
}

