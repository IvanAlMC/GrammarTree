package models;

public class Production {

    private String noTerminalSymbol;
    private String production;

    public Production() {

    }

    public Production(String noTerminalSymbol, String production) {
        this.noTerminalSymbol = noTerminalSymbol;
        this.production = production;
    }

    public String getNoTerminalSymbol() {
        return noTerminalSymbol;
    }

    public void setNoTerminalSymbol(String noTerminalSymbol) {
        this.noTerminalSymbol = noTerminalSymbol;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Production [noTerminalSymbol=" + noTerminalSymbol + ", production=" + production + "]";
    }
}
