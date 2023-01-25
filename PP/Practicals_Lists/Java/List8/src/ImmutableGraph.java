import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableGraph<W, S> implements IGraf<W, S>
{
    private Map<W, List<W>> edges;
    private Map<W, Map<W, S>> labels;

    public ImmutableGraph(Map<W, List<W>> edges, Map<W, Map<W, S>> labels)
    {
        this.edges = new HashMap<>(edges);
        this.labels = new HashMap<>(labels);
    }

    @Override
    public List<W> wierzcholki()
    {
        return List.copyOf(edges.keySet());
    }

    @Override
    public S krawedz(W w1, W w2)
    {
        if (!labels.containsKey(w1) || !labels.get(w1).containsKey(w2))
        {
            return null;
        }
        return labels.get(w1).get(w2);
    }

    @Override
    public List<W> krawedzie(W w)
    {
        if (!edges.containsKey(w))
        {
            return List.of();
        }

        return List.copyOf(edges.get(w));
    }
}