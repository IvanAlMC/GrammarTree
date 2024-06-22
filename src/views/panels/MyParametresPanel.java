package views.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Commands;
import views.components.MyButton;
import views.components.MyTextFields;

public class MyParametresPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SIGMA = "E";
    public static final String V = "V";
    public static final String GRAMMAR = "G";
    public static final String AXIOM = "S";
    public static final String PRODUCTION = "P";
    public static final String GENERATE_BUTTON_TEXT = "Generar";
    public static final String EQUAL_SYMBOL = " = ";
    public static final String DESCRIPTION = "Ingrese los valores de la gramatica";
    public static final Font PARAMETERS_FONT = new Font("Cursive", Font.BOLD, 20);
    public static final Font DESCRIPTION_FONT = new Font("Cursive", Font.BOLD, 13);

    private JPanel panelBox;
    private MyTextFields grammarField;
    private MyTextFields sigmaField;
    private MyTextFields noTerminalField;
    private MyTextFields axiomField;
    private MyTextFields productionsField;
    
    public MyParametresPanel(ActionListener listener){
        setLayout(new FlowLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setBackground(Color.decode("#393939"));
        setForeground(Color.WHITE);
        initComponents(listener);
        addButtons(listener);
    }

    private void initComponents(ActionListener listener){
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setOpaque(false);
        panelBox.setBackground(Color.decode("#393939"));
        addLable();
        addParameters(listener);
        add(panelBox);
    }

    private void addLable(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(DESCRIPTION);
        description.setForeground(Color.white);
        description.setFont(DESCRIPTION_FONT);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    private void addParameters(ActionListener listener){
        grammarField = new MyTextFields(GRAMMAR + EQUAL_SYMBOL,"Ingrese numero de la gramatica");
        panelBox.add(grammarField);
        sigmaField = new MyTextFields(SIGMA + EQUAL_SYMBOL,"Ejemplo: a,b");
        panelBox.add(sigmaField);
        noTerminalField = new MyTextFields(V + EQUAL_SYMBOL,"Ejemplo: S,A");
        panelBox.add(noTerminalField);
        axiomField = new MyTextFields(AXIOM + EQUAL_SYMBOL,"Ejemplo: S");
        panelBox.add(axiomField);
        productionsField = new MyTextFields(PRODUCTION + EQUAL_SYMBOL,"Abrir","Ejemplo S -> aA",listener,Commands.ADD_PRODUCTIONS.toString());
        panelBox.add(productionsField);
    }

    private void addButtons(ActionListener listener){
        JPanel panelButtons = new JPanel(new GridLayout(3, 1, 0, 5));
        panelButtons.setOpaque(false);
        MyButton buttonGenerate = new MyButton(GENERATE_BUTTON_TEXT);
        buttonGenerate.addActionListener(listener);
        buttonGenerate.setActionCommand(Commands.ADD_GRAMMAR.toString());
        panelButtons.add(buttonGenerate);
        MyButton buttonEdit = new MyButton("Editar");
        buttonEdit.addActionListener(listener);
        buttonEdit.setActionCommand(Commands.EDIT_GRAMMAR.toString());
        panelButtons.add(buttonEdit);
        MyButton buttonDelete = new MyButton("Borrar");
        buttonDelete.addActionListener(listener);
        buttonDelete.setActionCommand(Commands.DELETE_GRAMMAR.toString());
        panelButtons.add(buttonDelete);
        add(panelButtons);
    }

    public String getGrammarName(){
        return grammarField.getText();
    }

    public String[] getSigma(){
        return sigmaField.getText().split(",");
    }

    public String[] getNoTerminalSimbols(){
        return noTerminalField.getText().split(",");
    }

    public String getAxiom(){
        return axiomField.getText();
    }

    public void enableFields(){
        grammarField.enableTextField();
        sigmaField.enableTextField();
        noTerminalField.enableTextField();
        axiomField.enableTextField();
    }

    public void deleteContentFields(){
        grammarField.deletContentTextField();
        sigmaField.deletContentTextField();
        noTerminalField.deletContentTextField();
        axiomField.deletContentTextField();
    }
}
