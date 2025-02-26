package Task6_1.model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary = new HashMap<>();

    public Dictionary() {
        dictionary.put("Hello", "used as a greeting or to begin a conversation");
        dictionary.put("World", "the earth, together with all of its countries and peoples");
        dictionary.put("Java", "a high-level, class-based, object-oriented programming language");
        dictionary.put("Dictionary", "a book or electronic resource that lists the words of a language");
        dictionary.put("Example", "a thing characteristic of its kind or illustrating a general rule");
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String getWord(String word) throws Exception {
        String upper = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        if (!dictionary.containsKey(upper)) {
            throw new Exception("Word not found");
        }
        return dictionary.get(upper);
    }
}
