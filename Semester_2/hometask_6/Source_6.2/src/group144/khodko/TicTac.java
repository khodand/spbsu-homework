package group144.khodko;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TicTac {
    /**
     * Set of all possible win conditions
     */
    private Set<String> winCondition = new TreeSet<>();

    /**
     * xTurn is X's turn?
     *
     * isGameOn is the game on?
     */
    private boolean xTurn = true;
    private boolean isGameOn = true;

    private String pressedXButtons;
    private String pressedOButtons;

    public TicTac(){
        Collections.addAll(winCondition, "123", "456", "789", "147", "258", "369", "159", "357");
        xTurn = true;
        isGameOn = true;

        pressedXButtons = "";
        pressedOButtons = "";
    }

    /**
     * Method for remembering marked buttons and checking on the game ending
     * @param number - number of pressed button
     */
    public void buttonPressed(String number){
        if (xTurn) {
            pressedXButtons += number;
            isGameOn = !checkCondition(pressedXButtons);
        }
        else {
            pressedOButtons += number;
            isGameOn = !checkCondition(pressedOButtons);
        }

        xTurn = !xTurn;
    }

    public boolean isGameOn(){
        return isGameOn;
    }

    public String getTurn(){
        if(xTurn)
            return "X";
        else
            return "O";
   }

    /**
     * Check is any of win conditions are met.
     * We are using isInString method to do this
     * It works because number of buttons less than 10
     *
     * @param markedButtons list of all marked Buttons (as like "1 2")
     * @return is condition met
     */
    private boolean checkCondition(String markedButtons){
        for (String curString : winCondition) {
            if (isInString(markedButtons, curString))
                return true;
        }
        return false;
    }

    /**
     * Is all char of pattern are in text
     * @param text - marked Buttons string
     * @param pattern - certain win condition
     * @return
     */
    private boolean isInString(String text, String pattern) {
        return text.indexOf(pattern.charAt(0)) != -1 && text.indexOf(pattern.charAt(1)) != -1 &&
                text.indexOf(pattern.charAt(2)) != -1;
    }
}
