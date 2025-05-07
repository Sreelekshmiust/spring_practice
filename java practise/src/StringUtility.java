import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class StringUtility {

    /**
     * @param input
     * @return int
     */
    public int getDigitsSum(String[] input) {
        final String METHOD_NAME = "getDigitsSum";
        int digitsSum = 0;
        System.out.println("Method Invoked : " + METHOD_NAME + " " + Arrays.toString(input));
        for (String str : input) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    int a = Integer.parseInt(String.valueOf(str.charAt(i)));
                    digitsSum = digitsSum + a;
                }
            }
        }
        System.out.println("Method Response : " + METHOD_NAME + " " + digitsSum);
        return digitsSum;
    }

    /**
     * @param inputNumber
     * @return boolean
     */
    public boolean checkNumber(int inputNumber) {
        String num = Integer.toString(inputNumber);
        for (int i = 0; i < num.length(); i++) {
            int num1 = Character.getNumericValue(num.charAt(i));
            int num2 = Character.getNumericValue(num.charAt(++i));
            if (num2 < num1)
                return false;
        }
        return true;
    }

    public String alterString(String input) {
        String alteredString = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != 'A' && input.charAt(i) != 'E' &&
                    input.charAt(i) != 'I' && input.charAt(i) != 'O' && input.charAt(i) != 'U') {
                int ascii = input.charAt(i);
                char c = (char) (ascii + 1);
                alteredString += c;
            } else {
                alteredString += input.charAt(i);
            }
        }
        return alteredString;
    }

//    public List<String> getNames(Map<String, Integer> map, int nthHighestSalary){
//        List<String> names = new ArrayList<>();
//
//    }

    public int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum = i + sum;
            }
        }
        return sum;
    }

    public int calculateDifference(int n) {
        int sum = 0;
        int square = 0;
        for (int i = 1; i <= n; i++) {
            square = square + (int) Math.pow(i, 2);
        }
        sum = square - (int) Math.pow((n * (n + 1) / 2), 2);
        return sum;
    }

    public String getImage(String word) {
        StringBuffer reversed = new StringBuffer(word);
        reversed.reverse();
        String image = word + "|" + reversed;
        return image;
    }

    public boolean checkPower(int number) {
        if ((number > 0) && ((number & (number - 1)) == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public Map<Integer, String> getStudents(Map<Integer, Integer> student) {
        Map<Integer, String> score = new HashMap<>();
        Iterator<Map.Entry<Integer, Integer>> itr = student.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = itr.next();
            if (entry.getValue() >= 90) {
                score.put(entry.getKey(), "Gold");
            } else if (entry.getValue() >= 80) {
                score.put(entry.getKey(), "Silver");
            } else if (entry.getValue() >= 70) {
                score.put(entry.getKey(), "Bronze");
            }
        }
        return score;
    }

    public int getSecondSmalest(int[] intArray){
        int secondSmallest = Arrays.stream(intArray).sorted().skip(1).findFirst().getAsInt();
        return secondSmallest;
    }

    public int modifyNumber(int number){
        StringBuffer newNumber = new StringBuffer();
        String num = String.valueOf(number);
        for(int i =0; i<num.length()-1;i++){
            int diff =Math.abs( num.charAt(i) - num.charAt(i+1));
            newNumber.append(diff);
        }
        newNumber.append(num.charAt(num.length()-1));
        int result = Integer.parseInt(newNumber.toString());
        return result;
    }

    public List<String> modifyString(String S1,String S2){

        List<String> result = new ArrayList<>();
        StringBuilder intermediateResult = new StringBuilder();

        for(int i=0;i<S1.length()-1; i+=2){
            intermediateResult.append(S2);
            intermediateResult.append(S1.charAt(i+1));
        }
        result.add(intermediateResult.toString());
        String[] occurrences = S1.split(S2,-1);
        if(occurrences.length>1){
            int index=S1.lastIndexOf(S2);
            StringBuffer stringBuffer= new StringBuffer(S2);
            stringBuffer.reverse();
            result.add(S1.substring(0,index)+stringBuffer+S1.substring(index+S2.length()));
            result.add(S1.replaceFirst(S2,""));
        }
        else{
            result.add(S1+S2);
            result.add(S1);
        }
        if(S2.length()%2==0){
            result.add(S2.substring(0,(S2.length()/2))+S1+S2.substring(S2.length()/2,S2.length()));
        }
        else{
            result.add(S2.substring(0,(S2.length()/2)+1)+S1+S2.substring((S2.length()/2)+1,S2.length()));
        }
        Set<Character> charSet = new HashSet<>();
        for(char c : S2.toCharArray()){
            charSet.add(c);
        }
        StringBuilder newString = new StringBuilder();
        for (char c :S1.toCharArray()){
            if(charSet.contains(c)){
                newString.append("*");
            }else{
                newString.append(c);
            }
        }
        result.add(newString.toString());
        return result;
    }

    public String getDayOfWeek(String date,String dateFormat){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        String day = localDate.getDayOfWeek().toString();
        return day;
    }

    public boolean validateUserName(String userName){
        String subString = userName.substring(userName.length()-3);
        if(subString.equals("job") && userName.length()>=12){
            return true;
        }
        else{
            return false;
        }
    }

    public String[] getArrayList(String[] elements){
        Arrays.sort(elements);
        int middle;
        if(elements.length %2==0){
           middle = elements.length/2;
        }else{
           middle = (elements.length/2)+1;
        }
        for(int i=0;i< elements.length;i++){
           if(i<middle){
               elements[i]=elements[i].toUpperCase();
           }else{
               elements[i]=elements[i].toLowerCase();
           }
        }
        return elements;
    }

    public List<String> removeElements(List<String> list1, List<String> list2){
        list1.removeAll(list2);
        return list1;
    }

    public List<String> retainElements(List<String> list1, List<String> list2){
        list1.retainAll(list2);
        return list1;
    }

    public HashMap<Integer,Integer> getSquares(int[] numbers){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:numbers){
            map.put(num,num*num);
        }
        return map;
    }

    public Map<String,Integer> updatedPrice(Map<String,String>productDetails, Map<String,Integer>salesDetails,int rate,String category){
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String,String> entry: productDetails.entrySet()){
            if(entry.getValue() == category){
                keys.add(entry.getKey());
            }
        }
        for (Map.Entry<String,Integer> entry: salesDetails.entrySet()){
            if(keys.contains(entry.getKey())){
                entry.setValue((int) ((entry.getValue()*0.1)+entry.getValue()));
            }
        }
        return salesDetails;
    }

    public String getSum(double number){
        String num=String.valueOf(number);
        String[] parts = num.split("\\.");
        int sum = 0;
        String leftSum = parts[0];
        String rightSum = parts[1];
        for(int i=0;i<leftSum.length();i++){
            sum=sum+Integer.parseInt(String.valueOf(leftSum.charAt(i)));
        }
        leftSum= String.valueOf(sum);
        sum=0;
        for(int i=0;i<rightSum.length();i++){
            sum=sum+Integer.parseInt(String.valueOf(rightSum.charAt(i)));
        }
        rightSum= String.valueOf(sum);
        return leftSum.concat(":").concat(rightSum);
    }
}