package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class LocalizationServiceImplTest {

    @Test
    public void testLocale() {
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry())
                .thenReturn(Country.RUSSIA);

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(location.getCountry());

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, message);
    }
}
