package nextstep.subway.strategy;

import nextstep.subway.domain.ShortestPathType;

public interface ShortestPath {
    int weight();
    boolean supported(ShortestPathType shortestPathType);
}
