import java.util.*;

public class GraphComponents
{
    public static <W> List<Set<W>> findConnectedComponents(ImmutableGraph<W, ?> graph)
    {
        List<Set<W>> components = new ArrayList<>();
        Map<W, Boolean> visited = new HashMap<>();

        for (W vertex : graph.wierzcholki())
        {
            visited.put(vertex, false);
        }

        for (W vertex : graph.wierzcholki())
        {
            if (!visited.get(vertex))
            {
                Set<W> component = new HashSet<>();
                dfs(graph, vertex, visited, component);
                components.add(component);
            }
        }

        return components;
    }

    private static <W> void dfs(IGraf<W, ?> graph, W vertex, Map<W, Boolean> visited, Set<W> component)
    {
        visited.put(vertex, true);
        component.add(vertex);
        for (W neighbour : graph.krawedzie(vertex))
        {
            if (!visited.get(neighbour))
            {
                dfs(graph, neighbour, visited, component);
            }
        }
    }

    public static <W> void printComponentsInfo(List<Set<W>> components)
    {
        System.out.println("Component size is: ");
        System.out.println(components.size());

        int i=1;
        for(Set<W> component : components)
        {

            System.out.println("The component number "+ i + " is");
            for(W element: component)
            {
                System.out.print(element+" ");
            }
            System.out.println();
            i++;
        }

    }
}
