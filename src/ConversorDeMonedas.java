import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ConversorDeMonedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/f611346cbed4fc5204eae0a4/latest/USD";

    public static double obtenerTasaCambio(String monedaDestino) throws Exception {
        if (monedaDestino == null || monedaDestino.isEmpty()) {
            throw new IllegalArgumentException("La moneda destino no puede ser nula o vacía.");
        }

        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Error en la conexión: Código de respuesta " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        conn.disconnect();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getJSONObject("conversion_rates").getDouble(monedaDestino);
    }
}
