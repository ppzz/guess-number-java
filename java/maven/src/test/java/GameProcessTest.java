import guessNumber.GameProcess;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by zp on 15-3-2.
 */
public class GameProcessTest {
    @Test
    public void should_ptint_welcome_when_game_start() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        verify(out, never()).println("welcome!");
        game.start();
        verify(out).println("welcome!");
    }

    @Test
    public void should_print_input_after_game_start() {
        PrintStream out = mock(PrintStream.class);
        GameProcess game = new GameProcess(out);

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
    }
}
