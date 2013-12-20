import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class deals with the question and answer files. It creates an arraylists
 * to hold questions and answers in appropriate positions, so the for each
 * question the answer could be found
 * 
 * @author wanhrust
 * 
 */
public class QuestionAnswerHolder {
	
	private ArrayList<Integer> indexTrueFalse;
	private ArrayList<Integer> indexMultipleChoice;
	private ResultSet trueFalse;
	private ResultSet multipleChoice;
	/**
	 * Default constructor. Tries to read from a question.txt and answer.txt
	 * files.
	 * 
	 * @throws IOException
	 *             Throws this exception in case there is some problem with
	 *             reading files. Terminates the program.
	 */
	public QuestionAnswerHolder() throws SQLException{
		
		indexTrueFalse = new ArrayList<Integer>();
		indexMultipleChoice = new ArrayList<Integer>();
		for(int i=1;i<=20;i++)
			indexTrueFalse.add(i);
		for(int j=1;j<=8;j++)
			indexMultipleChoice.add(j);
		// Load the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver loaded");
		
		// Establish a connection
		Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/questionnaire", "root", "12345");
		System.out.println("Database connected");
		
		PreparedStatement statement = connection.prepareStatement("select * from questionnaire", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		PreparedStatement statement2 = connection.prepareStatement("select * from multiple_choice", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		this.trueFalse = statement.executeQuery();
		this.multipleChoice = statement2.executeQuery();
		//connection.close();
	}

	/**
	 * Function returns the random question from a questions set and its answer
	 * as a concatenated string. # is used to concatenate questoin with
	 * appropriate answer.
	 * 
	 * @return
	 * String - concatenated question with answer. (e.g. Is ant stronger than elephant?#True)
	 */
	public Question getRandomQuestion(int type) throws SQLException{
		int randomIndex=0;

		//will return multiple choice question
		if(type==1){
			randomIndex = (int) (Math.random()*indexMultipleChoice.size());
			multipleChoice.absolute(indexMultipleChoice.get(randomIndex));
			indexMultipleChoice.remove(randomIndex);
			return new Question(multipleChoice.getString(1), multipleChoice.getString(2), multipleChoice.getString(3), multipleChoice.getString(4), multipleChoice.getString(5), multipleChoice.getString(6), multipleChoice.getString(7), multipleChoice.getString(8));
		}
		
		//will return true-false question
		else {
			randomIndex = (int) (Math.random()*indexTrueFalse.size());
			trueFalse.absolute(indexTrueFalse.get(randomIndex));
			indexTrueFalse.remove(randomIndex);
			return new Question(trueFalse.getString(1), trueFalse.getString(2));
		}
	}
}