package ngordnet.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

public class TestGraph {
    @Test
    public void testFromSpec() {
        Graph test1 = new Graph(3);
        test1.addEdge(0, 1);
        test1.addEdge(0, 2);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(test1.getAdj(0).equals(expected));
    }
}
