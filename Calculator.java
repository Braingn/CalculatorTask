/*
Основной калькулятор
 */

public class Calculator {
    private static String[] values;
    private static boolean isRomanic;
    private static final int[] numbers = new int[2];

    private Calculator() {
    }

    public static String calculate(String input) throws Exception {
        values = input.toUpperCase().split(" ");
        isRomanic = RomeNumbers.isRomanic(values[0]);
        /* определяем формат чисел */

        numbers[0] = Calculator.parse(values[0]);
        numbers[1] = Calculator.parse(values[2]);
        /* получили значения */

        return Calculator.getResult();
    }

    private static int parse(String input) {
        int parseResult;
        if (!isRomanic)
            parseResult = Integer.parseInt(input);   //Если не римские, пробуем парсить в целые числа. При обычном тексте выбросит ошибку
        else
            parseResult = RomeNumbers.getNumber(input); //Переводим римские цифры в арабские


        if (parseResult > 10)
            throw new NumberFormatException("Число больше 10"); //По условию, если значение больше 10 - бросаем исключение
        return parseResult;
    }

    private static String getResult() throws Exception {
        Integer calculateResult;
        switch (values[1]) {
            case "+" -> calculateResult = numbers[0] + numbers[1];
            case "-" -> calculateResult = numbers[0] - numbers[1];
            case "*" -> calculateResult = numbers[0] * numbers[1];
            case "/" -> calculateResult = numbers[0] / numbers[1];
            default -> throw new Exception("Неверное действие");
        }

        if (isRomanic)
            return RomeNumbers.parseRomanic(calculateResult);
        return calculateResult.toString();

    }
}