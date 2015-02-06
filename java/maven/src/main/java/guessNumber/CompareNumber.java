package guessNumber;

/**
 * Created by zp on 15-2-6.
 */
public class CompareNumber {
    public String getTips(String input, String answer) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 0, n = input.length(); i < n; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                aCount++;
            }
            if (answer.contains(String.valueOf(input.charAt(i)))) {
                bCount++;
            }
        }
        return aCount+"A"+(bCount-aCount)+"B";
    }
}
