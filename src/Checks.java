public class Checks {

    public static boolean all_letters(String str) {
        for (char c : str.toCharArray()) {
            if (!(Character.isLetter(c)) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean all_digits(String str) {
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }
}
