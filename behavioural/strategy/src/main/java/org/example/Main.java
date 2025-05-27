package org.example;

public class Main {
    public static void main(String[] args) {
        //Bubble Sort Strategy
        BubbleSort bubbleSort = new BubbleSort();
        Context context = new Context(bubbleSort);
        int[] input = {1, 3, 6, 5, 2};
        context.sort(input);

        //Merge Sort Strategy
        MergeSort mergeSort = new MergeSort();
        context = new Context(mergeSort);
        context.sort(input);
    }
}