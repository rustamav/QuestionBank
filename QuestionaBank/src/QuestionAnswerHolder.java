import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * QuestionAnswerHolder class connects to database and reads 20 true-false
 * questions and 8 multiple choice questions and stores them in result sets.
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class QuestionAnswerHolder {

	private ArrayList<Integer> indexTrueFalse;
	private ArrayList<Integer> indexMultipleChoice;
	private ResultSet trueFalse;
	private ResultSet multipleChoice;
	private Connection connection;

	/**
	 * Default constructor connecting to database and fetching questions.
	 * 
	 * @throws IOException
	 */
	public QuestionAnswerHolder() throws SQLException {

		indexTrueFalse = new ArrayList<Integer>();
		indexMultipleChoice = new ArrayList<Integer>();
		for (int i = 1; i <= 20; i++)
			indexTrueFalse.add(i);
		for (int j = 1; j <= 8; j++)
			indexMultipleChoice.add(j);
		// Load the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver loaded");

		// Establish a connection
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/questionnaire", "root", "12345");
		System.out.println("Database connected");

		PreparedStatement statement = connection.prepareStatement(
				"select * from questionnaire", ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		PreparedStatement statement2 = connection.prepareStatement(
				"select * from multiple_choice",
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		this.trueFalse = statement.executeQuery();
		this.multipleChoice = statement2.executeQuery();
	}

	/**
	 * Gets random question from result set.
	 * 
	 * @param type
	 *            0 for true-false question and 1 for multiple choice question
	 * @return random Question from result set
	 * @throws SQLException
	 */
	public Question getRandomQuestion(int type) throws SQLException {
		int randomIndex = 0;

		// will return multiple choice question
		if (type == 1) {
			randomIndex = (int) (Math.random() * indexMultipleChoice.size());
			multipleChoice.absolute(indexMultipleChoice.get(randomIndex));
			indexMultipleChoice.remove(randomIndex);
			return new Question(multipleChoice.getString(1),
					multipleChoice.getString(2), multipleChoice.getString(3),
					multipleChoice.getString(4), multipleChoice.getString(5),
					multipleChoice.getString(6), multipleChoice.getString(7),
					multipleChoice.getString(8));
		}

		// will return true-false question
		else {
			randomIndex = (int) (Math.random() * indexTrueFalse.size());
			trueFalse.absolute(indexTrueFalse.get(randomIndex));
			indexTrueFalse.remove(randomIndex);
			return new Question(trueFalse.getString(1), trueFalse.getString(2));
		}
	}

	/**
	 * Closes database connection.
	 */
	public void connectionClose() {
		try {
			this.connection.close();
			System.out.println("Database connection closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}
}