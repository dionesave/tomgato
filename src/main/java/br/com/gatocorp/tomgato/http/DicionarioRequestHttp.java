package br.com.gatocorp.tomgato.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DicionarioRequestHttp {

	public static final String URL_GET = "http://localhost:8080/";
	
	
	public String acessoGET(Long indice) {
	
		HttpClient client = HttpClient.newHttpClient();
		
		
		HttpRequest request = HttpRequest.newBuilder()
		          .GET()
		          .timeout(Duration.ofSeconds(10))
		          .uri(URI.create(URL_GET+indice))
		          .header("accept", "application/json")
		          .build();
		
		HttpResponse<String> response;
		
		try {
			
			response = client.send(request,HttpResponse.BodyHandlers.ofString());
			
			return response.body();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	
	}
}
