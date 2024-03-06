package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class Payment {
    String id;
    String method;
    Map<String, String> paymentData;
    Order order;

    public Payment(String id,  Order order, String method, Map<String, String>paymentData){
        this(order, method, paymentData);
        this.id = id;
    }

    public Payment(Order order, String method, Map<String, String>paymentData){
        this.id = UUID.randomUUID().toString();
        this.method = method;
        this.order = order;
        setPaymentData(paymentData);
    }

    private void setPaymentData(Map<String, String>paymentData){
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }
}