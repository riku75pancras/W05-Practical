import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.text.DecimalFormat;

public class SimilarityScores {

    ArrayList<String> sentencesList = new ArrayList<String>();
    ArrayList<String> bigramListForWord = new ArrayList<String>();
    ArrayList<ArrayList<String>> bigramListForSentence = new ArrayList<>();
    ArrayList<ScoredResult> resultAndScoreList = new ArrayList<ScoredResult>();
    private int lineCounter;
    private String sanitisedQueryWord;

    public void printSimilarityScore(String filepath, String queryWord) throws IOException {
        SentenceReader sentenceReader = new SentenceReader();
        sentencesList = sentenceReader.readAllSentences(filepath);
        createBigramsForSentence(sentencesList, bigramListForSentence);

        sanitisedQueryWord = sentenceReader.sanitiseSentence(queryWord);
        createBigramsForQuery(sanitisedQueryWord);
        storeSimilarityScore(sentencesList, bigramListForWord, bigramListForSentence);

    }

    private void createBigramsForSentence(List<String> sentencesList, ArrayList<ArrayList<String>> bigramListForSentence) {
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

    private void createBigramsForQuery(String queryWord) {
        for (int i = 0; i < (queryWord.length() - 1); i++) {
            bigramListForWord.add(queryWord.substring(i, i + 2));
        }
    }

    private void storeSimilarityScore(List<String> sentencesList, ArrayList<String> bigramListForWord, ArrayList<ArrayList<String>> bigramListForSentence) {
        for (int i = 0; i < bigramListForSentence.size(); i++) {
            int sizeOfUnion = 0;
            int sizeOfIntersection = 0;

            Set<String> bigramSet = new HashSet<>();

            bigramSet.addAll(bigramListForSentence.get(i));
            bigramSet.addAll(bigramListForWord);
            sizeOfUnion = bigramSet.size();

            Set<String> intersectionSet = new HashSet<>();
            intersectionSet.addAll(bigramListForSentence.get(i));

            for (int k = 0; k < bigramListForWord.size(); k++) {
                if (intersectionSet.contains(bigramListForWord.get(k))) {
                    sizeOfIntersection += 1;
                }
            }
            if (sizeOfIntersection != 0) {
                double similarityScore = (double) sizeOfIntersection / sizeOfUnion;
                System.out.println(similarityScore);
            }
        }
    }
}


            //need to use at last
//            DecimalFormat df = new DecimalFormat("#.####");
//
////            String similarityScore4dp = df.format(similarityScore);
////            System.out.println(similarityScore4dp);
//
//            ScoredResult<String> scoredResult = new ScoredResult<>(sentencesList.get(i), score);
//            resultAndScoreList.add(scoredResult);



//

//                    }
//                }
//            }
