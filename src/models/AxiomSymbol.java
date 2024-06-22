package models;

public class AxiomSymbol implements Symbol {

    private String symbol;

    public AxiomSymbol(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String getPathImage() {
        return "src/img/axiomNode.png";
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
