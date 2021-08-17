package Homework5;

public class Exponentiation {


    public static int expon ( int number, int degree) {
        if (degree == 1) {
            return number;
        }
        degree--;
      return number*expon(number,degree);
    }

}
