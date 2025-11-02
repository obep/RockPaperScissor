package  backend;

import enumerators.Choice;
import static enumerators.Choice.ROCK;
import static enumerators.Choice.PAPER;
import static enumerators.Choice.SCISSOR;


public class Calculation {

    public String calculateResult(Choice choice1, Choice choice2) {
        
        if(choice1 == choice2) {
            return "It's a tie!";
        }
        else if(choice1 == ROCK) {
            if(choice2 == PAPER) {
                return "Player 2 wins";
            }
            else if(choice2 == SCISSOR) {
                return "Player 1 wins";
            }
        }
        else if(choice1 == PAPER) {
            if(choice2 == SCISSOR) {
                return "Player 2 wins";
            }
            else if(choice2 == ROCK) {
                return "Player 1 wins";
            }
        }
        else if(choice1 == SCISSOR) {
            if(choice2 == ROCK) {
                return "Player 2 wins";
            }
            else if(choice2 == PAPER) {
                return "Player 1 wins";
            }
        }
            
        return "There are unknown choices!";
    }

}

