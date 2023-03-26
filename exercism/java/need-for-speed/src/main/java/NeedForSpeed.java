class NeedForSpeed {

    private int speed;
    private int batteryDrain;
    private int distanceDriven = 0;
    private int batteryLevel = 100;

    NeedForSpeed(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.batteryLevel == 0;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if(this.batteryLevel > 0){
            this.batteryLevel -= this.batteryDrain;
            this.distanceDriven += speed;
        }
    }

    public static NeedForSpeed nitro() {
       return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;
    RaceTrack(int distance){
        this.distance = distance;
    }
    public boolean tryFinishTrack(NeedForSpeed car) {
        while(!car.batteryDrained() && car.distanceDriven() < this.distance){
            car.drive();
        }
        return car.distanceDriven() >= this.distance;
    }
}
