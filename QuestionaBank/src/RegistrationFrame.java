import java.awt.Dimension;
import java.awt.GridLayout;
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

/**
 * RegistrationFrame class creates window to ask user for name and last name.
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class RegistrationFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfUserName;
	private JLabel lblUserLastName;
	private JTextField tfUserLastName;
	private JButton bStart;
	private JDialog dInvalidInput;

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
		super("Registration");
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
		String action = e.getActionCommand();
		switch (action) {
		case "Start":
			boolean validInput = true;
			ShareData.userFisrtName = tfUserName.getText();
			ShareData.userLastName = tfUserLastName.getText();
			if (ShareData.userFisrtName.equals("")
					|| ShareData.userLastName.equals("")) {
				validInput = false;
				dInvalidInput = new JDialog(this, "Error!");
				dInvalidInput.setSize(new Dimension(200, 100));
				dInvalidInput.setLocation(new Point(Global.SCREEN_WIDTH / 2,
						Global.SCREEN_HEIGHT / 2));
				JLabel lError = new JLabel("Please fill all the fields");
				JButton ok = new JButton("OK");
				ok.addActionListener(this);
				dInvalidInput.getContentPane().setLayout(new GridLayout(2, 1));
				dInvalidInput.getContentPane().add(lError);
				dInvalidInput.getContentPane().add(ok);
				dInvalidInput.setVisible(true);
				dInvalidInput.setFocusable(true);
				dInvalidInput.setResizable(false);
			}

			if (validInput == true) {
				TFQuestionFrame qFrame = new TFQuestionFrame();
				this.setVisible(false);
				qFrame.setVisible(true);
				this.dispose();
			}
			break;
		case "OK":
			dInvalidInput.dispose();
			break;
		default:
		}
	}
}