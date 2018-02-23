import javax.crypto.AEADBadTagException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarityScores {

    ArrayList<String> sentencesList = new ArrayList<String>();
    ArrayList<String> bigramListForWord = new ArrayList<String>();
    ArrayList<ArrayList<String>> bigramListForSentence = new ArrayList<>();
    ArrayList<ScoredResult> resultAndScoreList = new ArrayList<ScoredResult>();
    private int lineCounter;
    private String sanitisedQueryWord;

    public void printSimilarityScore(String filepath, String queryWord) throws IOException{
        SentenceReader sentenceReader = new SentenceReader();
        sentencesList = sentenceReader.readAllSentences(filepath);
        createBigramsForSentence(sentencesList, bigramListForSentence);

        sanitisedQueryWord = sentenceReader.sanitiseSentence(queryWord);
        createBigramsForQuery(sanitisedQueryWord);
        storeSimilarityScore(sentencesList, bigramListForWord, bigramListForSentence);

    }

    private void createBigramsForSentence(List<String> sentencesList, ArrayList<ArrayList<String>> bigramListForSentence){
        for (String s : sentencesList) {
            bigramListForSentence.add(new ArrayList<String>());
            if (s != "") {
                for (int j = 0; j < (s.length() - 2); j++) {
                    bigramListForSentence.get(lineCounter).add(s.substring(j, j + 2));
                }
            }
            lineCounter += 1;
        }
    }

    private void createBigramsForQuery(String queryWord){
        for (int i = 0; i < (queryWord.length() - 1); i++){
            bigramListForWord.add(queryWord.substring(i, i + 2));
        }
    }

    private void storeSimilarityScore(List<String> sentencesList, ArrayList<String> bigramListForWord, ArrayList<ArrayList<String>> bigramListForSentence){
        int sizeOfUnion = 0;

        for (int i = 0; i < 1; i++) {
            Set<String> unionSet = new HashSet<>();
            unionSet.addAll(bigramListForWord);

            unionSet.addAll(bigramListForSentence.get(i));
            sizeOfUnion = unionSet.size();
        }


//
//            for (int k = 0; k < bigramListForWord.size(); k++) {
//                for (int i = 0; i < bigramListForSentence.size(); i++) {
//                    for (int j = 0; j < bigramListForSentence.get(i).size(); j++) {
//                        if (bigramListForSentence.get(i).get(j).equals(bigramListForWord.get(k))) {
//                            sizeOfIntersection += 1;
//                            sizeOfUnion -= 1;
//                        }
//                    }
//                    sizeOfUnion = bigramListForSentence.get(i).size() + bigramListForWord.size();
//                    if (sizeOfIntersection != 0) {
//                        double score = Double.valueOf(sizeOfIntersection / sizeOfUnion);
//                        System.out.println(score);
//
////                            ScoredResult<String> scoredResult = new ScoredResult<String>(sentencesList.get(i), score);
////                            resultAndScoreList.add(scoredResult);
//                    }
//                }
//            }

    }

}
