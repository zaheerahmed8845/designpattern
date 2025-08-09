package org.example.locker.strategy;

import java.security.SecureRandom;

public class AlphanumericCodeGenerator implements OtpGenerator {
    private static final char[] ALPHA = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".toCharArray();
    private final SecureRandom random = new SecureRandom();
    private final int length;

    public AlphanumericCodeGenerator(int length) {
        if (length < 6 || length > 16) throw new IllegalArgumentException("length 6-16");
        this.length = length;
    }

    @Override
    public String generate() {
        var sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append(ALPHA[random.nextInt(ALPHA.length)]);
        return sb.toString();
    }
}
