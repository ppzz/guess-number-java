package guessNumber;

/**
 * Created by zp on 15-2-6.
 */
public class CompareNumber {
    public String getTips(String input, String answer) {
        if (answer.equals(input)) {
            return "4A0B";
        }
        int containsCount = 0;
        for (int i = 0, n = input.length(); i < n; i++) {
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                containsCount++;
            }
        }
        if (containsCount == 0) {
            return "0A0B";
        }
        return null;
    }
}
