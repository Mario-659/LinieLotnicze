package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KlientTest {
    private Klient klient;

    @BeforeEach
    public void setUp() {
        klient = new Klient();
    }

    @Test
    public void testWyswietlDaneKlienta() {
        assertEquals(1, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "73874d", "", "1117382099812", "11173820998t", "kfjlaindmkq"})
    public void testWalidacjaPeselBledneDane(String blednyPesel) {
        assertThrows(IllegalArgumentException.class, () -> {
            klient.validatePesel(blednyPesel);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"12627456731", "93028573902", "11111111111"})
    public void testWalidacjaPeselPoprawneDane(String poprawnyPesel) {
        klient.validatePesel(poprawnyPesel);
    }

//    @ParameterizedTest
//    @ValueSource()
//    public void testWalidacjaNazwiskoBledneDane(String ble) {
//        String
//    }


    public void testPodajDaneKlienta() {
    }
}