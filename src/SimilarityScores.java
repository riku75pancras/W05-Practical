import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimilarityScores {
    ArrayList<ArrayList<String>> bigramList = new ArrayList<ArrayList<String>>();
    bigramList.add(new ArrayList<String>());

    ArrayList<String> bigramListForWord = new ArrayList<String>();

    public void calculateSimilarityScore(String filepath, String queryWord){
        SentenceReader sentenceReader = new SentenceReader();
        createBigramsForSentence(sentenceReader.readAllSentences(filepath));
        createBigramsForQuery(queryWord);
    }

    private ArrayList<ArrayList<String>> createBigramsForSentence(ArrayList<String> sentencesList){
        for(String s : sentencesList){
            for(int i = 0; i < sentencesList.size(); i++) {
                for (int j = 0; j < (s.length() - 1); j++) {
                    bigramList.get(i).add(s.substring(j, j + 1));
                }
            }
        }
        return bigramList;
    }

    private ArrayList<String> createBigramsForQuery(String queryWord){
        for (int i = 0; i < (queryWord.length() - 1); i++){
            bigramListForWord.add(queryWord.substring(i, i + 1));
        }
    }

}
