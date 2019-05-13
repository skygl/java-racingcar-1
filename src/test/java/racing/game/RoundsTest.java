package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RoundsTest {
    @Test
    void 챔피언이_하나일때_챔피언계산() {
        List<Car> cars;
        try {
            cars = Arrays.asList(new Car[]{new Car("pobi", 2), new Car("jihoo"), new Car("jinwo")});
            List<Car> winners = new ArrayList<>();
            winners.add(cars.get(0));
            assertThat(Rounds.calculateChampions(cars)).isEqualTo(winners);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 챔피언이_여러명일때_챔피언계산() throws Exception {
        List<Car> cars;
        cars = Arrays.asList(new Car[]{new Car("pobi", 1), new Car("jihoo", 1), new Car("jinwo")});
        List<Car> winners = new ArrayList<>();
        winners.add(cars.get(1));
        winners.add(cars.get(0));
        HashSet<Car> winnerSet = new HashSet<>(winners);
        assertThat(new HashSet(Rounds.calculateChampions(cars))).isEqualTo(winnerSet);
    }
}
