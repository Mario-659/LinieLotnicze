package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@RunWith(Parameterized.class)
public class KlientTest {
    private Klient klient;

    @BeforeEach
    private void setUp() {
        klient = new Klient();
    }

    @Test
    public void testWyswietlDaneKlienta() {
        assertEquals(1, 1);
    }

    @Test()
    public void testWalidacjaPeselBledneDane() {
        String blednyPesel = "1234";
        assertThrows(IllegalArgumentException.class, () -> {
            klient.validatePesel(blednyPesel);
        });
    }


    public void testPodajDaneKlienta() {
    }
}