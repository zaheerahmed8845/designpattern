package org.example;

public class Context {

    private ISort iSort;

    public Context(ISort iSort) {
        this.iSort = iSort;
    }

    public void sort(int[] input) {
        iSort.sort(input);
    }
}
