package Nashorn.Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by valmir.justo on 3/17/15.
 */
public class WorkerInterfaceTest {

    public static void execute( WorkerInterface worker){
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        execute(
            new WorkerInterface() {
                @Override
                public void doSomeWork() {
                    System.out.println("Worker invoked using Anonymous Class");
                }
            }
        );

        execute( () -> System.out.println("Worker invoked using lambda expression") );
    }

}
