package views.panels;

import views.components.MyTextFields;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyProductionsPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Color COLOR_TEXT_FIELD = Color.white;
    public static final Color DISABLE_COLOR = Color.decode("#808487");
   
    private JTextField noTerminalSimbol;
    private JTextField production;

    public MyProductionsPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        setBackground(Color.decode("#393939"));
        initComponents();
    }
    
    private void initComponents(){
        addFields();
    }

    private void addFields(){
        noTerminalSimbol = new JTextField(5);
        noTerminalSimbol.setFont(MyTextFields.FIELDS_FONT);
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        add(noTerminalSimbol);
        JLabel arrow = new JLabel("->");
        arrow.setForeground(Color.white);
        arrow.setFont(MyParametresPanel.PARAMETERS_FONT);
        add(arrow);
        production = new JTextField(5);
        production.setFont(MyTextFields.FIELDS_FONT);
        production.setBackground(COLOR_TEXT_FIELD);
        add(production);
    }

    public String getNoTerminalSimbol() {
        noTerminalSimbol.setEnabled(false);
        noTerminalSimbol.setDisabledTextColor(DISABLE_COLOR);
        noTerminalSimbol.setBackground(Color.WHITE);
        return noTerminalSimbol.getText();
    }

    public String getProduction() {
        production.setEnabled(false);
        production.setDisabledTextColor(DISABLE_COLOR);
        production.setBackground(Color.WHITE);
        return production.getText();
    }

    public void enableTextFields(){
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setBackground(COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }

    public void deleteContentTextFields(){
        noTerminalSimbol.setText("");
        noTerminalSimbol.setBackground(COLOR_TEXT_FIELD);
        noTerminalSimbol.setEnabled(true);
        production.setText("");
        production.setBackground(COLOR_TEXT_FIELD);
        production.setEnabled(true);
    }
}
