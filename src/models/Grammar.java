package models;

import java.util.ArrayList;

public class Grammar {

    private String grammarName;
    private ArrayList<String> noTerminalSymbols;
    private ArrayList<String> terminalSymbols;
    private ArrayList<Production> productions;
    private String axiomSymbol;

    public Grammar(ArrayList<String> noTerminalSymbols, ArrayList<String> terminalSimbols, String axiomSimbol){
        this.noTerminalSymbols = noTerminalSymbols;
        this.terminalSymbols = terminalSimbols;
        this.axiomSymbol = axiomSimbol;
    }

    public String getGrammarName() {
        return grammarName;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public ArrayList<String> getNoTerminalSymbols() {
        return noTerminalSymbols;
    }

    public void setNoTerminalSymbols(ArrayList<String> noTerminalSymbols) {
        this.noTerminalSymbols = noTerminalSymbols;
    }

    public ArrayList<String> getTerminalSymbols() {
        return terminalSymbols;
    }

    public void setTerminalSymbols(ArrayList<String> terminalSymbols) {
        this.terminalSymbols = terminalSymbols;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    public String getAxiomSymbol() {
        return axiomSymbol;
    }

    public void setAxiomSymbol(String axiomSymbol) {
        this.axiomSymbol = axiomSymbol;
    }
}
