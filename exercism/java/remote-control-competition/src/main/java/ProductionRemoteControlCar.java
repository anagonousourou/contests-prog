
class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int nbVictories = 0;
    private int distanceTravelled = 0;

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.nbVictories;
    }

    public void setNumberOfVictories(int numberofVictories) {
        this.nbVictories = numberofVictories;
    }

    @Override
    public void drive() {
        this.distanceTravelled += 10;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return this.getNumberOfVictories() - o.getNumberOfVictories();
    }
}
