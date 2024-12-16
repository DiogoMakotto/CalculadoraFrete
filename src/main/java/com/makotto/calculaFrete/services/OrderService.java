package com.makotto.calculaFrete.services;

import com.makotto.calculaFrete.entities.Order;
import com.makotto.calculaFrete.formatter.CurrencyFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    ShippingService shippingService;

    public double applyDiscount(Order order) {

        Double basic = order.getBasic();
        Double discount = order.getDiscount();

        return basic - (basic * (discount / 100));

    }

    public String getFormattedDiscountedValue(Order order) {
        double discountedValue = applyDiscount(order);
        return CurrencyFormatter.format(discountedValue);
    }

}
