package Aritmeticos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Repetidos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        Locale.setDefault(new Locale("en", "US"));

        ArrayList<Integer> numeros = new ArrayList<Integer>();

        int quantidadeValores = sc.nextInt();
        while(quantidadeValores > 0) {
            numeros.add(sc.nextInt());
            quantidadeValores--;
        }

        SortedMap<Integer, Integer> contaQuant = new TreeMap<>();
        numeros.forEach(id -> contaQuant.compute(id, ( k , v ) -> ( v == null ? 1 : v + 1)));

        contaQuant.entrySet().forEach(entry->{
            System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
        });

        sc.close();
    }
}