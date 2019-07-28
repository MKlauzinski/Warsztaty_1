package zadanie_4;

import java.util.Random;
import java.util.Scanner;

public class zadanie_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean existD = false;
        boolean existSign = false;
        int positionD = 0;
        int positionSign = 0;
        Random generator = new Random();

        System.out.print("Jaki rzut wykonać? ");
        String polecenie = scanner.nextLine();

        char[] tab = polecenie.toCharArray();

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == 'D') {
                existD = true;
                positionD = i;
            }
            if (tab[i] == '+' || tab[i] == '-') {
                existSign = true;
                positionSign = i;
            }
        }

        if (!existD) {
            System.out.println("Brak określonej kostki");
        } else {

            //iloma kostkami rzucamy
            int ileKostek;
            if (positionD == 0) {
                ileKostek = 1;
            } else {
                StringBuilder pozycja = new StringBuilder();
                for (int i = 0; i < positionD; i++) {
                    pozycja.append(tab[i]);
                }
                ileKostek = Integer.parseInt(pozycja.toString());
            }

            //jakimi kostakmi rzucamy
            int jakaKostka = 0;
            int max = tab.length;
            StringBuilder pozycja = new StringBuilder();
            if (existSign) {
                max = positionSign;
            }

            for (int i = positionD + 1; i < max; i++) {
                pozycja.append(tab[i]);
            }
            jakaKostka = Integer.parseInt(pozycja.toString());

            //jaki modyfikator
            int modyfikator = 0;
            if (existSign) {
                StringBuilder pozycja2 = new StringBuilder();
                for (int i = positionSign; i < tab.length; i++) {
                    pozycja2.append(tab[i]);
                }
                modyfikator = Integer.parseInt(pozycja2.toString());
            }

            //podsumowanie
            System.out.println("rzucamy " + ileKostek + " kostkami " + jakaKostka + "-ściennymi z modyfikatorem: " + modyfikator);
            int rzut = modyfikator;
            for (int i = 0; i < ileKostek; i++) {
                rzut += generator.nextInt(jakaKostka)+1;
            }
            System.out.println("Twój rzut to: "+rzut);

        }
    }
}
