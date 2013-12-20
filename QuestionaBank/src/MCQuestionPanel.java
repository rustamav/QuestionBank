import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;


public class MCQuestionPanel extends JPanel implements ActionListener{
	
	private Question q;
	private int counter;
	/**
	 * Create the panel.
	 */
	public MCQuestionPanel(QuestionAnswerHolder h) {
		
		try {
			q = h.getRandomQuestion(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JRadioButton rb3 = new JRadioButton(q.getA());
		
		JRadioButton rb1 = new JRadioButton(q.getB());
		
		JRadioButton rb4 = new JRadioButton(q.getC());
		
		JRadioButton rb2 = new JRadioButton(q.getD());
		
		JRadioButton rb5 = new JRadioButton(q.getE());
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rb3);
		bGroup.add(rb1);
		bGroup.add(rb4);
		bGroup.add(rb2);
		bGroup.add(rb5);
		JLabel lblQuestion = new JLabel(q.getQuestion());
		
		JButton btnNewButton = new JButton("Show Answer");
		btnNewButton.addActionListener(this);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Explanation");
		
		JLabel lblNewLabel = new JLabel(q.getCorrectAnswer());
		lblNewLabel.setVisible(false);
		
		JTextArea textArea = new JTextArea(q.getExplanation());
		textArea.setEditable(false);
		textArea.setToolTipText("");
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuestion)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rb1)
							.addGap(38)
							.addComponent(btnNewButton)
							.addGap(32)
							.addComponent(btnNextQuestion))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rb2)
								.addComponent(rb3)
								.addComponent(rb4)
								.addComponent(rb5))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(chckbxNewCheckBox)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblQuestion)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rb1)
						.addComponent(btnNewButton)
						.addComponent(btnNextQuestion))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rb2)
							.addGap(3)
							.addComponent(rb3)
							.addGap(3)
							.addComponent(rb4)
							.addGap(3)
							.addComponent(rb5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(lblNewLabel)
							.addGap(2)
							.addComponent(chckbxNewCheckBox)
							.addGap(2)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))
		);
		setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Multiple choice questions");
		String bName = e.getActionCommand();
		switch(bName){
		case "Show Answer":
			System.out.println("ok");
			break;
		}
		
	}
}
