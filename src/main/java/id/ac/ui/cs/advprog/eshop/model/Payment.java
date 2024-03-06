package id.ac.ui.cs.advprog.eshop.model;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class Payment {
    String id;
    String method;
    Map<String, String> paymentData;
    Order order;
    String status;

    public Payment(String id,  Order order, String method, Map<String, String>paymentData){
        this(order, method, paymentData);
        this.id = id;
    }

    public Payment(Order order, String method, Map<String, String>paymentData){
        this.id = UUID.randomUUID().toString();
        this.method = method;
        this.order = order;
        try{
            setPaymentData(paymentData);
            setStatus(PaymentStatus.SUCCESS.getValue());
        }catch (IllegalArgumentException e){
            setStatus(PaymentStatus.REJECTED.getValue());
            throw new IllegalArgumentException();
        }
    }

    private void setStatus(String status){
        this.status=status;
    }

    private void setPaymentData(Map<String, String>paymentData){
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }
}