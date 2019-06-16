package api;

import com.adityasatalkar.FileOperations;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import json.parser.JsonData;
import json.parser.PostResponseJsonData;

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

	public static String answerJsonifyString(String answer) {
		return "{\n\t\"answer\": \"" + answer + "\"\n}";
	}

	public static JsonData get(String url) throws Exception {
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

		String responseBodyString = response.body().string();
		FileOperations.appendToFile("\n\nGET : " + url + "\n" + FileOperations.toPrettyFormat(responseBodyString), "NoopsChallengeCompleted");

		JsonData jsonData = new Gson().fromJson(responseBodyString, JsonData.class);
		return jsonData;
	}

	public static PostResponseJsonData post(String url, String answer) throws Exception {
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
		String responseBodyString = response.body().string();
		FileOperations.appendToFile("POST :\n" + answer + "\nresponse :\n" + FileOperations.toPrettyFormat(responseBodyString),"NoopsChallengeCompleted");

		PostResponseJsonData postResponseJsonData = new Gson().fromJson(responseBodyString, PostResponseJsonData.class);
		return postResponseJsonData;
	}
}