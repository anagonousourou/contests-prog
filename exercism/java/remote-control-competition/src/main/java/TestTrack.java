import java.util.List;
import java.util.stream.Collectors;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        return List.of(prc1,prc2).stream().sorted().collect(Collectors.toList());
    }
}
