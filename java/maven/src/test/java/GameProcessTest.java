import guessNumber.AnswerGenerator;
import guessNumber.CompareNumber;
import guessNumber.GameProcess;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by zp on 15-3-2.
 */
public class GameProcessTest {

    private PrintStream out;
    private GameProcess game;
    private BufferedReader reader;
    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        answerGenerator = mock(AnswerGenerator.class);
        CompareNumber compareNumber = new CompareNumber();

        given(reader.readLine()).willReturn("1234");
        given(answerGenerator.generate()).willReturn("4321");

        game = new GameProcess(out, reader, answerGenerator, compareNumber);
    }

    @Test
    public void should_ptint_welcome_when_game_start() throws IOException {

        verify(out, never()).println("welcome!");
        game.start();
        verify(out).println("welcome!");
    }

    @Test
    public void should_print_input_after_game_start() throws IOException {

        game.start();
        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
    }

    @Test
    public void should_reduce_once_chance_when_guess_wrong() throws IOException {
        game.start();
        InOrder inOrder = inOrder(out);

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(5):");

    }
}
