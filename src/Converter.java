import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

class Converter {
    static int romanianArabic(String string, boolean isInteger) {
        int result;
        if (isInteger) {
            result = Integer.parseInt(string);

        } else {
            String wholeLine = string.toUpperCase();
            int firstSymbol = 0;
            int realSymbol;
            int endResult = 0;
            for (int i = 0; i < wholeLine.length(); i++) {
                try {
                    realSymbol = RomanianArabic.valueOf(String.valueOf(wholeLine.charAt(i))).getValue();
                } catch (IllegalArgumentException e) {// под требования подогнать
                    throw new IllegalArgumentException("Введенные данные неверны");
                }
                if (firstSymbol < realSymbol) {
                    endResult += realSymbol - firstSymbol * 2;
                } else {
                    endResult += realSymbol;
                }
                firstSymbol = realSymbol;

            }
            result = endResult;

        }

        return result;
    }

    static String arabicRomanian(int romanianArabic) {
        if (romanianArabic <= 0) {
            throw new NumberFormatException("В римской системе нет отрицательных чисел");
        }

        StringBuilder result = new StringBuilder();
        EnumSet<RomanianArabic> romanNumbers = EnumSet.allOf(RomanianArabic.class);
        List<RomanianArabic> collect = romanNumbers.stream().sorted(Comparator.reverseOrder()).toList();
        for (RomanianArabic romanNumber : collect) {
            while (romanianArabic - romanNumber.getValue() >= 0) {
                result.append(romanNumber);
                romanianArabic -= romanNumber.getValue();
            }

        }
        return result.toString();
    }

}

