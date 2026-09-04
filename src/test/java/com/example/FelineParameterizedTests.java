package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTests {
    Feline feline = new Feline();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 50})
    public void getKittensWithArgsReturnsCorrectValue(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
