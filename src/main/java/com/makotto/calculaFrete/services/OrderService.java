package com.makotto.calculaFrete.services;

import com.makotto.calculaFrete.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    //total(order : Order): double
    //valor final vem daqui

    @Autowired ShippingService shippingService;
    public double applyDiscount(Order order) {

        Double basic = order.getBasic();
        Double discount = order.getDiscount();

        return basic - (basic *( discount / 100));

    }


}
