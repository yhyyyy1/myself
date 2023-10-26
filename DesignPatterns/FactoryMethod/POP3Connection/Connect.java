package FactoryMethod.POP3Connection;

import FactoryMethod.Factory.Product;

public class Connect extends Product {
    private String id;

    Connect(String id) {
        System.out.println("创建POP3协议连接，连接ID为：" + id);
        this.id = id;
    }

    @Override
    public void use() {
        System.out.println("使用连接ID为：" + id + "的POP3连接");
    }

    public String getId() {
        return id;
    }
}
