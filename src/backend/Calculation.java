package  backend;

import enumerators.Choices;


public class Calculation {

    public String calculateResult(Choices choice1, Choices choice2) {
        
        if(choice1 == choice2) {
            return "It's a tie!";
        }
        
        if(choice1 == Choices.ROCK) {
            if(choice2 == Choices.PAPER) {
                return "Player 2 wins";
            }
            if(choice2 == Choices.SCISSOR) {
                return "Player 1 wins";
            }
        }
        if(choice1 == Choices.PAPER) {
            if(choice2 == Choices.SCISSOR) {
                return "Player 2 wins";
            }
            if(choice2 == Choices.ROCK) {
                return "Player 1 wins";
            }
        }
        if(choice1 == Choices.SCISSOR) {
            if(choice2 == Choices.ROCK) {
                return "Player 2 wins";
            }
            if(choice2 == Choices.PAPER) {
                return "Player 1 wins";
            }
        }
            
        return "There are unknown choices!";
    }

}

