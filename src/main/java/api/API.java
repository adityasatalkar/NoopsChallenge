package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.*;

public class API {

	private static final String RESPONSE_BODY_TYPE = "application/json";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CACHE_CONTROL = "Cache-Control";
	private static final String NO_CACHE = "no-cache";
	private static final String CONNECTION = "Connection";
	private static final String KEEP_ALIVE = "keep-alive";
	private static final String URL_SCHEME = "https://";
	private static final String URL_HOST = "api.noopschallenge.com";
	private static final String HOST = "Host";
	private static final String ACCEPT_ENCODING = "accept-encoding";
	private static final String ENCODING_TYPE = "gzip, deflate";
	private static final String ACCEPT = "Accept";

	public static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(json);
	}

	// example url 		= "/fizzbot/questions/R1Z-zESvapYsunTshvRZQivQLRhwk97zCeAjqBekgaU";
	public static String get(String url) throws Exception {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url(URL_SCHEME + URL_HOST + url)
				.get()
				.addHeader(ACCEPT, "*/*")
				.addHeader(CACHE_CONTROL, NO_CACHE)
				.addHeader(HOST, URL_HOST)
				.addHeader(ACCEPT_ENCODING, ENCODING_TYPE)
				.addHeader(CONNECTION, KEEP_ALIVE)
				.build();

		Response response = client.newCall(request).execute();
		String prettyJsonResponse = toPrettyFormat(response.body().string());
		String resultString = url + "\n" + prettyJsonResponse + "\n\n";
		FileOperations.appendToFile(resultString);
		return resultString;
	}

	// example answer	= "{\n\t\"answer\": \"1 Beep 3 Beep Boop Beep 7 Beep 9 BeepBoop\"\n}"
	public static String post(String url, String answer) throws Exception {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse(RESPONSE_BODY_TYPE);
		RequestBody body = RequestBody.create(mediaType, answer);
		Request request = new Request.Builder()
				.url(URL_SCHEME + URL_HOST + url)
				.post(body)
				.addHeader(CONTENT_TYPE, RESPONSE_BODY_TYPE)
				.addHeader(ACCEPT, "*/*")
				.addHeader(CACHE_CONTROL, NO_CACHE)
				.addHeader(HOST, URL_HOST)
				.addHeader(ACCEPT_ENCODING, ENCODING_TYPE)
				.addHeader("content-length", "58")
				.addHeader(CONNECTION, KEEP_ALIVE)
				.build();

		Response response = client.newCall(request).execute();
		return toPrettyFormat(response.body().string());
	}

	public static void main(String[] args) throws Exception {
		String url = "/fizzbot/questions/DmsVRw515Udx07iNE8QtwEZzxkLQ6x-M0YDJaN1JptA";
		System.out.println(get(url));
//		post(url,"{\"answer\":\"COBOL\"}");
	}
}