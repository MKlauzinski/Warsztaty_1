package zadanie_3;

import java.util.Scanner;

public class zadanie_3 {
    public static void main(String[] args) {
        int min = 0;
        int max = 1000;
        int strzal;
        int krok = 1;
        boolean zgadlem = false;
        Scanner scanner = new Scanner(System.in);

        while (!zgadlem) {
            krok++;
            if (krok > 10) {
                break;
            }
            System.out.print("Próba " + krok);
            strzal = (int) (min + (max - min) / 2);
            System.out.println(" czy twoja liczba to: " + strzal + " ?");

            String odpowiedz = scanner.nextLine();
            if (odpowiedz.equals("zgadłeś")) {
                zgadlem = true;
                break;
            } else if (odpowiedz.equals("więcej")) {
                min = strzal +1;
            } else if (odpowiedz.equals("mniej")) {
                max = strzal -1;
            } else {
                System.out.println("zdecyduj się :P");
                krok--;
            }

        }

        if ((!zgadlem)&&(krok>10)) {
            System.out.println("Było już "+krok+" kroków. Oszukujesz!");
        } else if ((zgadlem)&&(krok<11)) {
            System.out.println("Zgadłem w "+krok+" krokach");
        } else {
            System.out.println("Coś poszło nie tak."+zgadlem+" "+krok);
        }
    }
}
