package ngordnet.main;

import edu.princeton.cs.algs4.In;
import net.sf.saxon.expr.Calculator;

import java.util.*;

public class WordNet {
    private Graph graph;
    private HashMap<Integer, String[]> wordMap;
    private ArrayList<String[]> wordList;  // convenient for looking wordId given a word

    // wrapper for a graph

    /**
     * Constructs an WordNet from iDAndName and wordRelationship.
     */
    public WordNet(String idAndName, String wordRelationship) {
        // build the graph -> add all the edges
        In inIdAndName = new In(idAndName);
        In inWordRelationship = new In(wordRelationship);
        wordMap = new HashMap<>();
        wordList = new ArrayList<>();

        while (inIdAndName.hasNextLine()) {
            String currentLine[] = inIdAndName.readLine().split(",");
            int wordId = Integer.parseInt(currentLine[0]);
            String synmWord[] = currentLine[1].split(" ");
            wordMap.put(wordId, synmWord);
            wordList.add(synmWord);
        }

        int wordNum = wordMap.size();
        graph = new Graph(wordNum);

        while (inWordRelationship.hasNextLine()) {
            String currentLine[] = inWordRelationship.readLine().split(",");
            int lineLength = currentLine.length;
            int startNode = Integer.parseInt(currentLine[0]);
            for (int i = 1; i < lineLength; i++) {
                graph.addEdge(startNode, Integer.parseInt(currentLine[i]));
            }
        }
    }

    // graph helper functions

    private Set<Integer> getNodes(String wordNode) {
        Set<Integer> wordIdSet = new HashSet<>();
        int i = 0;
        for (String[] a : wordList) {
            for (String b : a) {
                if (b.equals(wordNode)) {
                    wordIdSet.add(i);
                }
            }
            i += 1;
        }
        return wordIdSet;
    }

    public List<String> getHyponymWord(String wordNode) {
        Set<String> allHyponym = new HashSet<>();
        Set<Integer> wordIdSet = getNodes(wordNode);
        wordTraversal t = new wordTraversal(graph, wordIdSet);
        Set<Integer> allHyponymIdSet = t.traversalOrder();
        for (int i : allHyponymIdSet) {
            for (String s : wordMap.get(i)) {
               allHyponym.add(s);
            }
        }
        List<String> list = new ArrayList<>(allHyponym);
        Collections.sort(list);
        return list;
    }

    public List<String> getHyponymWord(List<String> wordNodes) {
        List<Set<String>> list = new ArrayList<>();


        for (String word : wordNodes) {
            list.add(new HashSet<>(getHyponymWord(word)));
        }
        Set<String> allWordsSet = new HashSet<>(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            allWordsSet.retainAll(list.get(i));
        }
        List<String> collectionsWordHyponyms = new ArrayList<>(allWordsSet);
        Collections.sort(collectionsWordHyponyms);
        return collectionsWordHyponyms;
    }
}
