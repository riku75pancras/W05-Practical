import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimilarityScores {

    ArrayList<String> bigramListForWord = new ArrayList<String>();
    private int lineCounter;

    public void printSimilarityScore(String filepath, String queryWord) throws IOException {
        SentenceReader sentenceReader = new SentenceReader();
        System.out.println(createBigramsForSentence(sentenceReader.readAllSentences(filepath)));
        //createBigramsForQuery(queryWord);

    }

    private ArrayList<ArrayList<String>> createBigramsForSentence(List<String> sentencesList){
        ArrayList<ArrayList<String>> bigramList = new ArrayList<>();
        bigramList.add(new ArrayList<String>());

            while(lineCounter < sentencesList.size()) {
                    for (String s : sentencesList) {
                        if (s != "") {
                            for (int j = 0; j < (s.length() - 1); j++) {
                                bigramList.get(lineCounter).add(s.substring(j, j + 1));
                            }
                            lineCounter += 1;
                        }
                    }
                }
        
        return bigramList;
    }

    private ArrayList<String> createBigramsForQuery(String queryWord){
        for (int i = 0; i < (queryWord.length() - 1); i++){
            bigramListForWord.add(queryWord.substring(i, i + 1));
        }

        return  bigramListForWord;
    }

}
