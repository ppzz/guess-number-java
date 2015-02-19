import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by twer on 2/6/15.
 */
public class AnswerGeneratorTest {
    @Test
    public void should_return_four_digits_string(){
        String result = new AnswerGenerator().generate();

        assertThat(result.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_numbers() {

        String result = new AnswerGenerator().generate();

        try {
            Integer.parseInt(result);
        } catch (NumberFormatException e) {
            fail("result should be number !!");
        }
    }

    @Test
    public void should_generate_no_duplicated_digit_string() {
        String result = new AnswerGenerator().generate();

        for (int i = 0, n = result.length(); i < n; i++) {
            char oneChar = result.charAt(i);
            assertThat(result.indexOf(oneChar)).isEqualTo(result.lastIndexOf(oneChar));
        }
    }
}
