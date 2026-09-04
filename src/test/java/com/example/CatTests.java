import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTests {

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsMeatList() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockFeline);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }
}


