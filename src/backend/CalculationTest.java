package backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import enumerators.Choices;

class CalculationTest {

	Calculation calc = new Calculation();
	
	@Test
	public void testCalculateTie() {
		assertTrue(calc.calculateResult(Choices.ROCK, Choices.ROCK) == "It's a tie!");
		assertTrue(calc.calculateResult(Choices.PAPER, Choices.PAPER) == "It's a tie!");
		assertTrue(calc.calculateResult(Choices.SCISSOR, Choices.SCISSOR) == "It's a tie!");	}
	
	@Test
	public void testCalculatePlayer1Win() {
		assertTrue(calc.calculateResult(Choices.ROCK, Choices.SCISSOR) == "Player 1 wins");
		assertTrue(calc.calculateResult(Choices.SCISSOR, Choices.PAPER) == "Player 1 wins");
		assertTrue(calc.calculateResult(Choices.PAPER, Choices.ROCK) == "Player 1 wins");
	}
	
	@Test
	public void testCalculatePlayer2Win() {
		assertTrue(calc.calculateResult(Choices.SCISSOR, Choices.ROCK) == "Player 2 wins");
		assertTrue(calc.calculateResult(Choices.PAPER, Choices.SCISSOR) == "Player 2 wins");
		assertTrue(calc.calculateResult(Choices.ROCK, Choices.PAPER) == "Player 2 wins");
	}
}
