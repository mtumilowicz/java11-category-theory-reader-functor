import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2019-01-02.
 */
public class ReaderTest {

    @Test
    public void map() {
        Reader<BigDecimal, Integer> toInteger = BigDecimal::intValue;
        Reader<BigDecimal, String> mapped = toInteger.map(String::valueOf);
        
        assertThat(mapped.apply(BigDecimal.TEN), is("10"));
    }
}