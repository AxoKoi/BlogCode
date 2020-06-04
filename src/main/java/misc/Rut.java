/*
This is a file belonging to an axokoi project. The source code has been released under a MPL 2.0 license.
For more information, visit www.axokoi.com or www.github.com/axokoi
*/
package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Rut {
    enum VerificationDigit {
        ONE(1, "0"),
        TWO(2, "2"),
        THREE(3, "3"),
        FOUR(4, "4"),
        FIVE(5, "5"),
        SIX(6, "6"),
        SEVEN(7, "7"),
        EIGHT(8, "8"),
        NINE(9, "9"),
        TEN(10, "K"),
        ELEVEN(11, "0");

        private final int numericalValue;
        private final String stringValue;

        VerificationDigit(int numericalValue, String stringValue) {
            this.numericalValue = numericalValue;
            this.stringValue = stringValue;
        }

        public int getNumericalValue() {
            return numericalValue;
        }

        public String getStringValue() {
            return stringValue;
        }

        public static VerificationDigit fromNumericalValue(int value) {
            return Arrays.stream(VerificationDigit.values())
                    .filter(x -> x.getNumericalValue() == value)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Illegal verification digit :" + value));
        }
    }

    final int value;
    final VerificationDigit verificationDigit;

    public Rut(int value, int verificationDigit) {
        if (!isValidRut(value, verificationDigit)) {
            throw new IllegalArgumentException("Rut is not valid");
        }
        this.value = value;
        this.verificationDigit = VerificationDigit.fromNumericalValue(verificationDigit);
    }

    public static boolean isValidRut(int value, int verificationDigit) {
        if (value <= 0 || verificationDigit < 0 || verificationDigit > 11) {
            return false;
        }

        List<Integer> digits = new LinkedList<>();
        while (value > 0) {
            digits.add(value % 10);
            value = value / 10;
        }

        int[] multipliers = {2, 3, 4, 5, 6, 7};
        int result = 0;
        int counter = 0;
        for (int digit : digits) {
            result += digit * multipliers[counter];
            counter = (counter + 1) % 6;
        }
        return verificationDigit == (11 - result % 11);
    }

    public int getValue() {
        return value;
    }

    public VerificationDigit getVerificationDigit() {
        return verificationDigit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rut rut = (Rut) o;
        return value == rut.value &&
                verificationDigit == rut.verificationDigit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, verificationDigit);
    }
}
