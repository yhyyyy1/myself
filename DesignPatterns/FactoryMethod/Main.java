package FactoryMethod;

import FactoryMethod.Factory.Factory;
import FactoryMethod.Factory.Product;
import FactoryMethod.IMAPConnection.IMAP;
import FactoryMethod.POP3Connection.POP3;

public class Main {
    public static void main(String[] args) {
        Factory IMAPFactory = new IMAP();
        Factory POP3Factory = new POP3();
        Product connection1 = IMAPFactory.create("001");
        Product connection2 = POP3Factory.create("002");
        Product connection3 = POP3Factory.create("003");
        Product connection4 = IMAPFactory.create("004");
        connection1.use();
        connection2.use();
        connection3.use();
        connection4.use();
    }
}
