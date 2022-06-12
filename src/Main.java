import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Здравствуйте! Добро пожаловать в программу калькулятора от 1 до 10 с возможностью использовать римские цифры.\nПожалуйста, введите свое уравнение. Обращаем Ваше внимание, что между всеми символами должны быть пробелы.");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }
    public static String calc(String request) {
        String[] requestArabicNumbers = request.split(" ");
        if (requestArabicNumbers.length != 3) {
            throw new NumberFormatException("Уравнение написано неверно");
        }
        boolean firstNumberIsInteger = isInteger(requestArabicNumbers[0]);
        int firstNumber = Converter.romanianArabic (requestArabicNumbers[0],firstNumberIsInteger);
        boolean secondNumberIsInteger = isInteger(requestArabicNumbers[2]);
        int secondNumber = Converter.romanianArabic (requestArabicNumbers[2],secondNumberIsInteger);
        char operation = requestArabicNumbers[1].charAt(0);
        int result;
        if (firstNumberIsInteger != secondNumberIsInteger) {
            throw new NumberFormatException("Используются разные системы исчисления");
        }
        if (firstNumber < 1 || firstNumber > 10 || secondNumber <1 || secondNumber > 10) {
            throw new NumberFormatException ("Калькулятор работает только с целыми числами от 1 до 10");
        }

        switch (operation) {
            case ('+'):
            result = firstNumber + secondNumber;
            break;
            case ('-'):
            result = firstNumber - secondNumber;
            break;
            case ('*'):
            result = firstNumber * secondNumber;
            break;
            case ('/'):
            result = firstNumber / secondNumber;
            break;
            default:
                throw new NumberFormatException ("Доступны только операции +, -, * и /");
        }
        if (firstNumberIsInteger == true) {
           return String.valueOf(result);
        }
        else {
            return Converter.arabicRomanian(result);
        }


    }


    static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }

    }

}
