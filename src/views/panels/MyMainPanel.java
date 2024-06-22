package views.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import models.GeneralNode;
import models.ParticularNode;


public class MyMainPanel extends JPanel{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyParametresPanel parametersPanel;
    private MyGeneralTreePanel generalTreePanel;
    private MyCheckWordPanel panelWordValidate;
    private MyParticularTreePanel particularTreePanel;
    private JPanel panelRigth;

    public MyMainPanel(ActionListener listener){
        setLayout(new BorderLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener){
        JPanel panelLeft = new JPanel(new BorderLayout());
        setBackground(Color.decode("#393939"));
        panelLeft.setBackground(Color.decode("#393939"));
        parametersPanel = new MyParametresPanel(listener);
        parametersPanel.setBackground(Color.decode("#393939"));
        panelLeft.add(parametersPanel, BorderLayout.NORTH);
        generalTreePanel = new MyGeneralTreePanel();
        generalTreePanel.setBackground(Color.decode("#393939"));
   //     panelLeft.add(generalTreePanel, BorderLayout.CENTER);
        add(panelLeft, BorderLayout.WEST);
        panelRigth = new JPanel(new BorderLayout());
        panelRigth.setBackground(Color.decode("#393939"));
        panelWordValidate = new MyCheckWordPanel(listener);
        panelWordValidate.setBackground(Color.decode("#393939"));
        panelLeft.add(panelWordValidate, BorderLayout.CENTER);
        panelRigth.add(generalTreePanel,BorderLayout.CENTER);
        particularTreePanel = new MyParticularTreePanel();
        particularTreePanel.setBackground(Color.decode("#393939"));
        particularTreePanel.setPreferredSize(new Dimension(400,700));
        panelRigth.add(particularTreePanel,BorderLayout.EAST);
        generalTreePanel.setPreferredSize(new Dimension(400,700));
        panelRigth.add(generalTreePanel, BorderLayout.WEST);
        panelRigth.setSize(new Dimension(800,700));
        add(panelRigth, BorderLayout.CENTER);

        
    }


    public void showGeneralTree(GeneralNode root, String grammarName){
        generalTreePanel.showTree(root,grammarName);
    }

    public String getGrammarName(){
        return parametersPanel.getGrammarName();
    }

    public String[] getSigma(){
        return parametersPanel.getSigma();
    }

    public String[] getNoTerminalSimbols(){
        return parametersPanel.getNoTerminalSimbols();
    }

    public String getAxiom(){
        return parametersPanel.getAxiom();
    }

    public void enableFields(){
        parametersPanel.enableFields();
    }

    public void deleteContentFields(){
        parametersPanel.deleteContentFields();
    }

    public String getWord(){
        return panelWordValidate.getWord();
    }
    
  @SuppressWarnings({ "unchecked", "rawtypes" })
	public void showTree(ParticularNode root) throws NullPointerException{
      particularTreePanel.showTree(root);
  }

//    @SuppressWarnings("rawtypes")
//	public void showTree(ParticularNode root) throws NullPointerException{
//        panelWordValidate.showTree(root);
//    }
}
