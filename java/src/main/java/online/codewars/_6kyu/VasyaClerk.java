package online.codewars._6kyu;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/vasya-clerk/train/java
 */

/*

The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollars bill. A "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the order people follow in the line?

Return YES, if Vasya can sell a ticket to each person and give the change. Otherwise return NO.
Examples:

// *** Java ***

Line.Tickets(new int[] {25, 25, 50}) // => YES
Line.Tickets(new int []{25, 100})
         // => NO. Vasya will not have enough money to give change to 100 dollars

* */

public class VasyaClerk {
    public static String Tickets(int[] peopleInLine) {
        //Your code is here...
        int twentyFive = 0;
        int fifty = 0;
        for (int person : peopleInLine) {
            switch (person) {
                case 25:
                    ++twentyFive;
                    break;
                case 50:
                    ++fifty;
                    --twentyFive;
                    break;
                case 100:
                    if (fifty > 0) {
                        --fifty;
                        --twentyFive;
                    } else {
                        twentyFive -= 3;
                    }
                    break;
            }
            if (twentyFive < 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
