package views.components;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import models.Symbol;


public class MyCellTree extends DefaultTreeCellRenderer{
    
    private static final long serialVersionUID = 1L;

    private static final Font FONT = new Font("Cursive",Font.PLAIN,16);
    private static final Font FONT_BOLD = new Font("Cursive",Font.BOLD,16);
    private static final Color COLOR_GREEN = Color.decode("#249210");

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object node, boolean selected, boolean expanded,
    boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, node, selected,expanded, leaf, row, hasFocus);
        tree.setRowHeight(20);
        setOpaque(true);     
        setFont(FONT);
        setForeground(Color.BLACK);
        if( selected ){
            setForeground(COLOR_GREEN);        
            setFont(FONT_BOLD);
        }
        setIcon(getImage(((Symbol)((DefaultMutableTreeNode)node).getUserObject()).getPathImage(),10,10));
        return this;
    }
    
    public static Icon getImage(String routeImage, int width, int heigth){
        ImageIcon icon = new ImageIcon(routeImage);
        Icon scaleIcon = new ImageIcon(icon.getImage().getScaledInstance(width, heigth, Image.SCALE_SMOOTH));
        return scaleIcon;
    }
}
