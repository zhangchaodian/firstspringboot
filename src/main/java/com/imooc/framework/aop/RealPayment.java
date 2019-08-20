package com.imooc.framework.aop;

// 这个RealPayment就是用户支付，背后的取钱和转账操作是由Alipay支付宝来实现
public class RealPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("作为用户，我只关心支付功能");
    }
}
