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
        out.println("please input your number(6):");
        String answer = answerGenerator.generate();
        String input = reader.readLine();
        String tips = compareNumber.getTips(input, answer);

        out.println(tips);
        if (!(tips.equals("4A0B"))){
            out.println("please input your number(5):");
        }
    }
}
