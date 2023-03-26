public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled = 0;

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    @Override
    public void drive() {
        this.distanceTravelled += 20;

    }
}
