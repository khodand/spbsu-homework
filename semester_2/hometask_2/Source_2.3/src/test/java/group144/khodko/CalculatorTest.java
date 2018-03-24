package group144.khodko;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculateTest() throws WrongInputException {
        Calculator calculator = new Calculator(new LinkedStack<>());

        int result = calculator.calculate("2 2 + 2 * 4 / 1 -");
        assertEquals(1, result );

    }

    @Test
    public void answerTest() throws WrongInputException {
        Calculator calculator = new Calculator(new LinkedStack<>());

        int result = calculator.calculate("2");
        assertEquals(2, result );

    }

    @Test
    public void negativeCalculateTest() throws WrongInputException {
        Calculator calculator = new Calculator(new ArrayStack<>());

        int result = calculator.calculate("2 2 + 2 * 4 / 3 -");
        assertEquals(-1, result );

    }

    @Test(expected = WrongInputException.class)
    public void WrongInputExepctionTest() throws WrongInputException {
        Calculator calculator = new Calculator(new ArrayStack<>());
        calculator.calculate("2 2 + 2 * 4 / -");
    }
}