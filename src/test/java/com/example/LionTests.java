package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LionTests {
    @Test
    public void haveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", Mockito.mock(Feline.class));
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void haveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", Mockito.mock(Feline.class));
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void lionConstructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Другое значение", Mockito.mock(Feline.class)));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensReturnsValueFromFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);

        assertEquals(3, lion.getKittens());
    }

    @Test
    public void getFoodReturnsMeatList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", feline);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
