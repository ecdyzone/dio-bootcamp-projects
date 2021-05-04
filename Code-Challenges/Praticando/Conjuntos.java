package Praticando;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Conjuntos {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
//        int numberOfWordsRead = 0;
        String word;

        while (N != 0) {
            SortedMap<String, List<String>> wordsByInitialLetter = new TreeMap<>();
            boolean isThereAnyPrefix = false;

            for (int i = 0; i < N; i++) {

                //        while (numberOfWordsRead > 0) {
                word = br.readLine();

                String wordInitialLetter = word.substring(0, 1);
                if (wordsByInitialLetter.get(wordInitialLetter) == null) {
                    wordsByInitialLetter.computeIfAbsent(wordInitialLetter, k -> new ArrayList<>()).add(word);
                    //                numberOfWordsRead--;
                    continue;
                }

                Compare compare = new Compare(word, wordsByInitialLetter.get(wordInitialLetter));
                if (compare.isPrefix()) {
                    isThereAnyPrefix = true;
                    break;

                } else {
                    //put
                    wordsByInitialLetter.get(wordInitialLetter).add(word);
                }

                //            numberOfWordsRead--;

            }

            if (isThereAnyPrefix) {
                System.out.println("Conjunto Ruim");
            } else {
                System.out.println("Conjunto Bom");
            }

            N = Integer.valueOf(br.readLine());
        }
//            numberOfWordsRead = Integer.valueOf(br.readLine());
    }


    public static class Compare {
        //attrs
        final private String inputWord;
        final private List<String> hashValueList;

        //construc
        public Compare (String inputWord, List<String> hashValueList) {
            this.inputWord = inputWord;
            this.hashValueList = hashValueList;
        }



        //method
        public boolean isPrefix() {

            boolean prefixFound = false;

            for (String item : hashValueList) {
                String smaller;
                String bigger;

                if (inputWord.length() < item.length()) {
                    smaller = inputWord;
                    bigger = item;

                } else {
                    smaller = item;
                    bigger = inputWord;
                }

                if (bigger.startsWith(smaller)) {
                    prefixFound = true;
                    break;
                }

            }


            return prefixFound;

        }

    }
}