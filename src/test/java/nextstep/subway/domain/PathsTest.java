package nextstep.subway.domain;

import nextstep.subway.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PathsTest {

    private Path 경로;

    @BeforeEach
    void setUp() {
        경로 = new Path();
    }

    @Test
    void 출발역과_도착역이_같을경우_경로를_조회할_수_없다(){
        assertThatThrownBy(() -> new Path())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("구간이 존재하지 않습니다.");
    }

    @Test
    void 출발역과_도착역이_같을경우_경로를_조회할_수_없다(){
        assertThatThrownBy(() -> new Path())
                .isInstanceOf(ApplicationException.class)
                .hasMessage("구간이 존재하지 않습니다.");
    }
}
