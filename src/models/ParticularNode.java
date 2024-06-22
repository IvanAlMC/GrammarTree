package models;

public class ParticularNode<T> {

    private T symbol;
    private ParticularNode<T> left;
    private ParticularNode<T> right;

    public ParticularNode(T symbol) {
        this.symbol = symbol;
    }

    public T getSymbol() {
        return symbol;
    }

    public void setSymbol(T symbol) {
        this.symbol = symbol;
    }

    public ParticularNode<T> getLeft() {
        return left;
    }

    public void setLeft(ParticularNode<T> left) {
        this.left = left;
    }

    public ParticularNode<T> getRight() {
        return right;
    }

    public void setRight(ParticularNode<T> right) {
        this.right = right;
    }

    public void addToBottom(ParticularNode<T> node) {
        ParticularNode<T> actual = this;
        while (actual.right != null) actual = actual.right;
        actual.right = node;
    }

}
