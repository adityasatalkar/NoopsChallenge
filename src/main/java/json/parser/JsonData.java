package json.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonData {

	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("rules")
	@Expose
	private List<Rule> rules = null;
	@SerializedName("numbers")
	@Expose
	private List<Integer> numbers = null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
}