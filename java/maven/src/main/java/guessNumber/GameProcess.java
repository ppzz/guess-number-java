package guessNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by zp on 15-3-2.
 */
public class GameProcess {
    private PrintStream out;
    private final BufferedReader reader;
    private final AnswerGenerator answerGenerator;
    private final CompareNumber compareNumber;


    public GameProcess(PrintStream out, BufferedReader reader, AnswerGenerator answerGenerator, CompareNumber compareNumber) {
        this.out = out;
        this.reader = reader;
        this.answerGenerator = answerGenerator;
        this.compareNumber = compareNumber;
    }

    public void start() throws IOException {
        out.println("welcome!");
        int chances = 6;
        String answer = answerGenerator.generate();
        String tips = "";

        while (chances > 0) {
            out.println("please input your number(" + chances + "):");
            String input = reader.readLine();
            tips = compareNumber.getTips(input, answer);
            if (tips.equals("4A0B")) {
                break;
            }
            out.println(tips);
            chances -= 1;
        }
        if (tips.equals("4A0B")) {
            out.println("congratulate!");
        }
        out.println("game over");
    }
}
