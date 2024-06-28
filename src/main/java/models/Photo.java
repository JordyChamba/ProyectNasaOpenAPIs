package models;

import java.util.List;

public class Photo {
    private int id;
    private int sol;
    private Camera camera;
    private String img_src;
    private String earth_date;
    private Rover rover;

    // Constructor
    public Photo(int id, int sol, Camera camera, String img_src, String earth_date, Rover rover) {
        this.id = id;
        this.sol = sol;
        this.camera = camera;
        this.img_src = img_src;
        this.earth_date = earth_date;
        this.rover = rover;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getSol() {
        return sol;
    }

    public Camera getCamera() {
        return camera;
    }

    public String getImgSrc() {
        return img_src;
    }

    public String getEarthDate() {
        return earth_date;
    }

    public Rover getRover() {
        return rover;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setImgSrc(String img_src) {
        this.img_src = img_src;
    }

    public void setEarthDate(String earth_date) {
        this.earth_date = earth_date;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
