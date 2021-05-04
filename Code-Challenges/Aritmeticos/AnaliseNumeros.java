package Aritmeticos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnaliseNumeros {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);

        int pares = 0;
        int impares = 0;
        int positivos = 0;
        int negativos = 0;


        ArrayList<Integer> leitorArray = new ArrayList<>();

        while (leitor.hasNext()) {
            int i = leitor.nextInt();
            leitorArray.add(i);
        }

        for (Integer numero: leitorArray) {
            if (numero % 2 == 0) {
                pares = pares + 1;
            } else {
                impares = impares + 1;
            }
        }

        for (Integer numero: leitorArray) {
            if (numero > 0) {
                positivos = positivos + 1;
            } else if (numero < 0){
                negativos = negativos + 1;
            }
        }

        System.out.println( pares + " valor(es) par(es)");
        System.out.println( impares + " valor(es) impar(es)");
        System.out.println( positivos + " valor(es) positivo(s)");
        System.out.println( negativos + " valor(es) negativo(s)");
    }

}