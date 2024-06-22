package models;

public class NoTerminalSymbol implements Symbol {

    private String symbol;

    public NoTerminalSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/noTerminalNode.png";
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
