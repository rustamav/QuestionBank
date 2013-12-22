import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * ScoreFrame class creates window where the user can see his score in bar
 * charts and percentages.
 * 
 * @author Rustam Alashrafov, Abdykerim Erikov
 * 
 */
public class ScoreFrame extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			ScoreFrame frame = new ScoreFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ScoreFrame() {
		super("Final Scores Bar Chart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
		double score1 = ShareData.userTFScore;
		double score2 = ShareData.userMCScore;
		double[] scores = { score1, score2 };
		String[] labels = {
				"True/False Score: " + score1 + "/60.0 (" + score1 / 60 * 100
						+ "%)",
				"Multiple Choice Score: " + score2 + "/40.0 (" + score2 / 40
						* 100 + "%)" };

		contentPane = new SimpleBarChart(scores, labels,
				ShareData.userFisrtName + " " + ShareData.userLastName
						+ "  statistics: ");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * SimpleBarChart draws barcharts.
	 * 
	 * @author Rustam Alashrafov, Abdykerim Erikov
	 * 
	 */
	public class SimpleBarChart extends JPanel {
		private double[] value;
		private String[] languages;
		private String title;

		public SimpleBarChart(double[] val, String[] lang, String t) {
			languages = lang;
			value = val;
			title = t;
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			if (value == null || value.length == 0)
				return;
			double minValue = 0;
			double maxValue = 0;
			for (int i = 0; i < value.length; i++) {
				if (minValue > value[i])
					minValue = value[i];
				if (maxValue < value[i])
					maxValue = value[i];
			}
			maxValue = 60;
			Dimension dim = getSize();
			int clientWidth = dim.width;
			int clientHeight = dim.height;
			int barWidth = clientWidth / (value.length * 2);
			Font titleFont = new Font("Book Antiqua", Font.BOLD, 30);
			FontMetrics titleFontMetrics = graphics.getFontMetrics(titleFont);
			Font labelFont = new Font("Book Antiqua", Font.PLAIN, 20);
			FontMetrics labelFontMetrics = graphics.getFontMetrics(labelFont);
			int titleWidth = titleFontMetrics.stringWidth(title);
			int q = titleFontMetrics.getAscent();
			int p = (clientWidth - titleWidth) / 2;
			graphics.setFont(titleFont);
			graphics.drawString(title, p, q);
			int top = titleFontMetrics.getHeight();
			int bottom = labelFontMetrics.getHeight();
			if (maxValue == minValue)
				return;
			double scale = (clientHeight - top - bottom)
					/ (maxValue - minValue);
			q = clientHeight - labelFontMetrics.getDescent();
			graphics.setFont(labelFont);

			for (int j = 0; j < value.length; j++) {
				int backHeight = (int) ((60 - j * 20) * scale);
				int backY = (int) (maxValue + j * 20 * scale) - 23;
				int valueP = j * barWidth + 133 * (j + 1);
				int valueQ = top;
				int height = (int) (value[j] * scale);
				if (value[j] >= 0)
					valueQ += (int) ((maxValue - value[j]) * scale);
				else {
					valueQ += (int) (maxValue * scale);
					height = -height;
				}
				graphics.setColor(Color.gray);
				graphics.fillRect(valueP, backY, barWidth - 2, backHeight);

				float[] hsbvals = Color.RGBtoHSB(0, 178, 0, null);
				graphics.setColor(Color.getHSBColor(hsbvals[0], hsbvals[1],
						hsbvals[2]));
				graphics.fillRect(valueP, valueQ, barWidth - 2, height);

				graphics.setColor(Color.black);
				graphics.drawRect(valueP, backY, barWidth - 2, backHeight);
				int labelWidth = labelFontMetrics.stringWidth(languages[j]);
				p = j * barWidth + (barWidth - labelWidth) / 2 + 133 * (j + 1);
				graphics.drawString(languages[j], p, q);
			}
		}
	}
}
