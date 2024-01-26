import java.util.*;

public class Analyser {
    public boolean isValid(String brackets) {
        Deque<String> openingBrackets = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            String bracket = String.valueOf(brackets.charAt(i));
            if (isOpeningBracket(bracket)) {
                openingBrackets.addFirst(bracket);
                continue;
            }
            String lastOpenedBracket = openingBrackets.removeFirst();
            if (!isCounterpartBracket(lastOpenedBracket, bracket)) {
                return false;
            }
        }

        return true;
    }

    private boolean isOpeningBracket(String bracket) {
        return bracket.matches("[{\\[(]");
    }

    private boolean isCounterpartBracket(String openingBracket, String closingBracket) {
        if (openingBracket.isEmpty()) return false;
        Map<String, String> bracketsMap = new HashMap<>();
        bracketsMap.put("{", "}");
        bracketsMap.put("[", "]");
        bracketsMap.put("(", ")");
        return bracketsMap.get(openingBracket).equals(closingBracket);
    }
}
