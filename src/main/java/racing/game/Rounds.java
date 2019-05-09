package racing.game;


import racing.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Rounds {
    private static final int BOUNDARY = 4;


    private static int getRandomValue() {

        return (int) (Math.random() * 10);
    }

    public static boolean canMove(int randomValue) {
        if (randomValue >= BOUNDARY) {
            return true;
        }
        return false;
    }

    public static void doRound(List<Car> cars) {
        for (Car car : cars) {
            if (canMove(getRandomValue())) {
                car.move();
            }
        }
        OutputView.showCarsPosition(cars);

    }

    public static List<Car> calculateChampions(List<Car> cars) {
        List<Car> winnerList = new ArrayList<>();
        while (winnerList.size() == 0 ||
                winnerList.get(0).compareTo(Collections.max(cars,
                        (o1, o2) -> o1.compareTo(o2))) == 0) {
            Car winner = Collections.max(cars, (o1, o2) -> o1.compareTo(o2));
            winnerList.add(winner);
            cars.remove(winner);
        }
        return winnerList;
    }

}
