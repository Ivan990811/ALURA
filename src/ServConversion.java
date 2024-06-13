import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ServConversion {

        public Tasa obtenerTasa(String divisaBase, String divisaObjetivo) {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c6eefd6536dcde5944397fe4/pair/" + divisaBase
                    + "/" + divisaObjetivo);

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

                // Verificar si la solicitud fue exitosa
                if (respuesta.statusCode() == 200) {
                    return new Gson().fromJson(respuesta.body(), Tasa.class);
                } else {
                    System.out.println("La solicitud HTTP no fue exitosa: " + respuesta.statusCode());
                    return null;
                }
            } catch (IOException | InterruptedException e) {
                // Manejar la excepción de manera adecuada
                e.printStackTrace();
                return null;
            }

        }
}
