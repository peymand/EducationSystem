package aero.mahan.view.forms;

/**
 * Created by 9316173 on 3/5/2016.
 */
public class Validation {


        public static boolean acceptOnlyDigits(String input) {

        return input.matches("[0-9]+");
    }
    public static boolean acceptDigitBetweenOneAndThree(String input) {

        return input.matches("[1-3]");
    }

    public static boolean checkTextFieldIsEmpty(String input) {
        return input.equals("");
    }

    public static boolean acceptOnlyFourDigits(String input) {
       return input.matches("[0-9]{4}");
    }

    public static boolean acceptOnlyLetters(String input) {
        return input.matches("[a-zA-Z]+");
    }

public static void main(String[] args) {
    System.out.println(Validation.checkTextFieldIsEmpty("df"));
}
}