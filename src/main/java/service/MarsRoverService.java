package service;

import com.google.gson.Gson;
import models.ApiResponse;
import models.Photo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MarsRoverService {

    private static final String API_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos";
    private static final String API_KEY = "DEMO_KEY";
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10); // Pool de hilos

    public List<Photo> fetchFilteredPhotos(String cameraName, String sol, String earthDate) {
        List<CompletableFuture<List<Photo>>> futures = new ArrayList<>();

        // Realizar 7 peticiones paralelas, una por cada cámara
        for (String camera : getSupportedCameras()) {
            CompletableFuture<List<Photo>> future = CompletableFuture.supplyAsync(() ->
                    fetchPhotos(camera, sol, earthDate), executorService);
            futures.add(future);
        }

        // Combinar los resultados de todas las peticiones
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));

        // Esperar hasta que todas las peticiones estén completas
        allOf.join();

        // Obtener la lista de fotos de todos los futures completados
        return futures.stream()
                .flatMap(future -> future.join().stream())
                .collect(Collectors.toList());
    }

    private List<String> getSupportedCameras() {
        // Lista de cámaras soportadas, puedes ajustar según tus necesidades
        return List.of("FHAZ", "NAVCAM", "MAST", "CHEMCAM", "MAHLI", "MARDI", "RHAZ");
    }

    private List<Photo> fetchPhotos(String cameraName, String sol, String earthDate) {
        List<Photo> photos = new ArrayList<>();

        try {
            URL url = new URL(buildUrl(cameraName, sol, earthDate));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Introduce un retraso para evitar la tasa de solicitud excesiva
            Thread.sleep(1000); // Retraso de 1 segundo entre solicitudes

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.toString(), ApiResponse.class);
            photos = apiResponse.getPhotos();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return photos;
    }


    private String buildUrl(String cameraName, String sol, String earthDate) {
        StringBuilder urlBuilder = new StringBuilder(API_URL);
        urlBuilder.append("?api_key=").append(API_KEY);

        if (cameraName != null && !cameraName.isEmpty()) {
            urlBuilder.append("&camera=").append(cameraName);
        }
        if (sol != null && !sol.isEmpty()) {
            urlBuilder.append("&sol=").append(sol);
        }
        if (earthDate != null && !earthDate.isEmpty()) {
            urlBuilder.append("&earth_date=").append(earthDate);
        }

        return urlBuilder.toString();
    }
}
