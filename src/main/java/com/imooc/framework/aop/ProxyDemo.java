package com.imooc.framework.aop;

public class ProxyDemo {
    // 通过main函数，以AliPay作为代理,给RealPayment织入取款和转账的逻辑
    public static void main(String[] args) {
        Payment proxy = new AliPay(new RealPayment());
        proxy.pay();
    }
}
