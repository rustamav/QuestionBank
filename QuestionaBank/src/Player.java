import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wanhrust Player serializable class containing contains all
 *         information about the player. Main class to execute the training.
 */
public class Player implements Serializable {

	private int score;
	private String fName;


	private String lName;
	private String fileName;
	private List<String> QL;
	private List<String> AL;
	private List<String> PAL;

	
	Player() {
		score = 0;
		QL = new ArrayList<String>();
		AL = new ArrayList<String>();
		PAL = new ArrayList<String>();
	}
	Player(String fName, String lName, String fileName){
		this.fName = fName;
		this.lName = lName;
		this.fileName = fileName;
	}
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Default constructor initializes the instances
	 * score = 0
	 */


	/**
	 * Return the score of the player
	 * @return
	 * int score of the player
	 */
	int getScore() {
		return this.score;
	}

	/**
	 * Prints player name, surname and its score.
	 */
	void printPlayerInfo() {
		System.out.println(String.format("%-20s %-20s Score: %-2d ",
				this.fName, this.lName, this.score));
	}

	/**
	 * Prints the Details of the game played by a player. 
	 * Questions answered, whether the answer was correct, and its correct answer.
	 */
	void printDetails() {
		printPlayerInfo();
		// try {
		// String tmp;
		// BufferedReader bin = new BufferedReader(new FileReader(
		// this.fileName));
		// while ((tmp = bin.readLine()) != null)
		// System.out.println(tmp);
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// System.out
		// .println("your file with questions could not be opened. Sorry :( ");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		for (int index = 0; index < QL.size(); index++) {
			System.out.println(index + 1 + ". " + QL.get(index) + " "
					+ PAL.get(index) + ". Answer is: " + AL.get(index));
		}

	}

	/**
	 * ask user to input the integer between specified parameters.
	 * recursively calls itself until desired input is obtained
	 * @param minNum
	 * int range min num.
	 * @param maxNum
	 * int range max num.
	 * @return
	 * int the number which user inputed within the specified range
	 */
//	int getValidNumber(int minNum, int maxNum) {
//		try {
//			Scanner in = new Scanner(System.in);
//			String inString = in.next();
//			int num = Integer.parseInt(inString);
//			if ((num < 1) || (num > maxNum))
//				throw new NumberOutOfBoundaryException(minNum, maxNum);
//			return num;
//		} catch (NumberFormatException e) {
//			System.out.println("Please enter number between " + minNum
//					+ " and " + maxNum + " :");
//			return getValidNumber(minNum, maxNum);
//		} catch (NumberOutOfBoundaryException e) {
//			return getValidNumber(minNum, maxNum);
//		}
//
//	}

	/**
	 * The main Play function which does all important operations to play training.
	 * Asks the name, surname the file to store the results.
	 * Contains loop to ask the user for the appropriate number of questions.
	 * 
	 * @param h
	 * QuestionAnswerHolder parameter to get access to the questions
	 */
//	public void Play(QuestionAnswerHolder h) {
//		Scanner in = new Scanner(System.in);
//		boolean wrongInput = true;
//		System.out.println("Enter your First Name: ");
//		fName = in.nextLine();
//		System.out.println("Enter you Last Name: ");
//		lName = in.nextLine();
//		System.out.println("Enter name of the file to store your answers:");
//		fileName = in.nextLine();
//		System.out.println("How many questions you want to answer?  (Maximum: "
//				+ h.getNumberOfQuestion() + ")");
//		int nQuestions = getValidNumber(1, h.getNumberOfQuestion());
//		System.out.println("<<< Game is starting >>>");
//		System.out.println(" ");
//		for (int i = 0; i < nQuestions; i++) {
//			String s = h.getRandomQuestion();
//			String[] parts = s.split("#", 2);
//			String q = parts[0];
//			String a = parts[1];
//
//			wrongInput = true;
//			while (wrongInput) {
//				System.out.println(q);
//				System.out.println("1. True");
//				System.out.println("2. False");
//				System.out.println("3. Skip question");
//				String choice = in.next().toLowerCase();
//				switch (choice) {
//				case "1":
//					if (a.equalsIgnoreCase("true")) {
//						System.out.println("Correct!");
//						QL.add(q);
//						AL.add(a);
//						PAL.add("Correct");
//						score++;
//						wrongInput = false;
//					} else {
//						System.out.println("Wrong!");
//						QL.add(q);
//						AL.add(a);
//						PAL.add("Wrong");
//						wrongInput = false;
//					}
//					break;
//				case "2":
//					if (a.equalsIgnoreCase("false")) {
//						System.out.println("Correct!");
//						QL.add(q);
//						AL.add(a);
//						PAL.add("Correct");
//						wrongInput = false;
//						score++;
//					} else {
//						System.out.println("Wrong!");
//						QL.add(q);
//						AL.add(a);
//						PAL.add("Wrong");
//						wrongInput = false;
//					}
//					break;
//				case "3":
//					QL.add(q);
//					AL.add(a);
//					PAL.add("Skipped");
//					wrongInput = false;
//					break;
//				default:
//					System.out.println("No such command, try again");
//					System.out.println("*****");
//
//				} // case end
//
//			} // while end
//		}
//		System.out.println(" === Game has finished! === ");
//		System.out.println("Congratulations! Your score is: " + score);
//
//		try {
//			File f = new File(fileName);
//			f.createNewFile();
//			PrintWriter outQuestions = new PrintWriter(new FileWriter(fileName));
//			for (int i = 0; i < QL.size(); i++) {
//				outQuestions.println(i + 1 + ". " + QL.get(i) + " "
//						+ PAL.get(i) + ". Answer is : " + AL.get(i));
//			}
//			outQuestions.flush();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		wrongInput = true;
//		while (wrongInput) {
//			System.out.println("\nDo you wish to see details? (Y/N)");
//			String choice = in.next().toLowerCase();
//			switch (choice) {
//			case "y":
//				printDetails();
//				wrongInput = false;
//				break;
//			case "n":
//				wrongInput = false;
//				break;
//			default:
//				System.out.println("No such option. Please try again...");
//
//			}
//
//		}
//		System.out.println("\n=== Thank you for playing! Good bye! ===");
//	} // end of PLay()
} // end of class
