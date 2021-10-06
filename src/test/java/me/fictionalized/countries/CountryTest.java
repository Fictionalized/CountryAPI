package me.fictionalized.countries;

import static org.junit.jupiter.api.Assertions.*;

import me.fictionalized.countries.data.Request;
import me.fictionalized.countries.objects.Country;
import org.junit.Test;

public class CountryTest {

    @Test
    public void testEndpoint() {
        Country country = new Request("Canada").getCountry();

        assertAll(
                () -> assertEquals("Canada", country.getName()),
                () -> assertEquals("CA", country.getAlpha2Code()),
                () -> assertEquals("CAN", country.getAlpha3Code()),
                () -> assertEquals("Ottawa", country.getCapital())
        );
    }

}
