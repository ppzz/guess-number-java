package guessNumber;

import java.io.PrintStream;

/**
 * Created by zp on 15-3-2.
 */
public class GameProcess {
    private PrintStream out;

    public GameProcess(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("welcome!");
        out.println("please input your number(6):");
    }
}
