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
    private InOrder inOrder;

    @Before
    public void setUp() throws IOException {
        out = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        answerGenerator = mock(AnswerGenerator.class);
        CompareNumber compareNumber = new CompareNumber();

        given(reader.readLine()).willReturn("1234");
        given(answerGenerator.generate()).willReturn("4321");

        game = new GameProcess(out, reader, answerGenerator, compareNumber);
        inOrder = inOrder(out);
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

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(5):");

    }

    @Test
    public void should_reduce_chances_one_by_one_until_game_over() throws IOException {
        game.start();

        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(1):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("game over");
    }

    @Test
    public void should_congratulate_when_input_is_right() throws IOException {
        given(answerGenerator.generate()).willReturn("1234");

        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out).println("congratulate!");

    }

    @Test
    public void should_congratulate_when_input_is_right_on_second_time() throws IOException {
        given(reader.readLine()).willReturn("1234", "4321");

        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(5):");
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out).println("congratulate!");
    }

    @Test
    public void should_congratulate_when_input_is_right_on_last_time() throws IOException {
        given(reader.readLine()).willReturn("1234", "1234", "1234", "1234", "1234", "4321");

        game.start();
        inOrder.verify(out).println("welcome!");
        inOrder.verify(out).println("please input your number(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("please input your number(1):");
        inOrder.verify(out, never()).println("4A0B");
        inOrder.verify(out).println("congratulate!");
    }
}




















