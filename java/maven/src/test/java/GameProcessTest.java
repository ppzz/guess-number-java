import guessNumber.GameProcess;
import org.junit.Test;

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
}
