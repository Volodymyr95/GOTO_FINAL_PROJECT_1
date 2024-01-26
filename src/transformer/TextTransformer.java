package transformer;

import java.util.HashMap;
import java.util.Map;

public class TextTransformer {

    public String moveLetterOnRightPosition(int pos, String text) {
        return "";
    }

    public String moveLetterOnLeftPosition(int pos, String text) {
        return "";
    }

    private Map<String, String> prepareAlphabet(int move, int mode) {
        // if move = 2;
        Map<String, String> letters = new HashMap<>();
        if (mode == 1) {
            letters.put("A", "C");
        } else {
            letters.put("Z", "A");
        }

        return letters;
    }
}
