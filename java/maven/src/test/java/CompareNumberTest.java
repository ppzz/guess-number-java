import guessNumber.CompareNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zp on 15-2-6.
 */
public class CompareNumberTest {
    @Test
    public void should_return_4A0Bwhen_get_tips_given_inpout_is_1234_and_answer_is_1234() {
        //given
        String input = "1234";
        String answer = "1234";

        //when
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.getTips(input,answer);

        //then
        assertThat(result).isEqualTo("4A0B");
    }
}
