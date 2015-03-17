package Nashorn.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by valmir.justo on 3/17/15.
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        list.forEach(new Consumer(){
            public void accept(Object obj){
                System.out.println(obj);
            }
        });

        list.forEach(el -> System.out.println(el));

        list.stream().map((x) -> x*x).filter( (n) -> n > 25 ).forEach(System.out::println);

        System.out.println("Print all numbers:");
        evaluate(list, (n)->true);

        System.out.println("Print no numbers:");
        evaluate(list, (n)->false);

        System.out.println("Print even numbers:");
        evaluate(list, (n)-> n%2 == 0 );

        System.out.println("Print odd numbers:");
        evaluate(list, (n)-> n%2 == 1 );

        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n)-> n > 5 );

    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list)  {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}