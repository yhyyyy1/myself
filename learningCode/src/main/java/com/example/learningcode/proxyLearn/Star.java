package com.example.learningcode.proxyLearn;

public interface Star {

    //将可以被代理的方法定义在接口中

    /**
     * 唱歌
     */
    public abstract String sing(String name);

    /**
     * 跳舞
     */
    public abstract void dance();
}