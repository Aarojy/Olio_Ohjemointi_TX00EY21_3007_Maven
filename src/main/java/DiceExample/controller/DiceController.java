package DiceExample.controller;

import DiceExample.view.DiceGUI;
import DiceExample.model.Dice;

public class DiceController {

    private DiceGUI gui;
    private Dice dice = new Dice();

    public DiceController(DiceGUI gui) {
        this.gui = gui;
    }

    public void cast() {
        int sides = gui.getSides();
        dice.setSides(sides);
        int result = dice.cast();
        gui.setResult(result);
    }
}
