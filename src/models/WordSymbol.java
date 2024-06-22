package models;

public class WordSymbol implements Symbol {

    private String symbol;

    public WordSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/childNode.png";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}