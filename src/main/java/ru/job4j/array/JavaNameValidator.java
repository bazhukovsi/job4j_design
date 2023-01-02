package ru.job4j.array;

public class JavaNameValidator {
    public static void main(String[] args) {
        isNameValid("first1");
    }

    public static boolean isNameValid(String name) {
        if (name.isEmpty()) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            int code = name.codePointAt(i);
            if (i == 0) {
                if (!isLowerLatinLetter(code)) {
                    return false;
                }
            }
            if (!(isSpecialSymbol(code) || isUpperLatinLetter(code) || isLowerLatinLetter(code) || Character.isDigit(name.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialSymbol(int code) {
        return code == 36 || code == 95;
    }

    public static boolean isUpperLatinLetter(int code) {
        return code >= 65 && code <= 90;
    }

    public static boolean isLowerLatinLetter(int code) {
        return code >= 97 && code <= 122;
    }
}
