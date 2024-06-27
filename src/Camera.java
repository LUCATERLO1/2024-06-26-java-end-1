public class Camera {

    private int floor;
    private String name;

    public Camera(int floor, String name) {

        setFloor(floor);
        setName(name);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return getName() + " (" + getFloor() + "° piano)";
    }
}
