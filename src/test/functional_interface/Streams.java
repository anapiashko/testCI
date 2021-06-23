package functional_interface;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 4, 6, 3, 453);
        List<String> strings = Arrays.asList("", "nas", "rjf", "", "ryu", "", "ryu", "");
        List<Student> students = Arrays.asList(new Student("Popov"), new Student("Ivanova"), new Student("Petrov"));

        System.out.println("i ^ 2 : " + integers.stream().map(i -> i*i).distinct().collect(Collectors.toList()));

        System.out.println("empty strings : " + strings.stream().filter(i -> i.length() == 0).count());
        System.out.println("empty strings : " + strings.stream().filter(String::isEmpty).count());

        Random random = new Random();
        System.out.println("sorted 10 random nums : " + random.ints().limit(10).sorted().boxed().collect(Collectors.toList()));

        System.out.println("max : " + integers.stream().max(Comparator.naturalOrder()).get());
        System.out.println("min : " + integers.stream().min(Comparator.naturalOrder()).get());

        IntSummaryStatistics statistics = integers.stream().mapToInt(i -> i).summaryStatistics();
        // integers.stream().mapToInt(i -> i).sum();
        System.out.println("sum : " + statistics.getSum());
        System.out.println("avg : " + statistics.getAverage());

        System.out.println("res Ivanov : " + students.stream().anyMatch(st -> st.getName().equals("Ivanov")));
        System.out.println(integers.stream().reduce((x, y) -> x + y).orElse(0));

        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new LinkedHashSet<>();

        set = integers.stream().filter(i -> Collections.frequency(integers, i) > 1).collect(Collectors.toSet());
        if(set.size() > 0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    static class Student {

        private String name;

        Student(String n) {
            this.name=n;
        }

        public String getName() {
            return name;
        }
    }
}

