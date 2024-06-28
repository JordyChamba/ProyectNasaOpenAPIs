package models;

public class Camera {
    private int id;
    private String name;
    private int rover_id;
    private String full_name;

    // Constructor
    public Camera(int id, String name, int rover_id, String full_name) {
        this.id = id;
        this.name = name;
        this.rover_id = rover_id;
        this.full_name = full_name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRoverId() {
        return rover_id;
    }

    public String getFullName() {
        return full_name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoverId(int rover_id) {
        this.rover_id = rover_id;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }
}
