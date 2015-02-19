package guessNumber;

import java.util.Random;

/**
 * Created by twer on 2/6/15.
 */
public class NumberGenerator {

    public String generate() {
        Random ran = new Random();
        String numbers = "";
        while (numbers.length() < 4) {
            String temp = String.valueOf(ran.nextInt(10));
            if (!numbers.contains(temp)) {
                numbers += temp;
            }
        }
        return numbers;
    }
}
