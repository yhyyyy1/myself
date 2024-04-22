package com.example.learningcode.proxyLearn;

public class test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("蔡徐坤");
        Star proxy = ProxyUtil.createProxy(bigStar);

        //调用对应的方法：
        String result = proxy.sing("只因你太美");
        System.out.println(result);

        proxy.dance();
    }
}
