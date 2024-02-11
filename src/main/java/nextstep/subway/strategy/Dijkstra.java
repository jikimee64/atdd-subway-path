package nextstep.subway.strategy;

import nextstep.subway.domain.ShortestPathType;
import nextstep.subway.domain.Station;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.springframework.stereotype.Component;

import static nextstep.subway.domain.ShortestPathType.DIJKSTRA;

@Component
public class Dijkstra implements ShortestPath {

    DijkstraShortestPath dijkstraShortestPath;

    public Dijkstra() {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        dijkstraShortestPath = new DijkstraShortestPath(graph);
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public boolean supported(ShortestPathType shortestPathType) {
        return shortestPathType == DIJKSTRA;
    }
}
