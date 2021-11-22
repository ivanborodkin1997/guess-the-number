package main.java;

import java.util.Arrays;

public class Player {

    private String name;
    private int number;
    private int attempt;
    private int[] enteredNums = new int[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }

    public int[] getEnteredNums() {
        return Arrays.copyOf(enteredNums, attempt + 1);
    }

    public void setEnteredNum(int index, int number) {
        enteredNums[index] = number;
    }

    public void nullify() {
        Arrays.fill(enteredNums, 0, attempt + 1, 0);
    }

}
