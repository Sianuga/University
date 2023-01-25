import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Main
{
    @Test
    public static void testImmutableGraph()
    {
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("A", List.of("B", "C"));
        edges.put("B", List.of("C", "D"));
        edges.put("C", List.of("D"));
        edges.put("D", List.of());

        Map<String, Map<String, Integer>> labels = new HashMap<>();
        labels.put("A", Map.of("B", 1, "C", 2));
        labels.put("B", Map.of("C", 3, "D", 4));
        labels.put("C", Map.of("D", 5));

        ImmutableGraph<String, Integer> graph = new ImmutableGraph<>(edges, labels);

        assertEquals(List.of("A", "B", "C","D"), graph.wierzcholki());
       for(String a:  graph.wierzcholki())
       {
           System.out.println(a);
       }

        assertEquals(1, graph.krawedz("A", "B"));

        System.out.println(       graph.krawedz("A","M"));


        assertEquals(List.of("C", "D"), graph.krawedzie("B"));

        for(String a: graph.krawedzie("M"))
        {
            System.out.println(a);
        }

        assertNull(graph.krawedz("D", "A"));

        Map<Integer, List<Integer>> edges2 = new HashMap<>();
        edges2.put(1, List.of(2,3,4));
        edges2.put(2, List.of(3));
        edges2.put(3, List.of(4));
        edges2.put(4, List.of());
        edges2.put(5, List.of(6));
        edges2.put(6, List.of());

        Map<Integer, Map<Integer,String>> labels2 = new HashMap<>();
        labels2.put(1, Map.of(2, "A", 3, "B", 4, "C"));
        labels2.put(2, Map.of(3, "D"));
        labels2.put(3, Map.of(4, "E"));
        labels2.put(5, Map.of(6, "F"));



        ImmutableGraph<Integer, String> graph2 = new ImmutableGraph<>(edges2, labels2);


        assertEquals(List.of(1, 2, 3,4,5,6), graph2.wierzcholki());
        assertEquals("E", graph2.krawedz(3, 4));
        assertEquals(List.of(2,3,4), graph2.krawedzie(1));
        assertNull(graph2.krawedz(5, 4));


    }

    @Test
    public static void testGraphComponents()
    {

        Map<String, List<String>> edges = new HashMap<>();
        edges.put("A", List.of("B", "C"));
        edges.put("B", List.of("C"));
        edges.put("C", List.of());
        edges.put("D", List.of());

        Map<String, Map<String, Integer>> labels = new HashMap<>();
        labels.put("A", Map.of("B", 1, "C", 2));
        labels.put("B", Map.of("C", 3));


        ImmutableGraph<String, Integer> graph = new ImmutableGraph<>(edges, labels);

        List<Set<String>> connectedComponents = GraphComponents.findConnectedComponents(graph);

        assertEquals(2,connectedComponents.size());



        assertEquals(new HashSet<>(List.of("A","B","C")),connectedComponents.get(0));
        assertEquals(new HashSet<>(List.of("D")),connectedComponents.get(1));

        GraphComponents.printComponentsInfo(connectedComponents);



        Map<Integer, List<Integer>> edges2 = new HashMap<>();
        edges2.put(1, List.of(2,3,4));
        edges2.put(2, List.of(3));
        edges2.put(3, List.of(4));
        edges2.put(4, List.of());
        edges2.put(5, List.of(6));
        edges2.put(6, List.of());

        Map<Integer, Map<Integer,String>> labels2 = new HashMap<>();
        labels2.put(1, Map.of(2, "A", 3, "B", 4, "C"));
        labels2.put(2, Map.of(3, "D"));
        labels2.put(3, Map.of(4, "E"));
        labels2.put(5, Map.of(6, "F"));



        ImmutableGraph<Integer, String> graph2 = new ImmutableGraph<>(edges2, labels2);

        List<Set<Integer>> connectedComponents2 = GraphComponents.findConnectedComponents(graph2);
        assertEquals(2, connectedComponents2.size());
        assertEquals(new HashSet<>(List.of(1, 2, 3, 4)), connectedComponents2.get(0));
        assertEquals(new HashSet<>(List.of(5, 6)), connectedComponents2.get(1));
    }

    public static void main(String[] args)
    {
       // testImmutableGraph();
        testGraphComponents();
    }


}
