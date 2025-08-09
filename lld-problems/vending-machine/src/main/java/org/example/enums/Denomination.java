package org.example.enums;

public enum Denomination {
    R1(100), R2(200), R5(500), R10(1000);
    public final int value; // paise

    Denomination(int value) {
        this.value = value;
    }
}
