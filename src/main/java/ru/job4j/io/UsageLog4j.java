package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte variableByte = 127;
        short variableShort = 500;
        int variableInt = 1024;
        long variableLong = 1000000000L;
        float variableFloat = 1.25F;
        double variableDouble = 1.53;
        char variableChar = 64;
        boolean variableBoolean = true;
        LOG.debug("Переменная типа byte : variable : {} ", variableByte);
        LOG.debug("Переменная типа short : variable : {} ", variableShort);
        LOG.debug("Переменная типа int : variable : {} ", variableInt);
        LOG.debug("Переменная типа long : variable : {} ", variableLong);
        LOG.debug("Переменная типа float : variable : {} ", variableFloat);
        LOG.debug("Переменная типа double : variable : {} ", variableDouble);
        LOG.debug("Переменная типа char : variable : {} ", variableChar);
        LOG.debug("Переменная типа boolean : variable : {} ", variableBoolean);
    }
}
