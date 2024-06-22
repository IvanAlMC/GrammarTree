package models;

public class TerminalSymbol implements Symbol {

    private String symbol;

    public TerminalSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/terminalNode.png";
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
