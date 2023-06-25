package ngordnet.main;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

import static com.google.common.truth.Truth.assertThat;
public class TestWordNet {
    @Test
    public void checkDescend() {
        WordNet a = new WordNet("./data/wordnet/synsets11.txt", "./data/wordnet/hyponyms11.txt");
        List<String> b = a.getHyponymWord("descent");
        List<String> expected = new ArrayList<>(Arrays.asList("descent", "jump", "parachuting"));
        //assertThat(b.equals(expected));
        assertEquals(b, expected);
    }

    @Test
    public void checkChange() {
        WordNet a = new WordNet("./data/wordnet/synsets16.txt", "./data/wordnet/hyponyms16.txt");
        List<String> b = a.getHyponymWord("change");
        List<String> expected = new ArrayList<>
                (Arrays.asList("alteration", "change", "demotion", "increase", "jump", "leap", "modification", "saltation", "transition", "variation"));
        assertEquals(b, expected);
    }
}

