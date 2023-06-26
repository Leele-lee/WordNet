package ngordnet.main;

import ngordnet.browser.NgordnetQuery;
import ngordnet.browser.NgordnetQueryHandler;

import java.util.*;

public class HyponymsHandler extends NgordnetQueryHandler {
    WordNet wn;
    public HyponymsHandler(WordNet wn) {
        this.wn = wn;
    }

    public String handle(NgordnetQuery q) {
        String wnsb = new String();
        List<Set<String>> list = new ArrayList<>();
        Set<String> allWordsSet = new HashSet<>();

        List<String> words = q.words();
        int wordsNum = words.size();
        int startYear = q.startYear();
        int endYear = q.endYear();

        return wn.getHyponymWord(words).toString();
    }
}
