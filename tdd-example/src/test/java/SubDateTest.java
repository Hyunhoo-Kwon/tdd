import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubDateTest {

    @Test
    public void testGetYearDay() {
        SubDate subDate = new SubDate();
        assertThat(subDate.getYearDay(1), is(0));
        assertThat(subDate.getYearDay(2), is(365));
    }

    @Test
    public void testLeapYear() {
        SubDate subDate = new SubDate();
        assertThat(subDate.isLeapYear(0), is(true));
        assertThat(subDate.isLeapYear(1), is(false));
        assertThat(subDate.isLeapYear(4), is(true));
    }

}
