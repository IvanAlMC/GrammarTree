package views.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import models.ParticularNode;
import models.Symbol;
import views.components.MyCellTree;

public class MyParticularTreePanel extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE_HEADER = "Arbol Derivacion Particular ";
    private static final String GRAMMAR_SIMBOL = "W";
    private static final Color COLOR_HEADER = Color.decode("#4992E6");
    public static final Font DESCRIPTION_FONT = new Font("Cursive", Font.BOLD, 16);

    private DefaultMutableTreeNode graphicRoot;
    private DefaultTreeModel treeModel;
    private JTree graphicTree;
    private JPanel panelCenter;

    private JLabel header;
    
    public MyParticularTreePanel(){
        setLayout(new BorderLayout());
        setForeground(Color.white);
        setBackground(COLOR_HEADER);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBackground(Color.decode("#393939"));
        panelCenter.setOpaque(false);
        add(panelCenter,BorderLayout.CENTER);
        addHeader();
        treeModel = new DefaultTreeModel(graphicRoot);
        graphicTree = new JTree(treeModel);
        panelCenter.add(new JScrollPane(graphicTree) ,BorderLayout.CENTER);
    }

    private void addHeader(){
        header = new JLabel();
        header.setForeground(Color.WHITE);
        header.setHorizontalTextPosition(SwingConstants.RIGHT);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setFont(DESCRIPTION_FONT);
        header.setText(TITLE_HEADER);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        add(header,BorderLayout.PAGE_START);
    }

    public void showTree(ParticularNode<Symbol> root) throws NullPointerException{
        header.setText(TITLE_HEADER + GRAMMAR_SIMBOL);
        graphicRoot = new DefaultMutableTreeNode(root.getSymbol());
        printTree(graphicRoot,root.getLeft(),root.getRight());
        treeModel.setRoot(graphicRoot);
        expandTree();
        graphicTree.setCellRenderer(new MyCellTree());
        revalidate();
        repaint();
    }

    @SuppressWarnings("rawtypes")
	private void printTree(DefaultMutableTreeNode graphicBase, ParticularNode leftNode, ParticularNode righNode) {
            if(leftNode != null){
                DefaultMutableTreeNode actualLeft = new DefaultMutableTreeNode(leftNode.getSymbol());
                graphicBase.add(actualLeft);
                printTree(actualLeft,leftNode.getLeft(),leftNode.getRight());
            }
            if(righNode != null){
                DefaultMutableTreeNode actualRigth = new DefaultMutableTreeNode(righNode.getSymbol());
                graphicBase.add(actualRigth);
                printTree(actualRigth,righNode.getLeft(),righNode.getRight());
            }
        }

    public void expandTree() {
        expandAllNodes(graphicTree, 0, graphicTree.getRowCount());
    }

    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

}
