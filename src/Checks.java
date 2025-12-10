public class Checks { //Some methods useful for detecting bad user input
    public static boolean all_letters(String str) { // Returns whether string is made of all letters or not
        for (char c : str.toCharArray()) {
            if (!(Character.isLetter(c)) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean all_digits(String str) { // Returns whether string is made of all digits or not
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }
}
