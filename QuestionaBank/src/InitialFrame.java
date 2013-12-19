import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InitialFrame extends JFrame implements ActionListener {
	private JPanel contentPane;
	
	JMenuBar menuBar;
	JMenu mFile;
	JMenuItem miNew;
	JMenuItem miExit;

	JButton bStartGame;
	JButton bHighScores;
	JButton bExit;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialFrame frame = new InitialFrame();
					// frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InitialFrame() {
		super("Question Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		contentPane = new JPanel();

		menuBar = new JMenuBar();
		mFile = new JMenu("File");
		miNew = new JMenuItem("New");
		miExit = new JMenuItem("Exit");
		miExit.setActionCommand("miExit");
		miExit.addActionListener(this);

		menuBar.add(mFile);
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miExit);

		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		bStartGame = new JButton("Start Game");
		bStartGame.setSize(Global.SCREEN_WIDTH / 10, Global.SCREEN_HEIGHT / 10);
		bStartGame.addActionListener(this);

		 bHighScores = new JButton("High Scores");
		bHighScores.addActionListener(this);

		bExit = new JButton("Exit");
		bExit.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(189)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(bExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
						.addComponent(bHighScores, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bStartGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
					.addGap(184))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(bStartGame, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(bHighScores, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(bExit, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(214, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);


		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName = e.getActionCommand();

		switch (buttonName) {
		case "Start Game":
			RegistrationFrame regFrame = new RegistrationFrame();
			regFrame.setVisible(true);
			this.setVisible(false);
			this.dispose();
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
