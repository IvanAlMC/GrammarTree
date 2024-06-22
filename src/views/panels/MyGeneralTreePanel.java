package views.panels;

import models.GeneralNode;
import views.components.MyCellTree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class MyGeneralTreePanel extends JPanel {

    public static final Font DESCRIPTION_FONT = new Font("Cursive", Font.BOLD, 16);
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final String TITLE_HEADER = "Arbol Derivacion General ";
    private static final String GRAMMAR_SIMBOL = "G";
    private static final Color COLOR_HEADER = Color.decode("#B86BF5");
    private DefaultMutableTreeNode graphicRoot;
    private DefaultTreeModel treeModel;
    private JTree graphicTree;
    private JPanel panelCenter;

    private JLabel header;

    public MyGeneralTreePanel() {
        setLayout(new BorderLayout());
        setBackground(COLOR_HEADER);
        setBorder(BorderFactory.createLineBorder(Color.white, 2));
        panelCenter = new JPanel(new BorderLayout());
        panelCenter.setOpaque(false);
        panelCenter.setBackground(COLOR_HEADER);
        add(panelCenter, BorderLayout.CENTER);
        addHeader();
        treeModel = new DefaultTreeModel(graphicRoot);
        graphicTree = new JTree(treeModel);
        panelCenter.add(new JScrollPane(graphicTree), BorderLayout.CENTER);
    }

    private void addHeader() {
        header = new JLabel();
        header.setForeground(Color.WHITE);
        header.setBackground(COLOR_HEADER);
        header.setHorizontalTextPosition(SwingConstants.RIGHT);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setFont(DESCRIPTION_FONT);
        header.setText(TITLE_HEADER);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setVerticalAlignment(JLabel.CENTER);
        add(header, BorderLayout.PAGE_START);
    }

    public void showTree(GeneralNode root, String grammarName) {
        header.setText(TITLE_HEADER + GRAMMAR_SIMBOL + grammarName);
        graphicRoot = new DefaultMutableTreeNode(root.getSymbol());
        printTree(graphicRoot, root);
        treeModel.setRoot(graphicRoot);
        expandTree();
        graphicTree.setCellRenderer(new MyCellTree());
        revalidate();
        repaint();
    }

    private void printTree(DefaultMutableTreeNode graphicBase, GeneralNode base) {
        for (GeneralNode node : base.getChildrenSymbol()) {
            DefaultMutableTreeNode actual = new DefaultMutableTreeNode(node.getSymbol());
            graphicBase.add(actual);
            printTree(actual, node);
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

