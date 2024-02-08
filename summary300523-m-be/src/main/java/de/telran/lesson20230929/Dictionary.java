package de.telran.lesson20230929;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {

    // Task: Составить словарь используемых слов с частотой их употребления
    public static void main(String[] args) {

        String text = "Mr. and Mrs. Dursley, of number four, Privet Drive, were proud to say\n" + "that they were " +
                "perfectly normal, thank you very much. They were the last\n" + "people you'd expect to be involved in anything strange or mysterious,\n" + "because they just didn't hold with such nonsense.\n" + "Mr. Dursley was the director of a firm called Grunnings, which made\n" + "drills. He was a big, beefy man with hardly any neck, although he did\n" + "have a very large mustache. Mrs. Dursley was thin and blonde and had\n" + "nearly twice the usual amount of neck, which came in very useful as she\n" + "spent so much of her time craning over garden fences, spying on the\n" + "neighbors. The Dursleys had a small son called Dudley and in their\n" + "opinion there was no finer boy anywhere.\n" + "The Dursleys had everything they wanted, but they also had a secret, and\n" + "their greatest fear was that somebody would discover it. They didn't\n" + "think they could bear it if anyone found out about the Potters. Mrs.\n" + "Potter was Mrs. Dursley's sister, but they hadn't met for several years;\n" + "in fact, Mrs. Dursley pretended she didn't have a sister, because her\n" + "sister and her good-for-nothing husband were as unDursleyish as it was\n" + "possible to be. The Dursleys shuddered to think what the neighbors would\n" + "say if the Potters arrived in the street. The Dursleys knew that the\n" + "Potters had a small son, too, but they had never even seen him. This boy\n" + "was another good reason for keeping the Potters away; they didn't want\n" + "Dudley mixing with a child like that.\n" + "When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story\n" + "starts, there was nothing about the cloudy sky outside to suggest that\n" + "strange and mysterious things would soon be happening all over the\n" + "country. Mr. Dursley hummed as he picked out his most boring tie for\n" + "work, and Mrs. Dursley gossiped away happily as she wrestled a screaming\n" + "Dudley into his high chair.\n" + "None of them noticed a large, tawny owl flutter past the window.\n" + "At half past eight, Mr. Dursley picked up his briefcase, pecked Mrs.\n" + "Dursley on the cheek, and tried to kiss Dudley good-bye but missed,\n" + "2\n" + "because Dudley was now having a tantrum and throwing his cereal at the\n" + "walls. \"Little tyke,\" chortled Mr. Dursley as he left the house. He got\n" + "into his car and backed out of number four's drive.\n" + "It was on the corner of the street that he noticed the first sign of\n" + "something peculiar -- a cat reading a map. For a second, Mr. Dursley\n" + "didn't realize what he had seen -- then he jerked his head around to\n" + "look again. There was a tabby cat standing on the corner of Privet\n" + "Drive, but there wasn't a map in sight. What could he have been thinking\n" + "of? It must have been a trick of the light. Mr. Dursley blinked and\n" + "stared at the cat. It stared back. As Mr. Dursley drove around the\n" + "corner and up the road, he watched the cat in his mirror. It was now\n" + "reading the sign that said Privet Drive -- no, looking at the sign; cats\n" + "couldn't read maps or signs. Mr. Dursley gave himself a little shake and\n" + "put the cat out of his mind. As he drove toward town he thought of\n" + "nothing except a large order of drills he was hoping to get that day.";

        String[] words = text.split("\\W");
        System.out.println(Arrays.toString(words));

//        Map<String, Integer> dictionary = new TreeMap<>();
//        for (int i = 0; i < words.length; i++) {
//            String key = words[i];
//            if (dictionary.containsKey(key)) {
//                Integer count = dictionary.get(key);
//                dictionary.put(key, ++count);
//            } else {
//                dictionary.put(key, 1);
//            }
//        }
        Map<String, Long> dictionary = Arrays.stream(words).collect(Collectors.groupingBy(o -> o, Collectors.counting()));

//        Set<Word> wordSet = new TreeSet<>();
//        for (Map.Entry<String, Long> e : dictionary.entrySet()) {
//            Word word = new Word(e.getKey(), e.getValue());
//            wordSet.add(word);
//        }

        Set<Word> wordSet = dictionary.entrySet().stream()
                .map(entry -> new Word(entry.getKey(), entry.getValue())).collect(Collectors.toCollection(TreeSet::new));

        for (Word w : wordSet) {
            System.out.println(w);
        }
    
    }


    public static class Word implements Comparable<Word>{
        String word;
        long count;

        public Word(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            int result = (int) (o.count - this.count); // count
            if (result != 0) return result;

            result = this.word.compareTo(o.word); // word
            return result;
        }

        @Override
        public String toString() {
            return "Word: '" + word + "', count = " + count;
        }
    }



}
