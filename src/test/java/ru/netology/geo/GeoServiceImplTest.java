package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"172.103.25.64", "96.107.19.36"})
    public void testByIp(String argument) {

        GeoServiceImpl geoService = new GeoServiceImpl();

        Location location = geoService.byIp(argument);
        Country result = location.getCountry();

        Country expected;
        if (argument.startsWith("172.")) {
            expected = Country.RUSSIA;
        } else {
            expected = Country.USA;
        }

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testByCoordinates() {
        GeoServiceImpl geoService = new GeoServiceImpl();

        double a = 44.12, b = 45.35;

//        geoService.byCoordinates(a, b);

        Assertions.assertThrows(RuntimeException.class, () -> geoService.byCoordinates(a, b));
    }
}