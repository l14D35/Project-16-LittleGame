package justAnGame;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
//import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FrameWinner extends JComponent
{
	//private JPanel bgColor;
	private static final int DEFAULT_WIDTH = 480;
	private static final int DEFAULT_HEIGHT = 200;
	private String message = "";

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return this.message;
	}
	
	/*public FrameWinner()
	{
		
	}*/
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Font f = new Font("Serif", Font.BOLD + Font.ITALIC, 36);
		g2.setFont(f);
		g2.setPaint(Color.RED);
		// g2.drawString(message, 10, 100);

		// sprawdzenie rozmiaru tekstu

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);

		// set (x,y) = lewy gorny rog tekstu

		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;

		// Dodanie wydluzenia gornego do y w celu siegniecia do linii bazowej

		double ascent = -bounds.getY();
		double baseY = y + ascent;

		// Rysowanie komunikatu

		g2.drawString(getMessage(), (int) x, (int) baseY);
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}

/*
 * @SuppressWarnings("serial") class FontFrame extends JFrame { public
 * FontFrame() { add(new FrameWinner()); pack(); } }
 */
