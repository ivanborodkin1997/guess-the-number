package main.java;

import java.util.Scanner;

public class GuessNumber {

    Scanner scanner = new Scanner(System.in);
    private int computerNumber = (int) (Math.random() * 101);
    private Player playerOne;
    private Player playerTwo;

    GuessNumber(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play() {
        for (int i = 0; i < 10; i++) {
            if(makeMove(playerOne, i))
                break;
            if(makeMove(playerTwo, i))
                break;
        }

        showResult(playerOne);
        System.out.println();
        showResult(playerTwo);
        playerOne.nullify();
        playerTwo.nullify();
    }

    private boolean makeMove (Player player,  int i) {
        inputNumber(player, i);
        return checkNumber(player,i);
    }

    private void inputNumber(Player player, int i) {
        System.out.print(player.getName() + " введите число: ");
        player.setNumber(scanner.nextInt());
        player.setEnteredNum(i, player.getNumber());
        player.setAttempt(i);
    }

    private boolean checkNumber(Player player, int i) {
        if (computerNumber == player.getNumber()) {
            System.out.println("Ура!!! " + player.getName() + " угадал число " + player.getNumber() + " с " + (player.getAttempt() + 1) + " попытки");
            return true;
        }
        String resultAnswer = (computerNumber > player.getNumber()) ? "маленькое... Попробуйте ввести число побольше!" : "большое... Попробуйте ввести число поменьше!";
        System.out.println("Упс, " + player.getName() + " ваше число слишком " + resultAnswer);
        if (i == 9) {
            System.out.println("У игрока " + player.getName() + " закончились попытки!");
        }
        return false;
    }

    private void showResult(Player player) {
        System.out.print(player.getName() + " за игру ввел следующие цифры: ");
        for (int num : player.getEnteredNums()) {
            System.out.print(num + " ");

        }
    }

}
