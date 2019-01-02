import org.junit.Test;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by mtumilowicz on 2019-01-02.
 */
public class ReaderTest {

    @Test
    public void map() {
        Reader<BigDecimal, Integer> toInteger = BigDecimal::intValue;
        Function<BigDecimal, String> mapped = toInteger.map(String::valueOf);
        
        assertThat(mapped.apply(BigDecimal.TEN), is("10"));
    }
}