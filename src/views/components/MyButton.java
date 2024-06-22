package views.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyButton extends JButton{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Font BUTTON_FONT = new Font("Cursive", Font.BOLD, 20);
    public static final Color COLOR_BACKGROUND_BUTTON = Color.decode("#393939");

    public MyButton(String text){
        setBackground(COLOR_BACKGROUND_BUTTON);
        setForeground(Color.WHITE);
        setOpaque(false);
        setText(text);
        setFont(BUTTON_FONT);
        setFocusable(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
        super.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	setBackground(Color.decode("#6E6E6E"));
        		setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	setBackground(Color.decode("#393939"));
        		setBorderPainted(false);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Dimension arcs = new Dimension(10,10);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
		graphics.setColor(getBackground());
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        super.paint(g);
    }
    
}