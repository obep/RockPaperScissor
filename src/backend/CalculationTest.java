package backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static enumerators.Choice.ROCK;
import static enumerators.Choice.PAPER;
import static enumerators.Choice.SCISSOR;

class CalculationTest {

	Calculation calc = new Calculation();
	
	@Test
	public void testCalculateTie() {
		assertTrue(calc.calculateResult(ROCK, ROCK) == "It's a tie!");
		assertTrue(calc.calculateResult(PAPER, PAPER) == "It's a tie!");
		assertTrue(calc.calculateResult(SCISSOR, SCISSOR) == "It's a tie!");	
	}
	
	@Test
	public void testCalculatePlayer1Win() {
		assertTrue(calc.calculateResult(ROCK, SCISSOR) == "Player 1 wins");
		assertTrue(calc.calculateResult(SCISSOR, PAPER) == "Player 1 wins");
		assertTrue(calc.calculateResult(PAPER, ROCK) == "Player 1 wins");
	}
	
	@Test
	public void testCalculatePlayer2Win() {
		assertTrue(calc.calculateResult(SCISSOR, ROCK) == "Player 2 wins");
		assertTrue(calc.calculateResult(PAPER, SCISSOR) == "Player 2 wins");
		assertTrue(calc.calculateResult(ROCK, PAPER) == "Player 2 wins");
	}
}
