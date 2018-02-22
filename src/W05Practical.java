import java.io.FileNotFoundException;
import java.io.IOException;

public class W05Practical {

    public static void main(String[] args) {
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
        try {
            String filePath = args[0];
            SimilarityScores similarityScore = new SimilarityScores();
            similarityScore.printSimilarityScore(filePath, args[1]);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
