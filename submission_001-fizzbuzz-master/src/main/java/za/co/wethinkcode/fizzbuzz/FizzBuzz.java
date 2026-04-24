package za.co.wethinkcode.fizzbuzz;

import java.util.ArrayList;


public class FizzBuzz {
    public String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if ((divisibleBy3) && (divisibleBy5)) {
            return "FizzBuzz";
        }
        else if (divisibleBy3) {
            return "Fizz";
        }
        else if (divisibleBy5) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public String countTo(int number) {

        ArrayList<String> my_list = new ArrayList<String>();

        for (int i = 1; i <= number ; i++)
        {
            if (i % 3 == 0 && i % 5 == 0){
                my_list.add("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                my_list.add("Fizz");
            }
            else if (i % 5 == 0){
                my_list.add("Buzz");
            }else {
                my_list.add(String.valueOf(i));
            }  
        }
        return my_list.toString();
    }
}
    
