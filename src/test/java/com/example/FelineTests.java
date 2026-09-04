package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class FelineTests {

    @Test
    public void getFoodReturnsMeatList() throws Exception {

        Feline felineSpy = Mockito.spy(new Feline());
        List<String> expectedMeat = List.of("Животные", "Птицы", "Рыба");

        doReturn(expectedMeat).when(felineSpy).getFood("Хищник");

        List<String> actualMeat = felineSpy.eatMeat();
        assertEquals(expectedMeat, actualMeat);
    }

    Feline feline = new Feline();

    @Test
    public void getFamilyReturnsFelines() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }
}