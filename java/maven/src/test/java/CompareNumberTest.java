import guessNumber.CompareNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zp on 15-2-6.
 */
public class CompareNumberTest {
    @Test
    public void should_return_4A0B_when_get_tips_given_inpout_is_1234_and_answer_is_1234() {
        //given
        String input = "1234";
        String answer = "1234";

        //when
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input,answer);

        //then
        assertThat(result).isEqualTo("4A0B");
    }

    @Test
    public void should_return_0A0B_when_get_tips_given_inpout_is_5678_and_answer_is_1234() {
        String input = "5678";
        String answer = "1234";

        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input, answer);

        assertThat(result).isEqualTo("0A0B");
    }
}
