package models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WordChecker {

    private Grammar grammar;

    public WordChecker(Grammar grammar) throws NullPointerException {
        this.grammar = grammar;
    }

    public ParticularNode<Symbol> getTreeWord(String word) throws NullPointerException {
        System.out.println("word = " + word);
        System.out.println(checkWord(word));
        return getTree(checkWord(word));
    }

    private ParticularNode<Symbol> getTree(ParticularNode<Production> language) throws NullPointerException {
        if (language != null) {
            ParticularNode<Symbol> tree = new ParticularNode<>(new AxiomSymbol(language.getSymbol().getNoTerminalSymbol()));
            ParticularNode<Symbol> next = tree;
            while (language != null) {
                NoTerminalSymbol noTerminalSymbol = new NoTerminalSymbol(language.getSymbol().getNoTerminalSymbol());
                TerminalSymbol terminalSymbol = new TerminalSymbol(language.getSymbol().getProduction());
                next.setLeft(new ParticularNode<>(noTerminalSymbol));
                next.setRight(new ParticularNode<>(terminalSymbol));
                next = next.getRight();
                language = language.getRight();
            }
            return tree;
        }
        return null;
    }

    /**
     * Valida si la palabra ingresada se encuentra en el lenguaje construido por la
     * gramática
     *
     * @param word
     * @return
     */
    private ParticularNode<Production> checkWord(String word) throws NullPointerException {
        //Construye el lenguaje desde el simbolo axiomático de la gramática
        ParticularNode<Production> language = new ParticularNode<Production>(new Production());
        //System.out.println(language.getSimbol());
        String actualNonTerminal = null;
        String firstNonTerminal = grammar.getAxiomSymbol();
        ArrayList<Production> actualProductions = getProductions(firstNonTerminal);
        for (int i = 0; i < word.length(); i++) {
            System.out.println(i);
            if (i + 1 == word.length()) {//Verifica si es el ultimo caracter de la palabra
                Production production = getTerminalProduction(" " + word.charAt(i), actualProductions, word.charAt(i));
                if (production != null) {//La palabra pertenece al lenguaje
                    language.addToBottom(new ParticularNode<Production>(production));
                    return language;
                }
            } else {
                System.out.println("terminal actual: " + actualNonTerminal);
                System.out.println("production actual: " + actualProductions);
                System.out.println("production: " + getNonTerminalProductions(actualNonTerminal, actualProductions, word.charAt(i)).toString());
                Production production1 = getNonTerminalProductions(actualNonTerminal, actualProductions, word.charAt(i));
                System.out.println("production after: " + production1.toString());
                // System.out.println("production after: " + production.getProduction());
                //System.out.println("production toString: " + production.toString());
                //el simbolo no pertenece al lenguaje
                //                System.out.println("(production == null) = " + (production1 == null));
                // if (production == null)  return null;
                actualNonTerminal = actualProductions.get(actualProductions.size() - 1).getProduction().substring(actualProductions.get(actualProductions.size() - 1).getProduction().length() - 1);
                System.out.println("terminal actual2: " + actualNonTerminal);
                actualProductions.addAll(getProductions(actualNonTerminal));
                language.addToBottom(new ParticularNode<Production>(production1));
            }
            System.out.println("lenguaje: " + language.toString());
        }
        JOptionPane.showMessageDialog(null, "Palabra no existe");
        return null;
    }

    /**
     * Obtiene las producciones cuyo simbolo no terminal es igual
     * al simbolo no terminal especificado
     *
     * @param nonTerminalSymbol
     * @return
     */
    private ArrayList<Production> getProductions(String nonTerminalSymbol) throws NullPointerException {
        return (ArrayList<Production>) grammar.getProductions().stream()
                .filter(p -> p.getNoTerminalSymbol().equals(nonTerminalSymbol))
                .collect(Collectors.toList());
    }

    private Production getNonTerminalProductions(String symbol, ArrayList<Production> productions, char letter) throws NullPointerException {
        System.out.println("funciona0");
        for (Production p : productions) {
            System.out.println("funciona1");
            String production = p.getProduction();
            System.out.println("funciona2");
            if (!production.equals(production.toUpperCase())) {
                System.out.println("funciona3");
                System.out.println("Prodcution:" + p.getProduction().toString());
                System.out.println("simbolo: " + symbol);
                if (p.getProduction().charAt(0) == letter) {
                    System.out.println("funciona4");
                    return p;
                }
            }
        }
        return null;
    }

    private Production getTerminalProduction(String symbol, ArrayList<Production> productions, char letter) throws NullPointerException {
        System.out.println("SIMBOLO FINAL!!!!!!!");
        System.out.println("funciona 0");
        for (Production p : productions) {
            System.out.println("funciona 1");
            String production = p.getProduction();
            System.out.println("funciona 2");
            if (!production.equals(production.toUpperCase())) {
                System.out.println("funciona 3");
                System.out.println("Prodcution:" + p.getProduction().toString());
                System.out.println("simbolo: " + symbol);
                if ((p.getProduction().charAt(0) == letter) && (p.getProduction().length() == 1)) {
                    System.out.println("funciona 4");
                    return p;
                }
            }
        }
        return null;
    }
}
