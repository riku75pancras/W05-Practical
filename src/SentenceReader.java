
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SentenceReader {

    private String sentence;
    ArrayList<String> sentencesList = new ArrayList<String>();
    /**
     * Given a file path, this method will read the entire contents of the file,
     * split the text into sentences, and return a list of sentences.
     *
     * The sentence splitting is very basic: we just split on the full-stop character.
     *
     * The contents of each sentence are sanitised as well.
     * Sanitisation is done by replacing each character with the corresponding lower case character,
     * removing all punctuation characters, etc.
     *
     * @param filepath The file path for the input file
     * @return A list of all sentences in the file
     * @throws IOException May throw an IOException while reading the file
     */
    public ArrayList<String> readAllSentences(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        while((sentence = reader.readLine()) != null){
            sentence = sanitiseSentence(sentence);
            sentencesList.add(sentence);
        }

        return sentencesList;
    }

    /**
     * Given a string, this method will sanitise it.
     * Sanitisation is done by replacing each character with the corresponding lower case character,
     * removing all punctuation characters, etc.
     *
     * @param sentence The input string
     * @return The output string
     */
    public String sanitiseSentence(String sentence) {
        List<String> words = new ArrayList<>();
        for (String word: sentence.split("\\s+")) {
            String sanitised = word.toLowerCase().replaceAll("[^a-z]+", "");
            if (!sanitised.isEmpty()) {
                words.add(sanitised);
            }
        }

        return joinWords(words);
    }

    /**
     * This is a private method to join a list of words into a sentence.
     *
     * @param words The list of words
     * @return A string which contains the words separated by spaces
     */
    private String joinWords(List<String> words) {
        String joined = "";
        if (words.size() > 0) {
            joined = words.get(0);
        }
        for (int i = 1; i < words.size(); i++) {
            joined += " " + words.get(i);
        }
        return joined;
    }

}
