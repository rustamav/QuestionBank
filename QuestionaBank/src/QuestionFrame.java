import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class QuestionFrame extends JFrame implements ActionListener {

	private JPanel pTFQuestion;
//	private JPanel pMCQuestion;
	private JLabel lblQuestion;
	private JButton bTrue;
	private JButton bFalse;
	private JButton bSkip;
	private int score = 0;
	private int counter = 0;
	private QuestionAnswerHolder h;

//	private ButtonGroup bGroup;
//	private JRadioButtonMenuItem rb1;
//	private JRadioButtonMenuItem rb2;
//	private JRadioButtonMenuItem rb3;
//	private JRadioButtonMenuItem rb4;
//	private JRadioButtonMenuItem rb5;

//	private JLabel lMCQuestion;
//	private JButton bViewAnswer;
//	private JCheckBox cbShowExplanation;
	
	private Question q;
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			QuestionFrame frame = new QuestionFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * 
	 * @throws IOException
	 */
	/**
	 * 
	 */
	public QuestionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		pTFQuestion = new JPanel();
		pTFQuestion.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pTFQuestion);
		
		try {
			h = new QuestionAnswerHolder();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			q = h.getRandomQuestion(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lblQuestion = new JLabel(q.getQuestion());

		bTrue = new JButton("True");
		bTrue.addActionListener(this);

		bFalse = new JButton("False");
		bFalse.addActionListener(this);

		bSkip = new JButton("Skip");
		bSkip.addActionListener(this);
		GroupLayout gl_pTFQuestion = new GroupLayout(pTFQuestion);
		gl_pTFQuestion
				.setHorizontalGroup(gl_pTFQuestion
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE,
								790, GroupLayout.PREFERRED_SIZE)
						.addGroup(
								gl_pTFQuestion
										.createSequentialGroup()
										.addGap(212)
										.addGroup(
												gl_pTFQuestion
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																bSkip,
																GroupLayout.PREFERRED_SIZE,
																339,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bFalse,
																GroupLayout.PREFERRED_SIZE,
																339,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																bTrue,
																GroupLayout.PREFERRED_SIZE,
																339,
																GroupLayout.PREFERRED_SIZE))
										.addGap(239)));
		gl_pTFQuestion.setVerticalGroup(gl_pTFQuestion.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_pTFQuestion
						.createSequentialGroup()
						.addGap(1)
						.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE,
								147, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(bTrue, GroupLayout.PREFERRED_SIZE, 62,
								GroupLayout.PREFERRED_SIZE)
						.addGap(51)
						.addComponent(bFalse, GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addGap(45)
						.addComponent(bSkip, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE).addGap(149)));
		pTFQuestion.setLayout(gl_pTFQuestion);

		

//
//		Player p = new Player(ShareData.userFisrtName, ShareData.userLastName,
//				ShareData.userFileName);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String buttonName = e.getActionCommand();
		if (buttonName.equalsIgnoreCase(q.getCorrectAnswer()) && q.getType()==0)
			score += 3;
//		else if (buttonName.equalsIgnoreCase(q.getCorrectAnswer()) && q.getType()==1)
//			score += 5;
		
		try {
			q = h.getRandomQuestion(0);
			lblQuestion.setText(q.getQuestion());
			counter++;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if (counter == 2) {
			ShareData.userScore = score;
				setContentPane(new MCQuestionPanel(h));
				pTFQuestion.setVisible(false);
		}

//		if (counter == 27) {
//			System.out.println("User score is " + score/*ShareData.userScore*/);
//			this.setVisible(false);
//			this.dispose();
//		}

	} // end of actionPerformed()
}
