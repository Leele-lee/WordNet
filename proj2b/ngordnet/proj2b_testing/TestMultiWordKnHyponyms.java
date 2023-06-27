package ngordnet.proj2b_testing;

import ngordnet.browser.NgordnetQuery;
import ngordnet.browser.NgordnetQueryHandler;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class TestMultiWordKnHyponyms {
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String WORDS_FILE49887 = "data/ngrams/top_49887_words.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";
    public static final String LARGE_SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String LARGE_HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    /** This is an example from the spec.*/
    @Test
    public void testFoodAndCAkeK5() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE49887, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("food", "cake");

        NgordnetQuery nq = new NgordnetQuery(words, 1950, 1990, 5);
        String actual = studentHandler.handle(nq);
        String expected = "[biscuit, cake, kiss, snap, wafer]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testEnergyAndLightAndBeamK5() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE49887, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("energy", "light", "beam");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 5);
        String actual = studentHandler.handle(nq);
        String expected = "[beam, irradiation, ray, shaft]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testbookAnimalK5() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE49887, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("book", "animal");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 5);
        String actual = studentHandler.handle(nq);
        String expected = "[]";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMapFunctionK10() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE49887, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);
        List<String> words = List.of("map", "function");

        NgordnetQuery nq = new NgordnetQuery(words, 1900, 2020, 10);
        String actual = studentHandler.handle(nq);
        String expected =
                "[expansion, function, identity, " +
                        "map, operator, sec, series, sin, transformation, translation]";
        assertThat(actual).isEqualTo(expected);
    }
}
