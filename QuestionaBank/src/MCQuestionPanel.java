import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Create the panel.
	 */
	public MCQuestionPanel() {
		
		JRadioButton rb3 = new JRadioButton("New radio button");
		
		JRadioButton rb1 = new JRadioButton("New radio button");
		
		JRadioButton rb4 = new JRadioButton("New radio button");
		
		JRadioButton rb2 = new JRadioButton("New radio button");
		
		JRadioButton rb5 = new JRadioButton("New radio button");
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rb3);
		bGroup.add(rb1);
		bGroup.add(rb4);
		bGroup.add(rb2);
		bGroup.add(rb5);
		JLabel lblQuestion = new JLabel("Question");
		
		JButton btnNewButton = new JButton("Show Answer");
		btnNewButton.addActionListener(this);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Explanation");
		
		JLabel lblNewLabel = new JLabel("Answer");
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setToolTipText("");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(rb4)
							.addComponent(rb5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rb2)
								.addComponent(rb3)
								.addComponent(rb1)))
						.addComponent(lblQuestion))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textArea)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel)
						.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblQuestion)
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rb1)
						.addComponent(btnNewButton))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rb2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rb3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rb4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rb5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNewCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addGap(27))
		);
		setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String bName = e.getActionCommand();
		switch(bName){
		case "Show Answer":
			System.out.println("ok");
			break;
		}
		
	}
}
