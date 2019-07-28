package zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class zadanie_1 {

    public static void main(String[] args) {
        Random generator = new Random();
        boolean zgadles = false;
        int liczbaWylosowana = generator.nextInt(100) + 1;

        while (!zgadles) {
            int podanaLiczba = podajLiczbe();

            if (podanaLiczba > liczbaWylosowana) {
                System.out.println("Za dużo!");
            } else if (podanaLiczba < liczbaWylosowana) {
                System.out.println("Za mało!");
            } else if (podanaLiczba == liczbaWylosowana) {
                System.out.println("Zgadłeś!");
                zgadles = true;
            }

        }
    }

    static int podajLiczbe() {
        int liczba = 0;
        Scanner scanner = new Scanner(System.in);
        boolean test = false;
        while (!test) {
            System.out.print("Zgadnij Liczbę: ");
            String wpis = scanner.nextLine();
            try {
                liczba = Integer.parseInt(wpis);
                test = true;
            } catch (NumberFormatException ex) {
                System.out.println("To nie jest liczba");
                test = false;
            }
        }
        return liczba;
    }
}
