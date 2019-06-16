package json.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResponseJsonData {

	@SerializedName("nextQuestion")
	@Expose
	private String nextQuestion;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("result")
	@Expose
	private String result;

	public String getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(String nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}