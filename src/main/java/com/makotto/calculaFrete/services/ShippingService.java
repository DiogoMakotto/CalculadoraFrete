package com.makotto.calculaFrete.services;

import com.makotto.calculaFrete.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    //shippiment(order: Order): double

    public void shippiment(Order order) {

        Double basic = order.getBasic();

        if (basic < 100.00) {
            order.setBasic(basic + 20.00);
        } else if (basic >= 100.00 && basic <= 200.00) {
            order.setBasic(basic + 12.00);
        } else {
            order.setBasic(basic);
        }

    }

}
