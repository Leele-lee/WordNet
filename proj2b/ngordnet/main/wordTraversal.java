package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.Set;

public class wordTraversal {
    private boolean[] marked;
    Set<Integer> inorder;

    public wordTraversal(Graph G, Set<Integer> wordIdSet) {
        marked = new boolean[G.V()];
        inorder = new HashSet<>();
        for (Integer i : wordIdSet) {
            dfs(G, i);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        inorder.add(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public Set<Integer> traversalOrder() {
        return inorder;
    }

}
