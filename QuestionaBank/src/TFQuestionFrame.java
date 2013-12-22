import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * TFQuestionFrame creates window to ask multiple choice questions. When
 * answered, it checks the correct answer and provides feedback. Each correct
 * answer is worth 3 points.
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class TFQuestionFrame extends JFrame implements ActionListener {

	private JPanel pTFQuestion;
	private JLabel lblQuestion;
	private JButton bTrue;
	private JButton bFalse;
	private JButton bNext;
	private int score;
	private int counter;
	private QuestionAnswerHolder h;
	private Question q;
	private TFQuestionFrame frame;
	private JLabel lFeedback;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			frame = new TFQuestionFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TFQuestionFrame() {
		super("True/False Questions");
		score = 0;
		counter = 1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		pTFQuestion = new JPanel();
		pTFQuestion.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pTFQuestion);

		try {
			h = new QuestionAnswerHolder();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			q = h.getRandomQuestion(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		lblQuestion = new JLabel(counter + " " + q.getQuestion());

		bTrue = new JButton("True");
		bTrue.addActionListener(this);

		bFalse = new JButton("False");
		bFalse.addActionListener(this);

		bNext = new JButton("Next");
		bNext.addActionListener(this);

		lFeedback = new JLabel();
		lFeedback.setVisible(false);
		lFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_pTFQuestion = new GroupLayout(pTFQuestion);
		gl_pTFQuestion
				.setHorizontalGroup(gl_pTFQuestion
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pTFQuestion
										.createSequentialGroup()
										.addGroup(
												gl_pTFQuestion
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblQuestion,
																GroupLayout.PREFERRED_SIZE,
																790,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_pTFQuestion
																		.createSequentialGroup()
																		.addGap(212)
																		.addComponent(
																				bTrue,
																				GroupLayout.PREFERRED_SIZE,
																				339,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_pTFQuestion
																		.createSequentialGroup()
																		.addGap(212)
																		.addComponent(
																				bFalse,
																				GroupLayout.PREFERRED_SIZE,
																				339,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_pTFQuestion
																		.createSequentialGroup()
																		.addGap(212)
																		.addGroup(
																				gl_pTFQuestion
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(
																								lFeedback,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								bNext,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								339,
																								Short.MAX_VALUE))))
										.addContainerGap(184, Short.MAX_VALUE)));
		gl_pTFQuestion.setVerticalGroup(gl_pTFQuestion.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_pTFQuestion
						.createSequentialGroup()
						.addGap(1)
						.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE,
								147, GroupLayout.PREFERRED_SIZE)
						.addGap(6)
						.addComponent(bTrue, GroupLayout.PREFERRED_SIZE, 62,
								GroupLayout.PREFERRED_SIZE)
						.addGap(51)
						.addComponent(bFalse, GroupLayout.PREFERRED_SIZE, 63,
								GroupLayout.PREFERRED_SIZE)
						.addGap(45)
						.addComponent(bNext, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE)
						.addGap(43)
						.addComponent(lFeedback, GroupLayout.PREFERRED_SIZE,
								34, GroupLayout.PREFERRED_SIZE).addGap(33)));
		pTFQuestion.setLayout(gl_pTFQuestion);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonName = e.getActionCommand();
		switch (buttonName) {
		case "True":
		case "False":
			bTrue.setEnabled(false);
			bFalse.setEnabled(false);
			if (buttonName.equalsIgnoreCase(q.getCorrectAnswer())
					&& q.getType() == 0) {
				score += 3;
				lFeedback.setText("Correct!");
				lFeedback.setVisible(true);
			} else {
				lFeedback.setText("Wrong! Correct answer is "
						+ q.getCorrectAnswer());
				lFeedback.setVisible(true);

			}
			break;

		case "Next":
			if (counter == 20) {
				ShareData.userTFScore = score;
				this.dispose();
				MCFrame mcFrame = new MCFrame(h);
				mcFrame.setVisible(true);
			} else {
				try {
					q = h.getRandomQuestion(0);

					counter++;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				lFeedback.setVisible(false);
				lblQuestion.setText(counter + " " + q.getQuestion());
				bTrue.setEnabled(true);
				bFalse.setEnabled(true);
			}
			break;
		}
	} // end of actionPerformed()
}