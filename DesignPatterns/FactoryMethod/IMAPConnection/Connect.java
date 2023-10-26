package FactoryMethod.IMAPConnection;

import FactoryMethod.Factory.Product;

public class Connect extends Product {
    private String id;

    Connect(String id) {
        System.out.println("创建IMAP协议连接，连接ID为：" + id);
        this.id = id;
    }

    @Override
    public void use() {
        System.out.println("使用连接ID为：" + id + "的IMAP连接");
    }

    public String getId() {
        return id;
    }
}
