import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] inputArray = { "SRini@123","#Moksha@®104", "0401@Jambi*","Admin@1111","Sairan@©4#01$21" };
        StringUtility stringUtility = new StringUtility();
        int digitsSum = stringUtility.getDigitsSum(inputArray);
        System.out.println(stringUtility.checkNumber(123456));
        System.out.println("Sum of digits in the array of string : "+digitsSum);
        String input = "JAVA";
        System.out.println("Altered String : "+stringUtility.alterString(input));
        Map<String, Integer> map = new HashMap<>();
        map.put("Nani", 10000);
        map.put("Chintu", 20000);
        map.put("Kanni", 40000);
        map.put("Harika", 15000);
        map.put("Srinivas", 15000);
        map.put("Srini", 20000);
        int nthHigestSalary = 2;
//        List<String> names = stringUtility.getNames(map, nthHigestSalary);
//        System.out.println(names);
        System.out.println(stringUtility.calculateSum(10));
        System.out.println(stringUtility.calculateDifference(10));
        System.out.println(stringUtility.getImage("EARTH"));
        System.out.println(stringUtility.checkPower(9));
        HashMap<Integer,Integer> marks= new HashMap<>();
        marks.put(101,80);
        marks.put(102,60);
        marks.put(103,90);
        marks.put(104,75);
        System.out.println(stringUtility.getStudents(marks));
        int array[] ={1,45,3,2,5,53,2,7};
        System.out.println(stringUtility.getSecondSmalest(array));
        System.out.println(stringUtility.modifyNumber(45862));
        System.out.println(stringUtility.modifyString("JAVAJAVA","VA"));
        System.out.println(stringUtility.getDayOfWeek("2-5-2024","d-M-yyyy"));
        System.out.println(stringUtility.validateUserName("ajob"));
        System.out.println(Arrays.toString(stringUtility.getArrayList(new String[]{"apple", "orange", "banana", "grape", "kiwi", "pear"})));
        List<String> list1 = new ArrayList<>(Arrays.asList("apple", "orange", "banana", "grape", "kiwi", "pear"));
        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "orange", "kiwi", "pear"));
//        System.out.println((stringUtility.removeElements(list1,list2)));
        System.out.println((stringUtility.retainElements(list1,list2)));
        Map<Integer,Integer> result = stringUtility.getSquares(new int[]{1,3,5,7,4});
        for (Map.Entry<Integer,Integer> entry : result.entrySet()){
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }
        Map<String,String> productDetails = new TreeMap<>();
        Map<String,Integer> salesDetails = new TreeMap<>();
        productDetails.put("lux","soap");
        productDetails.put("colgate","paste");
        productDetails.put("pears","soap");
        productDetails.put("sony","electronics");
        productDetails.put("samsung","electronics");
        salesDetails.put("lux",1000);
        salesDetails.put("colgate",500);
        salesDetails.put("pears",2000);
        salesDetails.put("sony",100);
        salesDetails.put("samsung",600);
        System.out.println(stringUtility.updatedPrice(productDetails,salesDetails,10,"electronics"));
        System.out.println(stringUtility.getSum(13.65));
    }
}