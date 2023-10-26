package FactoryMethod.Factory;

public abstract class Factory {
    public final Product create(String connectionId) {
        Product p = createProduct(connectionId);
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(Product p);

    protected abstract Product createProduct(String connectionId);
}
