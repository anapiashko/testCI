package functional_interface;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.*;

public class LambdaApp {
 
    public static void main(String[] args) {

        //------------Predicate-------------------//
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false

        //------------BinaryOperator-------------------//
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        //------------UnaryOperator-------------------//
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25

        //------------Function-------------------//
        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов

        //------------Consumer-------------------//
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        //------------Supplier-------------------//
        Supplier<User> userFactory = ()-> {

            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());

        //------------Comparator-------------------//
        Comparator<User> comparator = (o1, o2) -> o1.getName().compareTo(o2.getName()); // String comparable поэтому можно сделать так :
        Comparator<User> comparator1 = Comparator.comparing(User::getName);
        System.out.println(comparator.compare(user1, user2));
    }
}

class User{

    private String name;

    User(String n) {
        this.name=n;
    }

    public String getName() {
        return name;
    }
}