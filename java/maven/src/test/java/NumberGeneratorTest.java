import guessNumber.NumberGenerator;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by twer on 2/6/15.
 */
public class NumberGeneratorTest {
    @Test
    public void should_return_four_digits_string(){
        NumberGenerator numberGenerator = new NumberGenerator();
        String result = numberGenerator.generate();

        assertThat(result.length()).isEqualTo(4);
    }
}
