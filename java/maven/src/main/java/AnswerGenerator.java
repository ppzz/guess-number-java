import java.util.Random;

/**
 * Created by zp on 15-2-19.
 */
public class AnswerGenerator {
    public String generate() {
        Random random = new Random();
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
