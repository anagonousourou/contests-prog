public class ElonsToyCar {

    private int distanceDriven = 0;
    private int batteryLevel = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters",this.distanceDriven);
    }

    public String batteryDisplay() {
        return this.batteryLevel ==0 ? "Battery empty" : String.format("Battery at %d%%",this.batteryLevel);
    }

    public void drive() {
        if(batteryLevel > 0){
            this.distanceDriven +=20;
            this.batteryLevel -=1;
        }

    }
}
