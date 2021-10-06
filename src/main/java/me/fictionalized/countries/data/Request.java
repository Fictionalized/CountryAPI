package me.fictionalized.countries.data;

import com.google.gson.Gson;
import lombok.Cleanup;
import lombok.SneakyThrows;
import me.fictionalized.countries.config.Config;
import me.fictionalized.countries.objects.Country;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {

    private boolean allCountries = false;
    private String country;

    public Request() {
        allCountries = true;
    }

    public Request(String country) {
        this.country = country;
    }

    public String getEndpoint() {
        return "http://api.countrylayer.com/v2/name/" + (allCountries ? "all" : country) + "?access_key=" + Config.API_KEY;
    }

    public Country getCountry() {
        return getCountries()[0];
    }

    public Country[] getCountries() {
        return new Gson().fromJson(connect(), Country[].class);
    }

    @SneakyThrows
    public String connect() {
        final URL url = new URL(getEndpoint());
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "CountryAPI");

        connection.setDoOutput(true);
        connection.setRequestMethod("GET");

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        connection.setInstanceFollowRedirects(false);

        @Cleanup
        final BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );

        final StringBuilder content = new StringBuilder();

        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            content.append(inputLine);
        }

        return content.toString();
    }

}
