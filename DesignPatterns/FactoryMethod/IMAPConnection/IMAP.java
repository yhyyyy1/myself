package FactoryMethod.IMAPConnection;

import FactoryMethod.Factory.Factory;
import FactoryMethod.Factory.Product;

import java.util.ArrayList;
import java.util.List;

public class IMAP extends Factory {
    private List connectionIds = new ArrayList();

    @Override
    protected void registerProduct(Product p) {
        connectionIds.add(((Connect) p).getId());
    }

    @Override
    protected Product createProduct(String connectionId) {
        return new Connect(connectionId);
    }

    public List getConnectionIds() {
        return connectionIds;
    }
}
