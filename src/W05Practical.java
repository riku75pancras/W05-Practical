import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class W05Practical {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            SimilarityScores similarityScore = new SimilarityScores();
            similarityScore.calculateSimilarityScore(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
