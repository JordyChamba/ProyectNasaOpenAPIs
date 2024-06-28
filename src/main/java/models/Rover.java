package models;

import java.util.List;

public class Rover {
    private int id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;
    private int max_sol;
    private String max_date;
    private int total_photos;
    private List<Camera> cameras;

    // Constructor
    public Rover(int id, String name, String landing_date, String launch_date, String status, int max_sol, String max_date, int total_photos, List<Camera> cameras) {
        this.id = id;
        this.name = name;
        this.landing_date = landing_date;
        this.launch_date = launch_date;
        this.status = status;
        this.max_sol = max_sol;
        this.max_date = max_date;
        this.total_photos = total_photos;
        this.cameras = cameras;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLandingDate() {
        return landing_date;
    }

    public String getLaunchDate() {
        return launch_date;
    }

    public String getStatus() {
        return status;
    }

    public int getMaxSol() {
        return max_sol;
    }

    public String getMaxDate() {
        return max_date;
    }

    public int getTotalPhotos() {
        return total_photos;
    }

    public List<Camera> getCameras() {
        return cameras;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLandingDate(String landing_date) {
        this.landing_date = landing_date;
    }

    public void setLaunchDate(String launch_date) {
        this.launch_date = launch_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaxSol(int max_sol) {
        this.max_sol = max_sol;
    }

    public void setMaxDate(String max_date) {
        this.max_date = max_date;
    }

    public void setTotalPhotos(int total_photos) {
        this.total_photos = total_photos;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
    }
}
