package com.example.Katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;

    private List<Integer> numbersList;
    private List<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        //GIVEN
        calculatorService = new CalculatorService();
        // WHEN
        numbersList = Arrays.asList(6, 9, 15, -2, 92, 11);
        emptyList = Collections.emptyList();
    }

    @Test
    public void should_calculate_min_when_at_least_one_element_is_present() {
        // THEN
        Integer result = calculatorService.min(numbersList);
        Assertions.assertEquals(-2, result);
    }

    @Test
    public void should_return_min_null_when_list_is_empty() {
        // THEN
        Integer result = calculatorService.min(emptyList);
        Assertions.assertNull(result);
    }

    @Test
    public void should_calculate_max_when_at_least_one_element_is_present() {
        // THEN
        Integer result = calculatorService.max(numbersList);
        Assertions.assertEquals(92, result);
    }

    @Test
    public void should_return_max_null_when_list_is_empty() {
        // THEN
        Integer result = calculatorService.max(emptyList);
        Assertions.assertNull(result);
    }

    @Test
    public void should_calculate_the_number_of_elements_within_a_list() {
        // THEN
        Integer result = calculatorService.size(numbersList);
        Assertions.assertEquals(numbersList.size(), result);
    }

    @Test
    public void should_return_size_null_when_list_is_empty() {
        // THEN
        Integer result = calculatorService.size(emptyList);
        Assertions.assertNull(result);
    }

    @Test
    public void should_calculate_the_average_of_a_list() {
        // THEN
        Double result = calculatorService.average(numbersList);
        Assertions.assertEquals(21.83333396911621, result);
    }


}
