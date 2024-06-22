package models;

import java.util.ArrayList;
import java.util.Arrays;

public class GrammarManager {

    private Grammar grammar;
    private GeneralNode generalRoot;
    private WordChecker checker;

    public GrammarManager() {

    }

    // metodo que crea la gramática
    public void createGrammar(String grammarName, String[] noTerminalSymbols, String[] terminalSymbols,
                              String axiomSymbol, ArrayList<Production> productions) {
        this.grammar = new Grammar(changeToList(noTerminalSymbols), changeToList(terminalSymbols), axiomSymbol);
        grammar.setGrammarName(grammarName);
        grammar.setProductions(productions);
        generateGeneralTree();
        checker = new WordChecker(grammar);
    }

    // metodo que convierte la lista de palabras entrantes en arraylist
    public ArrayList<String> changeToList(String[] list) {
        return new ArrayList<>(Arrays.asList(list));
    }

    //  metodos para generar el arbol general de la gramática
    public void generateGeneralTree() {
        generalRoot = new GeneralNode(new AxiomSymbol(grammar.getAxiomSymbol()));
        addBranch(generalRoot, 0);
    }

    public void addBranch(GeneralNode father, int level) {
        if (level < 5) {
            String symbols = father.getSymbol().getSymbol();
            for (int i = 0; i < symbols.length(); i++) {
                char symbol = symbols.charAt(i);
                if (isNoTerminal(symbol)) {
                    addWordsToFather(father, symbols, i, symbol);
                    break;
                }
            }
            level++;
            ArrayList<GeneralNode> childrenSymbol = father.getChildrenSymbol();
            for (GeneralNode childSymbol : childrenSymbol) {
                addBranch(childSymbol, level);
            }
        }
    }

    private void addWordsToFather(GeneralNode father, String symbols, int i, char symbol) {
        ArrayList<String> symbolsProductions = searchProduction(String.valueOf(symbol));
        for (String string : symbolsProductions) {
            father.addChild(new GeneralNode(new WordSymbol(formatWord(symbols, string, i))));
        }
    }

    private String formatWord(String symbols, String production, int symbolPosition) {
        String word = "";
        for (int i = 0; i < symbols.length(); i++) {
            char symbol = symbols.charAt(i);
            if (i == symbolPosition)
                word += production;
            else
                word += symbol;

        }
        return word;
    }

    // Métodos que valida si un simbolo es o no terminal
    private boolean isNoTerminal(char character) {
        return grammar.getNoTerminalSymbols().contains(String.valueOf(character));
    }

    //método que busca una producción dentro de la lista de producciones de la gramatica
    public ArrayList<String> searchProduction(String noTerminalSymbol) {
        ArrayList<String> symbolsProductions = new ArrayList<>();
        ArrayList<Production> productions = grammar.getProductions();
        for (Production production : productions) {
            if (noTerminalSymbol.equals(production.getNoTerminalSymbol())) {
                symbolsProductions.add(production.getProduction());
            }
        }
        return symbolsProductions;
    }

    public void print() {
        System.out.println("Simbolos no terminales-------");
        ArrayList<String> symbolListOne = grammar.getNoTerminalSymbols();
        for (String string : symbolListOne) {
            System.out.println(string);
        }
        System.out.println("Simbolos terminales--------");
        ArrayList<String> symbolListTwo = grammar.getTerminalSymbols();
        for (String string : symbolListTwo) {
            System.out.println(string);
        }
        System.out.println("Axioma---------");
        System.out.println(grammar.getAxiomSymbol());
        ArrayList<Production> productions = grammar.getProductions();
        for (Production production : productions) {
            System.out.println(production);
        }
    }

    public void printTree() {
        printNode(generalRoot, 1, -1);
    }

    public void printNode(GeneralNode node, int level, int fatherId) {
        System.out.println(node + " - FatherId=" + fatherId + " - level=" + level);
        level++;
        for (GeneralNode child : node.getChildrenSymbol()) {
            printNode(child, level, node.getId());
        }
    }

    public GeneralNode getGeneralRoot() {
        return generalRoot;
    }

    public ParticularNode<Symbol> getParticularRoot(String word) {
        return checker.getTreeWord(word);
    }

    public String getGrammarName() {
        return grammar.getGrammarName();
    }
}
