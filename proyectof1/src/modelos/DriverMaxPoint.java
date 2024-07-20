package modelos;

public class DriverMaxPoint {
    private String DriverName;
    private float points;

    public DriverMaxPoint(String driverName, float points) {
        this.DriverName = driverName;
        this.points = points;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }
}
