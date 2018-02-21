import java.io.BufferedReader;
import java.io.IOException;

public class SimilarityScores {
    private String sentence;

    public void calculateSimilarityScore(BufferedReader reader) throws IOException {
        SentenceReader sentenceReader = new SentenceReader();

        while((sentence = reader.readLine()) != null){
           sentenceReader.readAllSentences()
        }
    }
}
