package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.GeneralNode;
import models.ParticularNode;
import views.panels.MyMainPanel;

public class GuiManager extends JFrame{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Dimension WINDOW_SIZE = new Dimension(1200,700);
    public static final String TITLE = "Arboles de Gramatica App";
    public static final String LOGO_PATH = "src/img/logo.png";

    private MyMainPanel principalPanel;

    public GuiManager(ActionListener listener){
        initComponents(listener);
        setBackground(Color.decode("#393939"));
        setVisible(true);
    }

    private void initComponents(ActionListener listener){
        setTitle(TITLE);
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(LOGO_PATH).getImage());
        setLocationRelativeTo(null);

        principalPanel = new MyMainPanel(listener);
        principalPanel.setBackground(Color.decode("#393939"));
        add(principalPanel);
    }

    public String getGrammarName(){
        return principalPanel.getGrammarName();
    }   

    public String[] getSigma(){
        return principalPanel.getSigma();
    }

    public String[] getNoTerminalSymbols(){
        return principalPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return principalPanel.getAxiom();
    }

    public void showGeneralTree(GeneralNode root, String grammarName){
        principalPanel.showGeneralTree(root, grammarName);
    }

    public void enableFields(){
        principalPanel.enableFields();
    }

    public void deleteContentFields(){
        principalPanel.deleteContentFields();
    }

    public String getWord(){
        return principalPanel.getWord();
    }

    @SuppressWarnings("rawtypes")
	public void showTree(ParticularNode root) throws NullPointerException{
        principalPanel.showTree(root);
    }
}