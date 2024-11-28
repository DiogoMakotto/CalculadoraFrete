package com.makotto.calculaFrete;

import com.makotto.calculaFrete.entities.Order;
import com.makotto.calculaFrete.handler.UserInputHandler;
import com.makotto.calculaFrete.services.OrderService;
import com.makotto.calculaFrete.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculaFreteApplication implements CommandLineRunner {

	@Autowired private OrderService orderService;
	@Autowired private ShippingService shippingService;


	public static void main(String[] args) {
		SpringApplication.run(CalculaFreteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserInputHandler userInputHandler = new UserInputHandler();

		Integer code = userInputHandler.readInputInteger();
		Double basic = userInputHandler.readInputBasicDouble();
		Double discount = userInputHandler.readInputDiscountDouble();

		Order order = new Order();
		order.setCode(code);
		order.setBasic(basic);
		order.setDiscount(discount);

		double valueAfterDiscount  = orderService.applyDiscount(order);

		order.setBasic(valueAfterDiscount);

		shippingService.shippiment(order);

		System.out.println("Pedido código: " +  code);
		System.out.println("Valor total: " + order.getBasic());

	}
}
