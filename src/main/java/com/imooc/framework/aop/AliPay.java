package com.imooc.framework.aop;


// AliPay就是一个代理，实现的重写方法pay才是个完整的事件
public class AliPay implements Payment{
    // 因为AliPay是代理，自然要含有payment的真实实例
    private Payment payment;
    public AliPay(Payment payment) {
        this.payment = payment;
    }

    public void beforePay() {
        System.out.println("从招行取款");
    }
    @Override
    public void pay() {
        beforePay();
        payment.pay();
        afterPay();
    }

    public void afterPay() {
        System.out.println("支付给商家");
    }
}
