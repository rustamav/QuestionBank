import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class deals with the question and answer files. It creates an arraylists
 * to hold questions and answers in appropriate positions, so the for each
 * question the answer could be found
 * 
 * @author wanhrust
 * 
 */
public class QuestionAnswerHolder {

	private List<String> QL = new ArrayList<String>();
	private List<String> AL = new ArrayList<String>();

	/**
	 * Default constructor. Tries to read from a question.txt and answer.txt
	 * files.
	 * 
	 * @throws IOException
	 *             Throws this exception in case there is some problem with
	 *             reading files. Terminates the program.
	 */
	QuestionAnswerHolder() throws IOException {
		// TODO Auto-generated method stub

		String s;
		String[] parts;

		DataInputStream inQuestion = new DataInputStream(
				new BufferedInputStream(new FileInputStream("question.txt")));
		DataInputStream inAnswer = new DataInputStream(new BufferedInputStream(
				new FileInputStream("answer.txt")));
		while ((s = inQuestion.readLine()) != null) {
			parts = s.split("\\.", 2);
			QL.add(parts[1]);
		}
		while ((s = inAnswer.readLine()) != null) {
			parts = s.split("\\.", 2);
			AL.add(parts[1]);
		}
	}

	/**
	 * Prints all questions and answers to them.
	 */
	public void printAll() {
		for (int i = 0; i < QL.size(); i++) {
			System.out.println(QL.get(i) + " " + AL.get(i));
		}
	}

	/**
	 * Returns the number of questions which were read from a file.
	 * 
	 * @return
	 */
	public int getNumberOfQuestion() {
		return QL.size();
	}

	/**
	 * Function returns the random question from a questions set and its answer
	 * as a concatenated string. # is used to concatenate questoin with
	 * appropriate answer.
	 * 
	 * @return
	 * String - concatenated question with answer. (e.g. Is ant stronger than elephant?#True)
	 */
	public String getRandomQuestion() {
		int index = (int) (Math.random() * QL.size());
		String q = QL.get(index);
		String a = AL.get(index);
		QL.remove(index);
		AL.remove(index);
		String s = q + "#" + a;
		return s;
	}
}
