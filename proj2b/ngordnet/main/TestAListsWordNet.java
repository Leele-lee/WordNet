package ngordnet.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAListsWordNet {
    @Test
    public void simpleTest() {
        WordNet a = new WordNet("./data/wordnet/synsets16.txt", "./data/wordnet/hyponyms16.txt");
        List<String> words = List.of("change", "occurrence");
        List<String> b = a.getHyponymWord(words);
        List<String> expected = new ArrayList<>
                (Arrays.asList("alteration", "change", "increase", "jump", "leap", "modification", "saltation", "transition"));
        assertEquals(b, expected);
    }

    @Test
    public void complexTest() {
        WordNet a = new WordNet("./data/wordnet/synsets.txt", "./data/wordnet/hyponyms.txt");
        List<String> words = List.of("video", "recording");
        List<String> b = a.getHyponymWord(words);
        List<String> expected = new ArrayList<>
                (Arrays.asList("video", "video_recording", "videocassette", "videotape"));
        assertEquals(b, expected);

        List<String> words2 = List.of("pastry", "tart");
        List<String> b2 = a.getHyponymWord(words2);
        List<String> expected2 = new ArrayList<>
                (Arrays.asList("apple_tart", "lobster_tart", "quiche", "quiche_Lorraine", "tart", "tartlet"));
        assertEquals(b2, expected2);
    }
}
