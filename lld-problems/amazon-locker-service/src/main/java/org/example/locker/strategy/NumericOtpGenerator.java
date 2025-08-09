package org.example.locker.strategy;

import java.security.SecureRandom;

public class NumericOtpGenerator implements OtpGenerator {
    private final SecureRandom random = new SecureRandom();
    private final int digits;

    public NumericOtpGenerator(int digits) {
        if (digits < 4 || digits > 10) throw new IllegalArgumentException("digits 4-10");
        this.digits = digits;
    }

    @Override
    public String generate() {
        int bound = (int) Math.pow(10, digits);
        int value = random.nextInt(bound / 10, bound);
        return String.valueOf(value);
    }
}
