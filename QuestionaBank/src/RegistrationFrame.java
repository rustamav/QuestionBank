import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class RegistrationFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel lblName;
	JTextField tfUserName;
	JLabel lblUserLastName;
	JTextField tfUserLastName;

	JButton bStart;

	JDialog dInvalidInput;

	public void run() {
		try {
			RegistrationFrame frame = new RegistrationFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	 public RegistrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblName = new JLabel("Enter your Name");

		tfUserName = new JTextField();
		tfUserName.setActionCommand("tfUserName");
		tfUserName.addActionListener(this);
		tfUserName.setPreferredSize(new Dimension(Global.SCREEN_WIDTH / 10,
				Global.SCREEN_HEIGHT / 10));
		tfUserName.setColumns(10);

		lblUserLastName = new JLabel("Enter Your Last Name");

		tfUserLastName = new JTextField();
		tfUserLastName.addActionListener(this);

		bStart = new JButton("Start");
		bStart.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
		.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
						.createSequentialGroup()
						.addGap(27)
						.addGroup(
								gl_contentPane
								.createParallelGroup(
										Alignment.LEADING)
										.addComponent(
												bStart,
												GroupLayout.PREFERRED_SIZE,
												543,
												GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_contentPane
														.createSequentialGroup()
														.addComponent(
																lblUserLastName)
																.addGap(21)
																.addComponent(
																		tfUserLastName,
																		GroupLayout.PREFERRED_SIZE,
																		295,
																		GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				gl_contentPane
																				.createSequentialGroup()
																				.addComponent(
																						lblName,
																						GroupLayout.PREFERRED_SIZE,
																						137,
																						GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																								.addComponent(
																										tfUserName,
																										GroupLayout.PREFERRED_SIZE,
																										285,
																										GroupLayout.PREFERRED_SIZE)))
																										.addContainerGap(220, Short.MAX_VALUE)));
		gl_contentPane
		.setVerticalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
						.createSequentialGroup()
						.addGap(111)
						.addGroup(
								gl_contentPane
								.createParallelGroup(
										Alignment.BASELINE)
										.addComponent(
												tfUserName,
												GroupLayout.PREFERRED_SIZE,
												18,
												GroupLayout.PREFERRED_SIZE)
												.addComponent(lblName))
												.addGap(46)
												.addGroup(
														gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
																.addComponent(
																		lblUserLastName)
																		.addComponent(
																				tfUserLastName,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
																				.addGap(43)
																				.addComponent(bStart,
																						GroupLayout.PREFERRED_SIZE, 40,
																						GroupLayout.PREFERRED_SIZE)
																						.addGap(313)));
		contentPane.setLayout(gl_contentPane);
	 }

	 @Override
	 public void actionPerformed(ActionEvent e) {
		 // TODO Auto-generated method stub
		 String action = e.getActionCommand();
		 System.out.println("typing....");
		 int numberOfQuestions = -1;
		 // while(numberOfQuestions==-1 || numberOfQuestions>20){
		 // try{
		 // numberOfQuestions = Integer.parseInt(tfQuestionNo.getText());
		 // }catch(NumberFormatException f){
		 // numberOfQuestions = -1;
		 // }
		 // }
		 switch (action) {
		 case "Start":
			 boolean validInput = true;
			 // ShareData.questionNO = Integer.parseInt(tfQuestionNo.getText());
			 ShareData.userFisrtName = tfUserName.getText();
			 ShareData.userLastName = tfUserLastName.getText();
			 // ShareData.userFileName = tfUserFileName.getText();
			 if (ShareData.userFisrtName.equals("")
					 || ShareData.userLastName.equals("")) {
				 validInput = false;
				 dInvalidInput = new JDialog(this, "Error!");
				 dInvalidInput.setSize(new Dimension(200, 100));
				 dInvalidInput.setLocation(new Point(Global.SCREEN_WIDTH / 2,
						 Global.SCREEN_HEIGHT / 2));
				 JLabel lError = new JLabel("Please fill all the fields");
				 dInvalidInput.getContentPane().add(lError);
				 dInvalidInput.setVisible(true);
				 dInvalidInput.setFocusable(true);
			 }

			 if (validInput == true) {
				 QuestionFrame qFrame = new QuestionFrame();
				 this.setVisible(false);
				 qFrame.setVisible(true);
				 this.dispose();
				 System.out.println("start");
			 }

			 break;
		 case "High Scores":
			 System.out.println("Pressed High");
			 break;
		 case "Exit":
			 System.exit(0);
			 break;
		 case "miExit":
			 System.exit(0);
		 default:

		 }

	 }
}