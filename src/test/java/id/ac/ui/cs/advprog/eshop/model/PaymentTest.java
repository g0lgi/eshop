package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    List<Payment> payments;

    List<Order> orders;

    List<Product> products;

    @BeforeEach
    void setUp(){
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductQuantity(1);
        product1.setProductName("A");
        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductQuantity(2);
        product2.setProductName("B");
        this.products.add(product1);
        this.products.add(product2);

        this.orders = new ArrayList<>();

        Order order1 = new Order("b9s8wa3k-l67s-gm5d-qzvv-ife8locybiv0", products ,100L, "Asep");
        Order order2 = new Order("0y5p7fvf-l4vm-k7qv-65nn-pejroou0glfs", products ,200L, "Budi");
        Order order3 = new Order("lyssxjqv-zo8b-d7im-ouhq-pj4vdra2naq4", products ,300L, "Cia");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }
    @Test
    void testCreatePaymentSucessfulVoucher(){
        Map<String, String> paymentDataVoucher = new  HashMap<>();
        paymentDataVoucher.put("voucherCode", "ESHOP0123456789ABCDEF");
        Payment payment = new Payment("0perd4v7-i21t-qjzy-za5c-o512kidqbq6k",orders.get(1),
                "VOUCHER", paymentDataVoucher);
        assertSame(this.orders.get(1), payment.getOrder());
        assertEquals(paymentDataVoucher, payment.getPaymentData());
        assertEquals("0perd4v7-i21t-qjzy-za5c-o512kidqbq6k", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
    }

    @Test
    void testCreatePaymentVoucherFail(){
        Map<String, String> paymentDataVoucher = new  HashMap<>();
        paymentDataVoucher.put("voucherCode", "ESHOPA1");
        assertThrows(IllegalArgumentException.class, ()-> {new Payment("piimkqg0-y40p-mfiv-o635-lyg93wlpm1fc",orders.get(1),
                "VOUCHER", paymentDataVoucher);
        });
    }

    @Test
    void testCreatePaymentFailBankName(){
        Map<String, String> paymentDataBank = new  HashMap<>();
        paymentDataBank.put("bankName", "");
        paymentDataBank.put("referenceCode", "0");
        assertThrows(IllegalArgumentException.class, ()-> {new Payment("pdz75s39-0guq-4ovo-5eyx-w03mvquk7tju",orders.get(1),
                "BANK", paymentDataBank);
        });
    }

    @Test
    void testCreatePaymentFailReferenceCode(){
        Map<String, String> paymentDataBank = new  HashMap<>();
        paymentDataBank.put("bankName", "a");
        paymentDataBank.put("referenceCode", "");
        assertThrows(IllegalArgumentException.class, ()-> {new Payment("26l42yhn-1v2f-9gn0-m19d-com1vm2knqen",orders.get(1),
                "BANK", paymentDataBank);
        });
    }
}