import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by twer on 2/6/15.
 */
public class AnswerGeneratorTest {
    @Test
    public void should_return_four_digits_string(){
        String result = new AnswerGenerator(new Random()).generate();

        assertThat(result.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_numbers() {

        String result = new AnswerGenerator(new Random()).generate();

        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            fail("result should be number !!");
        }
    }

    @Test
    public void should_generate_no_duplicated_digit_string() {
        String result = new AnswerGenerator(new Random()).generate();

        for (int i = 0, n = result.length(); i < n; i++) {
            char oneChar = result.charAt(i);
            assertThat(result.indexOf(oneChar)).isEqualTo(result.lastIndexOf(oneChar));
        }
    }

    @Test
    public void should_not_repeat_in_3_times() {
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 4)
                .willReturn(3, 4, 5, 6)
                .willReturn(2, 3, 4, 5);
        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        Set<String> result = new HashSet<String>();

        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());

        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void should_repeatable_out_of_three_times() {
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 5)
                .willReturn(3, 4, 5, 6)
                .willReturn(1, 2, 3, 4);
        AnswerGenerator answerGenerator = new AnswerGenerator(random);
        Set<String> result = new HashSet<String>();

        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());
        result.add(answerGenerator.generate());

        assertThat(result.size()).isEqualTo(3);
    }
}
