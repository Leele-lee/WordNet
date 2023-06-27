package ngordnet.main;

import ngordnet.browser.NgordnetQuery;
import ngordnet.browser.NgordnetQueryHandler;
import ngordnet.ngrams.NGramMap;
import java.util.*;

public class HyponymsHandler extends NgordnetQueryHandler {
    WordNet wn;
    NGramMap ngm;
    HashMap<String, Double> wordPopul = new HashMap<>();

    public HyponymsHandler(WordNet wn, NGramMap ngm) {
        this.wn = wn;
        this.ngm = ngm;
    }

    public String handle(NgordnetQuery q) {
        String wnsb = new String();
        List<String> kWords = new ArrayList<>();


        List<String> words = q.words();
        int startYear = q.startYear();
        int endYear = q.endYear();
        int k = q.k();

        List<String> allWordList = wn.getHyponymWord(words);
        int listSize = allWordList.size();
        int index = Math.min(listSize, k);

        if (k == 0) {
            return allWordList.toString();
        } else {
            PriorityQueue<String> maxPQ = new PriorityQueue<>((o1, o2) -> {
                Double sum1 = wordPopularity(ngm, o1, startYear, endYear);
                Double sum2 = wordPopularity(ngm, o2, startYear, endYear);
                return (int)(sum2 - sum1);
            });
            for (String word : allWordList) {
                maxPQ.add(word);
            }
            for (int i = 0; i < index; i++) {
                String maxWord = maxPQ.poll();
                if (!wordPopul.get(maxWord).equals(0.0)) {
                    kWords.add(maxWord);
                }
            }
            Collections.sort(kWords);
            return kWords.toString();
        }

    }

    private Double wordPopularity(NGramMap ngm, String word, Integer startYear, Integer endYear) {
        Double popularityNum = 0.0;
        for (Double value : ngm.countHistory(word, startYear, endYear).values()) {
            popularityNum += value;
        }
        wordPopul.put(word, popularityNum);
        return popularityNum;
    }
}
