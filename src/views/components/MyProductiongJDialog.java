package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.Commands;
import models.Production;
import views.panels.MyParametresPanel;
import views.panels.MyProductionsPanel;

public class MyProductiongJDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int QUANTITY_PRODUCTIONS = 3;

    private static final String ACCEPT_TEXT = "Aceptar";
    private static final String REMOVE = "quitar";
    private static final String TEXT_PRODUCTIONS = "Ingrese las producciones";
    private static final String ADD_SYMBOL = "a�adir";
    private static final String TITLE = "Producciones";
    private static final Dimension SIZE = new Dimension(450,370);
    private static final String LOGO_PATH = "src/img/producciones.png";

    private JPanel panelDialog;
    private JPanel productions;
    private boolean isEnable;

    public MyProductiongJDialog(ActionListener listener){
        isEnable = true;
        setTitle(TITLE);
        setSize(SIZE);
        setIconImage(new ImageIcon(LOGO_PATH).getImage());
        setModal(true);
        setBackground(Color.decode("#393939"));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        panelDialog = new JPanel(new BorderLayout());
        panelDialog.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panelDialog.setBackground(Color.decode("#393939"));
        addButton(listener);
        addProductionsPanel();
        addButtonAcept(listener);
        getContentPane().add(panelDialog);
    }

    private void addButton(ActionListener listener){
        JPanel panelHeader =  new JPanel(new FlowLayout());
        panelHeader.setOpaque(false);
        JLabel label = new JLabel(TEXT_PRODUCTIONS);
        label.setForeground(Color.white);
        label.setFont(MyParametresPanel.DESCRIPTION_FONT);
        panelHeader.add(label);
        JButton removeButton = new JButton(REMOVE);
        removeButton.addActionListener(listener);
        removeButton.setBackground(Color.decode("#393939"));
        removeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeButton.setForeground(Color.white);
        removeButton.setBorderPainted(false);
        removeButton.setActionCommand(Commands.DELETE_PRODUCTION.toString());
        removeButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	removeButton.setBackground(Color.decode("#6E6E6E"));
        		removeButton.setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	removeButton.setBackground(Color.decode("#393939"));
        		removeButton.setBorderPainted(false);
            }
        });
        panelHeader.add(removeButton);
        JButton addButton = new JButton(ADD_SYMBOL);
        addButton.addActionListener(listener);
        addButton.setBackground(Color.decode("#393939"));
        addButton.setForeground(Color.white);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setBorderPainted(false);
        addButton.setActionCommand(Commands.ADD_PRODUCTION.toString());
        addButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	addButton.setBackground(Color.decode("#6E6E6E"));
        		addButton.setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	addButton.setBackground(Color.decode("#393939"));
        		addButton.setBorderPainted(false);
            }
        });
        panelHeader.add(addButton);
        panelDialog.add(panelHeader, BorderLayout.PAGE_START);
    }

    private void addProductionsPanel(){
        productions = new JPanel();
        productions.setLayout(new BoxLayout(productions, BoxLayout.Y_AXIS));
        productions.setBackground(Color.decode("#393939"));
        productions.setForeground(Color.WHITE);
        productions.add(new MyProductionsPanel());
        panelDialog.add(new JScrollPane(productions), BorderLayout.CENTER);
    }

    private void addButtonAcept(ActionListener listener){
        JPanel panelButton =  new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.setOpaque(false);
        JButton buttonAcept = new JButton(ACCEPT_TEXT);
        buttonAcept.setForeground(Color.white);
        buttonAcept.addActionListener(listener);
        buttonAcept.setActionCommand(Commands.ACCEPT_PRODUCTION.toString());
        buttonAcept.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonAcept.setBackground(Color.decode("#393939"));
        buttonAcept.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonAcept.setBorderPainted(false);
        buttonAcept.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	buttonAcept.setBackground(Color.decode("#6E6E6E"));
        		buttonAcept.setBorderPainted(false);
            }
			@Override
            public void mouseExited(MouseEvent e){
            	buttonAcept.setBackground(Color.decode("#393939"));
        		buttonAcept.setBorderPainted(false);
            }
        });
        panelButton.add(buttonAcept);
        panelDialog.add(panelButton, BorderLayout.PAGE_END);
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

    public void openDialog(Component component){
        setLocationRelativeTo(component);
        setVisible(true);
    }

    public ArrayList<Production> getProductions(){
        ArrayList<Production> productionsList = new ArrayList<>();
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
            MyProductionsPanel production = (MyProductionsPanel)componentsProductions[i]; 
            productionsList.add(new Production(production.getNoTerminalSimbol(),production.getProduction()));
        }
        productions.revalidate();
        productions.repaint();
        isEnable = false;
        return productionsList;
    }

    public void enableProductions(){
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
           ((MyProductionsPanel)componentsProductions[i]).enableTextFields(); 
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductions(){
        Component[] componentsProductions = productions.getComponents();
        for (int i = 0; i < componentsProductions.length; i++) {
           ((MyProductionsPanel)componentsProductions[i]).deleteContentTextFields(); 
        }
        isEnable = true;
        productions.revalidate();
        productions.repaint();
    }

    public void deleteProductionField(){
        Component[] componentsProductions = productions.getComponents();
        if(componentsProductions.length > 1 && isEnable){
            productions.remove(componentsProductions.length - 1);
            productions.revalidate();
            productions.repaint();
        }
    }

    public void addProductionField(){
        if(isEnable){
            productions.add(new MyProductionsPanel());
            productions.revalidate();
            productions.repaint();
        }
    }
}
