package com.makotto.calculaFrete.handler;

import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);

    public Integer readInputInteger() {

        System.out.println("Digite o numero do pedido: ");
        int code = scanner.nextInt();
        return code;
    }

    public Double readInputBasicDouble() {

        System.out.println("Digite o valor do pedido: ");
        Double basic = scanner.nextDouble();
        return basic;
    }

    public Double readInputDiscountDouble() {

        System.out.println("Digite o valor do desconto: ");
        Double discount = scanner.nextDouble();
        return discount;
    }

}
