package com.hipp.notificationservice.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hipp.notificationservice.domain.NotificationRegistry;
import com.hipp.notificationservice.domain.NotificationRequest;

import reactor.core.publisher.Mono;

@Component
public class NotificationHandler {
	
//	@Autowired
//	WebClient webclient;
	
	public Mono<ServerResponse> registration(@RequestBody ServerRequest request) {
		return request.bodyToMono(NotificationRequest.class)
			.map(req -> registration(req))
			.flatMap(notificationRegistry -> ServerResponse.ok().body(notificationRegistry, NotificationRegistry.class));
	}
	
	public Mono<ServerResponse> deregistration(@RequestBody ServerRequest request) {
		return request.bodyToMono(NotificationRequest.class)
				.map(req -> deregistration(req))
				.flatMap(obj -> ServerResponse.ok().body(BodyInserters.fromValue("Deregistered")));
	}
	
	private Mono<NotificationRegistry> registration(NotificationRequest request) {	
		WebClient webClient = WebClient.create();
		return webClient
				.method(HttpMethod.POST)
				.uri("http://database-service:8080/registration")
				.body(BodyInserters.fromValue(request))
				.retrieve()
				.bodyToMono(NotificationRegistry.class);
		
		
//		return webclient
//		  .baseUrl("http://database-service:8080")
//		  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
//		  .defaultUriVariables(Collections.singletonMap("url", "http://database-service:8080"))
//		  .build()
//		  .post()
//		  .uri("/registration")
//		  .body(BodyInserters.fromValue(request))
//		  .retrieve()
//		  .bodyToMono(NotificationRegistry.class);
	}
	
	private Mono<Void> deregistration(NotificationRequest request) {
		System.out.println("Id:" + request.getNotificationId());
		WebClient webClient = WebClient.create();
		return webClient
			.method(HttpMethod.DELETE)
			.uri("http://database-service:8080/deregistration")
			.body(BodyInserters.fromValue(request))
			.retrieve()
			.bodyToMono(Void.class);
			
		
		
//		return webclient
//		  .baseUrl("http://database-service:8080")
//		  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
//		  .defaultUriVariables(Collections.singletonMap("url", "http://database-service:8080"))
//		  .build()
//		  .method(HttpMethod.DELETE)
//		  .uri("/deregistration")
//		  .body(BodyInserters.fromValue(request))
//		  .retrieve()
//		  .bodyToMono(Void.class);
	}

//	public Mono<ServerResponse> push(@RequestBody ServerRequest request) {	
//		return request.bodyToMono(NotificationRequest.class)
//				.map(req -> req.getNotificationId())
//				.flatMap(id -> notificationService.fetchNotificationRegistry(id))
//				.map(notificationRegisrtry -> objectToJsonAndSendMessage(notificationRegisrtry))
//				.flatMap(jsonData -> ServerResponse.ok().bodyValue(jsonData));
//	}
//	private String objectToJsonAndSendMessage(NotificationRegistry notificationRegistry) {
//		ObjectMapper objectMapper = new ObjectMapper();
//		try {
//			String jsonString = objectMapper.writeValueAsString(notificationRegistry);
//			String notificationUrl = notificationRegistry.getNotificationUrl();
//			return sendMessage(jsonString, notificationUrl);
//		} catch (JsonProcessingException e) {
//			logger.error("objectToJsonAndSendMessage: " + e.getMessage());
//		}
//		return "";
//	}
//	
//	private String sendMessage(String jsonString, String url) {
//		try {
//			HttpURLConnection conn = openConnection(url);
//			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
//			out.write(jsonString);
//			out.close();
//			new InputStreamReader(conn.getInputStream());
//		} catch (IOException e) {
//			logger.error("sendMessage: " + e.getMessage());
//		}
//		return jsonString;
//	}
//	
//	private HttpURLConnection openConnection(String url) throws IOException {
//		HttpURLConnection conn;
//		URL httpUrl;
//
//		httpUrl = new URL(url);
//		conn = (HttpURLConnection) httpUrl.openConnection();
//		conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
//		conn.setRequestMethod("POST");
//		conn.setDoOutput(true);
//		conn.setConnectTimeout(1000);
//		return conn;
//
//	}
}
