import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class RegistrationFrame extends JFrame implements ActionListener{

	
	private JPanel contentPane;
	JLabel lblName;
	JTextField tfUserName;
	JLabel lblUserLastName;
	JTextField tfUserLastName;
	JLabel lblUserFileName;
	JTextField tfUserFileName;
	JLabel lblQuestionNo;
	JTextField tfQuestionNo;
	
	JButton bStart;
	
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
		contentPane.setLayout(new GridLayout(9, 1));
	
		setContentPane(contentPane);
		
		
		lblName = new JLabel("Enter your Name");
		contentPane.add(lblName);
		
		tfUserName = new JTextField();
		tfUserName.setActionCommand("tfUserName");
		tfUserName.addActionListener(this);
		tfUserName.setPreferredSize(new Dimension(Global.SCREEN_WIDTH/10, Global.SCREEN_HEIGHT/10));
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);
		

		
		lblUserLastName = new JLabel("Enter Your Last Name");
		contentPane.add(lblUserLastName);
		
		tfUserLastName = new JTextField();
		tfUserLastName.addActionListener(this);
		contentPane.add(tfUserLastName);
//		tfUserLastName.setActionCommand("tfUserLastName");
		
		
		lblUserFileName = new JLabel("Enter Filename to store your data");
		contentPane.add(lblUserFileName);
		
		tfUserFileName = new JTextField();
		tfUserFileName.addActionListener(this);
		contentPane.add(tfUserFileName);
		
		lblQuestionNo = new JLabel("How many question do you want to answer?");
		contentPane.add(lblQuestionNo);
		
		tfQuestionNo = new JTextField();
		tfQuestionNo.addActionListener(this);
		contentPane.add(tfQuestionNo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		System.out.println("typing....");

		switch (action) {
		case "Start":

			this.setVisible(false);
			System.out.println("start");
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
