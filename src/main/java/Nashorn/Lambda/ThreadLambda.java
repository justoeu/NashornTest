package Nashorn.Lambda;

/**
 * Created by valmir.justo on 3/17/15.
 */
public class ThreadLambda {

    public static void main(String[] args) {

        new Thread(
                () -> System.out.println("Start")
        ).start();

    }

}
