/**
 * Question class holds true-false and multiple choice questions
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class Question {
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String e;
	private String correctAnswer;
	private String explanation;
	private int type;

	// true-false question constructor
	public Question(String question, String answer) {
		this.question = question;
		this.correctAnswer = answer;
		this.type = 0;
	}

	// multiple choice question constructor
	public Question(String question, String a, String b, String c, String d,
			String e, String explanation, String correctAnswer) {
		this.correctAnswer = a;
		this.question = question;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.explanation = explanation;
		this.correctAnswer = correctAnswer;
		this.type = 1;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
