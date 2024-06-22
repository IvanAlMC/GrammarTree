package models;

import java.util.ArrayList;

public class GeneralNode {

    private static int sequential;
    private int id;
    private Symbol symbol;
    private ArrayList<GeneralNode> childrenSymbol;

    public GeneralNode(Symbol symbol){
        this.id = sequential++;
        this.symbol = symbol;
        this.childrenSymbol = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public ArrayList<GeneralNode> getChildrenSymbol() {
        return childrenSymbol;
    }

    public void addChild(GeneralNode child){
        this.childrenSymbol.add(child);
    }

    @Override
    public String toString() {
        return " simbol=" + symbol.getSymbol();
    }
}
