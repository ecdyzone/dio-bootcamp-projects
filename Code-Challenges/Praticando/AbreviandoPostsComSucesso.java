package Praticando;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class AbreviandoPostsComSucesso {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> splittedLine;
        Sentence finalSentenceClass;

        //1- creating list with all words that have 3 or more characters
//        boolean f = false;
        while (true) {
            line = br.readLine();
            //line = "banana abacaxi laranja asdfasdfasd wwwwww";

            if (line.contains(".")) {
                break;
            }

            splittedLine = Arrays.asList(line.split(" "));
            finalSentenceClass = new Sentence(splittedLine);
            finalSentenceClass.shortenSentence();


        }
    }

    public static class Sentence {

        //attributed
        final private ArrayList<String> wordsBiggerThan2Chars = new ArrayList<>();
        final private Map<String, Integer> timesWordAppeared = new HashMap<>(); //2- word : timesAppeared
        final private Map<String, Integer> wordsMetrics = new HashMap<>(); //3- word : metrics
        final private SortedMap<String, String> wordsToReduce = new TreeMap<>(); //4- letter : bestWordToShorten
        final private List<String> splittedLine;

        //constructor
        public Sentence(List<String> splittedLine) {
            this.splittedLine = splittedLine;
        }

        //methods
        public void shortenSentence() {

            splittedLine.forEach(item -> {
                if (item.length() > 2) {
                    wordsBiggerThan2Chars.add(item.toLowerCase());
                }
            });

            //2- inserting words from list into HashMap with the times it appeared
            wordsBiggerThan2Chars.forEach(word -> timesWordAppeared.compute(word, (k, v) -> (v == null ? 1 : v + 1)));

            //3- creating wordMetrics HashMap
            timesWordAppeared.entrySet().forEach(entry -> {
                wordsMetrics.compute(entry.getKey(), (k, v) -> (v == null ? (k.length() - 2) * entry.getValue() : v));
            });

            //4- letter : best word to shorten
            wordsMetrics.entrySet().forEach(entry -> {
                String initialLetter = entry.getKey().substring(0, 1);
                if (wordsToReduce.get(initialLetter) == null) {
                    wordsToReduce.put(initialLetter, entry.getKey());
                } else if (wordsMetrics.get(wordsToReduce.get(initialLetter)) < entry.getValue()) {
                    wordsToReduce.put(initialLetter, entry.getKey());
                }
            });

            String finalSentenceShortened = "";
            for (String word : splittedLine) {
                if (wordsToReduce.containsValue(word.toLowerCase())) {
                    finalSentenceShortened = finalSentenceShortened.concat(word.substring(0, 1) + ". ");
                } else {
                    finalSentenceShortened = finalSentenceShortened.concat(word + " ");
                }
            }

            System.out.println(finalSentenceShortened);
            System.out.println(wordsToReduce.values().size());
            for (String key : wordsToReduce.keySet()) {
                String stringToPrint = key + ". = " + wordsToReduce.get(key);
                System.out.println(stringToPrint);

            }
        }

    }
}
