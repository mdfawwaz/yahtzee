package Yahtzee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
    public List<Integer> dieValue = new ArrayList<>();

    public List<Integer> roll(int numDice) {
        Random random = new Random();
        dieValue.clear();
        for (int i = 0; i < numDice; i++) {
            dieValue.add(random.nextInt(6) + 1);
        }
        return dieValue;
    }


    public void sum() {
        int sum = 0;
        for (int dice : dieValue) {
            sum += dice;
        }
        System.out.println("Sum of Dice: " + sum);
    }

    public void upper(int category) {
        int sum = 0;
        for (int die : dieValue) {
            if (die == category) {
                sum += category;
            }
        }
        System.out.println("Upper House: " + sum);
    }

    public int fullHouse() {
        int[] freq = new int[10];
        for (int die : dieValue) {
            freq[die]++;
        }

        boolean containsTwo = false;
        boolean containsThree = false;

        for (int i = 1; i <= 6; i++) {
            if (freq[i] == 2) {
                containsTwo = true;
            } else if (freq[i] == 3) {
                containsThree = true;
            }

            if (containsTwo && containsThree) {
                System.out.println("Full House Contains 2 & 3");
                return 25;
            }
        }
        return 0;
    }

    public int threeOfAKind() {
        int[] freq = new int[10];
        int sum = 0;
        for (int dice : dieValue) {
            sum += dice;
            freq[dice]++;
        }

        for (int i = 1; i <= 6; i++) {
            if (freq[i] == 3) {
                System.out.println("Three of A Kind");
                return sum;
            }
        }
        return 0;
    }

public int Straight() {

	int sequence = 5;
    int checkConsq=0;
    int[] freq =new int[10];
    
    for(int die:dieValue) {

        freq[die]++;

    }

    for(int i=0;i<5;i++) {
        
        if(freq[i]!=0 && freq[i]!=2)
            checkConsq++;

        else 
        checkConsq = 0;

    }

    if(checkConsq == sequence)
        return 30;

    else 
    return 0;
}

    public int fourOfAKind() {
        int sum = 0;
        for (int dice : dieValue) {
            sum += dice;
        }

        int[] freq = new int[10];
        for (int die : dieValue) {
            freq[die]++;
        }

        for (int i = 1; i <= 6; i++) {
            if (freq[i] == 4) {
                System.out.println("Four of A Kind");
                return sum;
            }
        }
        return 0;
    }
    public int Yahtzeee() {
        int firstDie = dieValue.get(0);
        for (int die : dieValue) {
            if (die != firstDie) {
                return 0;
            }
        }
        return 50;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Yahtzee game = new Yahtzee();
        
        for (int category = 1; category <= 13; category++) {

        System.out.print("Enter the number of dice to roll: ");
        int numDice = scanner.nextInt();
        List<Integer> rolledDice = game.roll(numDice);
        System.out.println("Rolled Dice Value: " + rolledDice);

        System.out.println("Choose category:");
        System.out.println("1 - Upper House");
        System.out.println("2 - Full House");
        System.out.println("3 - Three of A Kind");
        System.out.println("4 - Four of A Kind");
        System.out.println("5 - Straight of A Kind");
        System.out.println("6 - Yahtzee");



        int categoryChoice = scanner.nextInt();

        switch (categoryChoice) {
            case 1:
                System.out.print("Enter the value for Upper House (1-6): ");
                int categoryValue = scanner.nextInt();
                game.upper(categoryValue);
                break;
            case 2:
                int fullHouseScore = game.fullHouse();
                System.out.println("Full House Score: " + fullHouseScore);
                break;
            case 3:
                int threeOfAKindScore = game.threeOfAKind();
                System.out.println("Three of A Kind Score: " + threeOfAKindScore);
                break;
            case 4:
                int fourOfAKindScore = game.fourOfAKind();
                System.out.println("Four of A Kind Score: " + fourOfAKindScore);
                break;
            case 5:
                int straight = game.Straight();
                System.out.println("Four of A Kind Score: " + straight);
                break;
            case 6:
                int yahtzee = game.Yahtzeee();
                System.out.println("Yahtzee Score: " + yahtzee);
                break;
            default:
                System.out.println("Invalid category choice.");
        }}

        scanner.close();
    }
}

