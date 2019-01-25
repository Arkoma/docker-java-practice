package com.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NutritionFactsTest {

    private NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .calories(100)
            .sodium(35)
            .carbohydrate(27)
            .build();


    @Test
    public void nutritionFactsReturnsNutritionFactsObject() {
        assertEquals(100, cocaCola.getCalories());
    }
}
