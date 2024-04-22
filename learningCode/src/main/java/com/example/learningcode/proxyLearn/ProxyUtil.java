package com.example.learningcode.proxyLearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 为了创建一个代理
 */
public class ProxyUtil {
    /**
     * 给对象创建一个代理
     * 形参：被代理的明星对象
     * 返回值：创建的代理
     */
    public static Star createProxy(BigStar bigStar) {
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(), //用当前的类生成的，所以要用当前的类来加载
                new Class[]{Star.class}, //首先是个数组，数组中包含代理方法的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /**
                         * Object proxy 表示代理的对象
                         * Method method 表示要运行的方法 如sing or dance
                         * Object[] args 调用对应方法时传递的参数
                         */


                        // 前期准备
                        if ("sing".equals(method.getName())) {
                            System.out.println("准备话筒，收钱");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备场地，收钱");
                        }

                        // 开始执行代理方法

                        return method.invoke(bigStar, args);
                    }
                }
        );
        return star;
    }

}
