package ngordnet.main;

import ngordnet.browser.NgordnetQuery;
import ngordnet.browser.NgordnetQueryHandler;

import java.util.List;
import java.util.Set;

public class HyponymsHandler extends NgordnetQueryHandler {
    WordNet wn;
    public HyponymsHandler(WordNet wn) {
        this.wn = wn;
    }

    public String handle(NgordnetQuery q) {
        String wnsb = new String();
        List<String> words = q.words();
        int wordsNum = words.size();
        int startYear = q.startYear();
        int endYear = q.endYear();

        for (String word : words) {
            wnsb =  wn.getHyponymWord(word).toString();
        }
        return wnsb;

    }
}
