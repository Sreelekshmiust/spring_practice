import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPractice {

    public void startsWith(){
        List<String> names = List.of("Alice", "Bob", "Andrew", "Tom", "Ankit");
        names.stream().filter(n -> n.startsWith("A")).forEach(System.out::println);
//        for(String name:result){
//            System.out.println(name);
//        }
    }

    public static void toUpperCase(){
        List<String> items = List.of("apple", "banana", "grape");
        items.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static void countEven(){
        List<Integer> nums = List.of(1, 2, 4, 7, 8, 10);
        long result = nums.stream().filter(n-> n%2==0).count();
        System.out.println(result);
    }

    public static void sorted(){
        List<Integer> nums = List.of(9, 3, 7, 1, 5);
        nums.stream().sorted().limit(3).forEach(System.out::println);
    }

    public static void repeated(){
        List<String> values = List.of("dog", "cat", "dog", "bird");
        values.stream().distinct().sorted().forEach(System.out::println);
    }

    public static void setconvert(){
        List<String> names = List.of("alice", "bob", "alice", "charlie");
        Set<String> result = names.stream().map(String::toUpperCase).collect(Collectors.toSet());;
        System.out.println(result);
    }

    public static void countVowels(){
        String input = "Hello World";
        long count = input.chars().filter(ch -> "aeiou".indexOf(ch)!=-1).count();
        System.out.println(count);
    }

    public static void reverseWord(){
        String input = "Java Stream Rocks";
        String result = Arrays.stream(input.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static void duplicateChar(){
        String input = "programming";
        String result = input.chars().distinct().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
        System.out.println(result);
    }

    public static void occurenceCount(){
        String input = "banana";
        Map<Character,Long> occurence = input.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(occurence);
    }

    public static void main(String args[]){
//        StreamPractice obj1 = new StreamPractice();
//        obj1.startsWith();
//        toUpperCase();
//        countEven();
//        sorted();
//         repeated();
//        setconvert();
//        countVowels();
//        reverseWord();
//            duplicateChar();
            occurenceCount();
    }
}
