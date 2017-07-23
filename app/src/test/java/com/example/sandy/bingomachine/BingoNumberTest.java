package com.example.sandy.bingomachine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by sandy on 19/07/2017.
 */

public class BingoNumberTest {
    public BingoNumbers bingoNumbers;

    @Before
    public void setUp() {
        bingoNumbers = new BingoNumbers();
    }

    @Test
    public void haveNinetyNumbers() {
        assertEquals(90, bingoNumbers.count());
    }

    @Test
    public void canGetNumber() {
        assertNotNull(bingoNumbers.getNumber());
    }

    @Test
    public void getNumberRemovesNumberFromList() {
        Integer number = bingoNumbers.getNumber();
        assertEquals(89, bingoNumbers.count());
    }

    @Test
    public void getCanResetList() {
        Integer number = bingoNumbers.getNumber();
        bingoNumbers.resetNumbers();
        assertEquals(90, bingoNumbers.count());
    }
}
