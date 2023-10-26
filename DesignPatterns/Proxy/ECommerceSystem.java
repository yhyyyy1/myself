package Proxy;

import java.util.HashMap;
import java.util.Map;

// 主题接口
interface Subject {
    Data request(String key);
}

// 真实主题类
class RealSubject implements Subject {
    @Override
    public Data request(String key) {
        // 模拟从数据操作对象查询数据的过程
        System.out.println("Querying data for key: " + key);
        // 返回查询的数据
        return new Data(key, "Data for " + key);
    }
}

// 数据类
class Data {
    private String key;
    private String value;

    public Data(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

// 代理类
class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy() {
        realSubject = new RealSubject();
    }

    @Override
    public Data request(String key) {
        return realSubject.request(key);
    }
}

// 缓冲代理类
class BufferProxy implements Subject {
    private RealSubject realSubject;
    private Map<String, Data> cache;

    public BufferProxy() {
        realSubject = new RealSubject();
        cache = new HashMap<>();
    }

    @Override
    public Data request(String key) {
        if (cache.containsKey(key)) {
            // 如果数据已经在缓存中，则直接返回缓存数据
            System.out.println("Retrieving data from cache for key: " + key);
            return cache.get(key);
        } else {
            // 否则，从真实主题获取数据并保存到缓存中
            Data data = realSubject.request(key);
            cache.put(key, data);
            return data;
        }
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        Subject bufferProxy = new BufferProxy();

        // 模拟用户查询数据
        System.out.println("Proxy:");
        Data data1 = proxy.request("product1");
        Data data2 = proxy.request("product2");
        Data data3 = proxy.request("product1");

        System.out.println("\nBufferProxy:");
        Data data4 = bufferProxy.request("product1");
        Data data5 = bufferProxy.request("product2");
        Data data6 = bufferProxy.request("product1");
    }
}