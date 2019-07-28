package zadanie_5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class zadanie_5 {
    public static void main(String[] args) {
        //fragment kodu pobierajacy coś z internetu, wzbogacony o zapis tekstu do pliku zamiast rzucania na ekran
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            String fileName = "popular_words.txt";
            Path path = Paths.get(fileName);
            try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                Files.write(path, links.eachText(), StandardOpenOption.CREATE);
                System.out.println("Zapisano do pliku");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //koniec obcego kodu

        String[] wykluczone = {"oraz", "ponieważ", "albo", "gdyż"};

        String fileName1 = "popular_words.txt";
        String fileName2 = "filtered_popular_words.txt";
        Path file1 = Paths.get(fileName1);
        Path file2 = Paths.get(fileName2);
        //zastanawiałem się czy może zrobić tak aby każde słowo było w osobnej lini, ale my ślę że poskładanie
        // ...całych lini ponownie po usunięciu niechcianych słów też będzie dobrze, ważne że działa :)
        try {
            List<String> lista = Files.readAllLines(file1);
            System.out.println("odczytano w pliku");
            String[] tablica = lista.toArray(new String[lista.size()]);
            String[] tablica2 = new String[tablica.length];
            try {
                for (int i = 0; i < tablica.length; i++) {
                    String[] slowa = tablica[i].split("[ ]");
                    StringBuilder nowaLinia = new StringBuilder();
                    for (int j = 0; j < slowa.length; j++) {
                        boolean test = true;
                        for (int k = 0; k < wykluczone.length; k++) {
                            if (slowa[j].equals(wykluczone[k])) {
                                test = false;
                            }
                        }
                        if (slowa[j].length() < 4) {
                            test = false;
                        }
                        if (test) {
                            nowaLinia.append(slowa[j]+" ");
                        }
                    }
                    tablica2[i] = nowaLinia.toString();
                }
                if (!Files.exists(file2)) {
                    Files.createFile(file2);
                }
                Files.write(file2, Arrays.asList(tablica2), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
