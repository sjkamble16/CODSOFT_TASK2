import java.io.*;
import java.util.*;

public class WordCountApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter text :");
        String input = scanner.nextLine();
        String text = "";

           // Use input text
            text = input;
            
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;

        // Ignoring common words or stop words 
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "of", "in", "to", "a"));
        wordCount -= Arrays.stream(words).filter(stopWords::contains).count();

        System.out.println("Total word count: " + wordCount);

        // Number of unique words 
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Number of unique words: " + uniqueWords.size());

        // Frequency of each word 
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}