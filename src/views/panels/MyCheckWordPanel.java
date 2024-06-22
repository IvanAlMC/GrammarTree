package views.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Commands;
import views.components.MyButton;

public class MyCheckWordPanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String BUTTON_TEXT = "Validar";
    public static final String EQUAL_SYMBOL = " = ";
    private static final String GRAMMAR_SIMBOL = "W";
    public static final Font TEXT_FIELD_FONT = new Font("Cursive", Font.PLAIN, 20);
    public static final Font LABEL_FONT = new Font("Cursive", Font.BOLD, 20);
    public static final String DESCRIPTION = "Ingrese la palabra a validar";
    public static final Font DESCRIPTION_FONT = new Font("Cursive", Font.BOLD, 16);

    private JTextField wordTextField;
    private JPanel panelBox;
//    private MyParticularTreePanel particularTreePanel;

    public MyCheckWordPanel(ActionListener listener){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        setForeground(Color.WHITE);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        panelBox = new JPanel();
        panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
        panelBox.setOpaque(false);
        addLabel();
        addTextFieldAndButton(listener);
        add(panelBox, BorderLayout.PAGE_START);
//        particularTreePanel = new MyParticularTreePanel();
//        add(particularTreePanel,BorderLayout.CENTER);
    }

    private void addLabel(){
        JPanel panelDescription = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDescription.setOpaque(false);
        JLabel description = new JLabel(DESCRIPTION);
        description.setForeground(Color.white);
        description.setFont(DESCRIPTION_FONT);
        panelDescription.add(description);
        panelBox.add(panelDescription);
    }

    private void addTextFieldAndButton(ActionListener listener){
        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHeader.setOpaque(false);
        JLabel word = new JLabel(GRAMMAR_SIMBOL + EQUAL_SYMBOL);
        word.setForeground(Color.white);
        word.setFont(LABEL_FONT);
        panelHeader.add(word);
        wordTextField = new JTextField(10);
        wordTextField.setForeground(Color.black);
        wordTextField.setFont(TEXT_FIELD_FONT);
        panelHeader.add(wordTextField);
        MyButton validateButton = new MyButton(BUTTON_TEXT);
        validateButton.addActionListener(listener);
        validateButton.setActionCommand(Commands.VALIDATE_WORD.toString());
        panelHeader.add(validateButton);
        panelBox.add(panelHeader);
    }

    public String getWord(){
        return wordTextField.getText();
    }

//    @SuppressWarnings({ "unchecked", "rawtypes" })
//	public void showTree(ParticularNode root) throws NullPointerException{
//        particularTreePanel.showTree(root);
//    }
}

