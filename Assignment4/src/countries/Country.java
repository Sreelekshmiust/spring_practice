package countries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Country {

    public void longestCountry(){
       List<String> countries = new ArrayList<>();
       countries.add("India");
       countries.add("Argentina");
       countries.add("Russia");
       countries.add("Guatemala");

       Optional<String> longest = countries.stream().reduce((country1, country2)->country1.length()>country2.length()?country1:country2);
        System.out.println("the country with the longest name is " + longest.get());
    }
}
