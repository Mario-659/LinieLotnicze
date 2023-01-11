package org.example.model;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LotTest {
    private Lot lot;
    private Miejsce miejsce;
    @Before
    public void setUp() throws Exception {
        this.lot = new Lot(1, "Boeing", "Wroclaw", "Warszawa", Date.from(Instant.now()), Date.from(Instant.now()), new BigDecimal("1000.0"));
        Promocja promocja = new Promocja(1, 0.9F, 1);
        this.lot.setPromocja(promocja);
        this.miejsce = new Miejsce(1, false);
    }

    @Test
    void wyszukajMiejsce() {
        assertEquals(this.lot.wyszukajMiejsce(1), this.miejsce);
    }

    @Test
    void obliczWartoscPromocji() {

    }
}