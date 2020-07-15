import java.util.HashMap;
import java.util.Map;

/*
Класс для работы с римскими цифрами
*/

public class RomeNumbers {
    private static final HashMap<String, Integer> RomeNumbers = new HashMap<>();

    static {
        RomeNumbers.put("I", 1);
        RomeNumbers.put("II", 2);
        RomeNumbers.put("III", 3);
        RomeNumbers.put("IV", 4);
        RomeNumbers.put("V", 5);
        RomeNumbers.put("VI", 6);
        RomeNumbers.put("VII", 7);
        RomeNumbers.put("VIII", 8);
        RomeNumbers.put("IX", 9);
        RomeNumbers.put("X", 10);
    }

    private RomeNumbers() {
    }

    public static boolean isRomanic(String input) {
        return RomeNumbers.containsKey(input);
    }

    public static int getNumber(String input) {
        return RomeNumbers.get(input);
    }

    public static String parseRomanic(Integer calculateResult) {
        String result = "";
        if (calculateResult == 100)
            return "C";
        for (int i = 0; i < calculateResult / 50; i++)
            result += "L";
        for (int i = 0; i < calculateResult % 50 / 10; i++)
            result += "X";
        for (Map.Entry<String, Integer> entry : RomeNumbers.entrySet()) {
            if (calculateResult % 10 == entry.getValue())
                result += entry.getKey();
        }
        
        return result;

    }
}
