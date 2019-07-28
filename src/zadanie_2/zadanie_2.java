package zadanie_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class zadanie_2 {
    public static void main(String[] args) {
        int[] lotto = losowanie();
        int[] wytypowane = typowanie();

        System.out.print("Wylosowane liczny to: ");
        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i]+", ");
        }
        System.out.println();

        System.out.print("Wytypowane liczny to: ");
        for (int i = 0; i < wytypowane.length; i++) {
            System.out.print(wytypowane[i]+", ");
        }
        System.out.println();

        int trafienia = 0;
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < wytypowane.length; j++) {
                if (lotto[i]==wytypowane[j]) { trafienia++; }
            }
        }

        System.out.println("Trafiłeś "+trafienia+" liczb");


    }
    static int[] typowanie() {
        int[] typ = new int[6];

        for (int i = 0; i < typ.length; i++) {
            boolean test = false;
            while (!test) {
                typ[i] = podajLiczbe();
                if (typ[i]<1||typ[i]>49) {
                    System.out.println("Podana liczba poza zakresem.");
                    test = false;
                } else {
                    test = true;
                }

                if (i>0) {
                    for (int j = 0; j < i; j++) {
                        if (typ[i]==typ[j]) {
                            System.out.println("Podałeś już taką liczbę! Spróbuj jeszcze raz.");
                            test = false;
                        }
                    }
                }
            }
        }
        Arrays.sort(typ);
        return typ;
    }

    static int podajLiczbe() {
        int liczba = 0;
        Scanner scanner = new Scanner(System.in);
        boolean test = false;

        while (!test) {
            System.out.print("Podaj licznę od 1 do 49: ");
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

    static int[] losowanie() {
        Random generator = new Random();
        int[] lotto = new int[6];
        lotto[0] = generator.nextInt(49) + 1;
        for (int i = 1; i < 6; i++) {
            boolean test = false;
            while (!test) {
                lotto[i] = generator.nextInt(49) +1;
                test = true;
                for (int j = 0; j < i; j++) {
                    if (lotto[i]==lotto[j]) {
                        test = false;
                    }
                }
            }
        }
        Arrays.sort(lotto);
        return lotto;
    }
}
