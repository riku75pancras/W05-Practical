import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class W05Practical {

    public static void main(String[] args){
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
          try {
              String filePath = args[0];
              SimilarityScores similarityScore = new SimilarityScores();
              similarityScore.calculateSimilarityScore(filePath, args[1]);
          } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
