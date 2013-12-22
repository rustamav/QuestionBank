import java.awt.EventQueue;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Initial Frame creates initial window to start or exit the program
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class InitialFrame extends JFrame implements ActionListener {
	private JPanel contentPane;

	JMenuBar menuBar;
	JMenu mFile;
	JMenuItem miNew;
	JMenuItem miExit;

	JButton bStartGame;
	JButton bExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// fancy look
		// try {
		// UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());
		// } catch (ClassNotFoundException | InstantiationException
		// | IllegalAccessException | UnsupportedLookAndFeelException e1) {
		// e1.printStackTrace();
		// }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitialFrame frame = new InitialFrame();
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
		setContentPane(contentPane);

		bStartGame = new JButton("Start Game");
		bStartGame.setSize(Global.SCREEN_WIDTH / 10, Global.SCREEN_HEIGHT / 10);
		bStartGame.addActionListener(this);

		bExit = new JButton("Exit");
		bExit.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(189)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																bExit,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																427,
																Short.MAX_VALUE)
														.addComponent(
																bStartGame,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																427,
																Short.MAX_VALUE))
										.addGap(184)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(81)
						.addComponent(bStartGame, GroupLayout.PREFERRED_SIZE,
								61, GroupLayout.PREFERRED_SIZE)
						.addGap(56)
						.addComponent(bExit, GroupLayout.PREFERRED_SIZE, 68,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(313, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();

		switch (buttonName) {
		case "Start Game":
			RegistrationFrame regFrame = new RegistrationFrame();
			this.setVisible(false);
			regFrame.setVisible(true);

			this.dispose();
			System.out.println("start");
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