package Task6_1.controller;

import Task6_1.model.Dictionary;
import Task6_1.view.DictionaryView;

public class DictionaryController {
    private DictionaryView view;
    private Dictionary dictionary = new Dictionary();

    public DictionaryController(DictionaryView view) {
        this.view = view;
    }

    public void search(String word) {
        try {
            String meaning = dictionary.getWord(word);
            view.printResult(meaning);
        } catch (Exception e) {
            view.printResult("Word not found");
        }
    }
}
