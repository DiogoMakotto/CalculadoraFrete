package com.makotto.calculaFrete;

import com.makotto.calculaFrete.entities.Order;
import com.makotto.calculaFrete.formatter.CurrencyFormatter;
import com.makotto.calculaFrete.services.OrderService;
import com.makotto.calculaFrete.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculaFreteApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingService shippingService;

    public static void main(String[] args) {
        SpringApplication.run(CalculaFreteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Criação e cálculo para o primeiro pedido
        Order order1 = new Order(1034, 150.0, 20.0);
        processOrder(order1);

        // Criação e cálculo para o segundo pedido
        Order order2 = new Order(2282, 800.0, 10.0);
        processOrder(order2);

        // Criação e cálculo para o terceiro pedido
        Order order3 = new Order(1309, 95.90, 0.0);
        processOrder(order3);
    }

    private void processOrder(Order order) {
        // Aplica o frete ao pedido
        shippingService.applyShipping(order);

        // Calcula o valor total com desconto aplicado
        double totalWithDiscount = orderService.applyDiscount(order);

        // Exibe as informações do pedido
        System.out.println("Pedido código: " + order.getCode());
        System.out.println("Valor total: R$ " + CurrencyFormatter.format(totalWithDiscount));
    }
}
