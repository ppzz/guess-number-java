package guessNumber;

import java.util.*;

/**
 * Created by zp on 15-2-19.
 */
public class AnswerGenerator {
    private final List<String> historyGeneratedStrings;
    private Random random;

    public AnswerGenerator(Random random) {

        this.random = random;
        this.historyGeneratedStrings = new ArrayList<String>();
    }

    public String generate() {
        String result = generateAnswerOnce();
        while (historyGeneratedStrings.contains(result)) {
            result = generateAnswerOnce();
        }
        if (historyGeneratedStrings.size() == 2) {
            historyGeneratedStrings.remove(0);
        }
        historyGeneratedStrings.add(result);
        return result;
    }

    private String generateAnswerOnce() {
        StringBuilder number = new StringBuilder();
        while (number.length() < 4) {
            String digit = String.valueOf(random.nextInt(10));
            if (number.indexOf(digit) == -1) {
                number.append(digit);
            }
        }
        return number.toString();
    }
}
