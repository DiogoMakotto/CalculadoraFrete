package com.makotto.calculaFrete.services;

import com.makotto.calculaFrete.entities.Order;
import com.makotto.calculaFrete.formatter.CurrencyFormatter;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shippiment(Double basic) {

        if (basic < 100.00) {
            return 20.00;
        } else if (basic >= 100.00 && basic <= 200.00) {
            return 12.00;
        } else {
            return 0.00; // Frete grátis para pedidos acima de 200.00
        }
    }

    public String getFormattedShippingCost(Double basic) {
        double shippingCost = shippiment(basic);
        return CurrencyFormatter.format(shippingCost);
    }

    public void applyShipping(Order order) {
        double shippingCost = shippiment(order.getBasic());
        order.setBasic(order.getBasic() + shippingCost);
    }

}
