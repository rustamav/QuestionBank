import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class QuestionFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblQuestion;
	private JButton bTrue;
	private JButton bFalse;
	private JButton bSkip;
	private int counter = 0;
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
	 * @throws IOException 
	 */
	public QuestionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(4, 1));
		setContentPane(contentPane);
		
		try {
			lblQuestion = new JLabel(new QuestionAnswerHolder().getRandomQuestion());
			contentPane.add(lblQuestion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bTrue = new JButton("True");
		bTrue.addActionListener(this);
		contentPane.add(bTrue);
		
		bFalse = new JButton("False");
		bFalse.addActionListener(this);
		contentPane.add(bFalse);
		
		bSkip = new JButton("Skip");
		bSkip.addActionListener(this);
		contentPane.add(bSkip);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (counter<ShareData.questionNO){
			try {
				lblQuestion.setText(new QuestionAnswerHolder().getRandomQuestion());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			counter++;
		}
	}

}
