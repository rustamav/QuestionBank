import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 * MCFrame creates window to ask multiple choice questions. When answered, it
 * checks the correct answer and provides feedback. Each correct answer is worth
 * 5 points.
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class MCFrame extends JFrame implements ActionListener {

	private Question q;
	private int counter;
	private QuestionAnswerHolder h;
	private String userAnswer;
	private int score;

	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private ButtonGroup bGroup;
	private JLabel lblQuestion;
	private JButton btnNewButton;
	private JCheckBox cbExpl;
	private JLabel lblCorrectAnswer;
	private JTextArea textArea;
	private JButton btnNextQuestion;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			MCFrame frame = new MCFrame(h);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MCFrame(QuestionAnswerHolder h) {
		super("Multiple Choice Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		counter = 1;
		score = 0;
		this.h = h;
		try {
			q = h.getRandomQuestion(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rb1 = new JRadioButton(q.getA());
		rb2 = new JRadioButton(q.getB());
		rb3 = new JRadioButton(q.getC());
		rb4 = new JRadioButton(q.getD());
		rb5 = new JRadioButton(q.getE());

		rb1.setActionCommand("rb1");
		rb2.setActionCommand("rb2");
		rb3.setActionCommand("rb3");
		rb4.setActionCommand("rb4");
		rb5.setActionCommand("rb5");

		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);
		rb5.addActionListener(this);

		rb1.setSelected(true);
		userAnswer = rb1.getText();

		bGroup = new ButtonGroup();
		bGroup.add(rb1);
		bGroup.add(rb2);
		bGroup.add(rb3);
		bGroup.add(rb4);
		bGroup.add(rb5);
		lblQuestion = new JLabel(counter + ". " + q.getQuestion());

		btnNewButton = new JButton("Show Answer");
		btnNewButton.addActionListener(this);

		cbExpl = new JCheckBox("Show Explanation");
		cbExpl.setActionCommand("ExplBox");
		cbExpl.addActionListener(this);
		cbExpl.setEnabled(false);

		lblCorrectAnswer = new JLabel(q.getCorrectAnswer());
		lblCorrectAnswer.setVisible(false);

		textArea = new JTextArea(q.getExplanation());
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setToolTipText("");

		btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(55)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblQuestion)
														.addComponent(rb1)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								rb2)
																						.addComponent(
																								rb3)
																						.addComponent(
																								rb4)
																						.addComponent(
																								rb5))
																		.addGap(38)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblCorrectAnswer)
																						.addComponent(
																								textArea,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																btnNewButton)
																														.addComponent(
																																cbExpl))
																										.addGap(18)
																										.addComponent(
																												btnNextQuestion)))))
										.addGap(46)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(18)
										.addComponent(lblQuestion)
										.addGap(39)
										.addComponent(rb1)
										.addGap(2)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				rb2)
																		.addGap(3)
																		.addComponent(
																				rb3)
																		.addGap(3)
																		.addComponent(
																				rb4)
																		.addGap(3)
																		.addComponent(
																				rb5))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(17)
																		.addComponent(
																				lblCorrectAnswer)
																		.addGap(2)
																		.addComponent(
																				cbExpl)
																		.addGap(2)
																		.addComponent(
																				textArea,
																				GroupLayout.PREFERRED_SIZE,
																				71,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.RELATED, 32,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnNewButton)
														.addComponent(
																btnNextQuestion))
										.addContainerGap()));
		contentPane.setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String bName = e.getActionCommand();
		if (cbExpl.isSelected())
			textArea.setVisible(true);
		else
			textArea.setVisible(false);
		switch (bName) {
		case "rb1":
			userAnswer = rb1.getText();
			break;
		case "rb2":
			userAnswer = rb2.getText();
			break;
		case "rb3":
			userAnswer = rb3.getText();
			break;
		case "rb4":
			userAnswer = rb4.getText();
			break;
		case "rb5":
			userAnswer = rb5.getText();
			break;
		case "Show Answer":
			rb1.setEnabled(false);
			rb2.setEnabled(false);
			rb3.setEnabled(false);
			rb4.setEnabled(false);
			rb5.setEnabled(false);
			lblCorrectAnswer.setVisible(true);
			cbExpl.setEnabled(true);
			break;
		case "Next Question":
			if (counter == 8) {
				ShareData.userMCScore += score;
				h.connectionClose();
				ScoreFrame sFrame = new ScoreFrame();
				sFrame.setVisible(true);
				this.dispose();
			} else {
				counter++;
				if (userAnswer.equalsIgnoreCase(q.getCorrectAnswer()))
					score += 5;
				try {
					q = h.getRandomQuestion(1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				lblQuestion.setText(counter + ". " + q.getQuestion());
				lblCorrectAnswer.setText(q.getCorrectAnswer());
				lblCorrectAnswer.setVisible(false);
				textArea.setVisible(false);
				cbExpl.setEnabled(false);
				cbExpl.setSelected(false);
				rb1.setText(q.getA());
				rb2.setText(q.getB());
				rb3.setText(q.getC());
				rb4.setText(q.getD());
				rb5.setText(q.getE());
				textArea.setText(q.getExplanation());
				userAnswer = rb1.getText();
				rb1.setEnabled(true);
				rb2.setEnabled(true);
				rb3.setEnabled(true);
				rb4.setEnabled(true);
				rb5.setEnabled(true);
				rb1.setSelected(true);
			}
			break;
		}

	}

}
