package com.Desafio.primeiro;

import com.Desafio.primeiro.entities.Order;
import com.Desafio.primeiro.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class PrimeiroApplication implements CommandLineRunner {
    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(PrimeiroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Numero da ordem de serviço: ");
        Integer code = sc.nextInt();
        System.out.print("Valor básico: ");
        Double basic = sc.nextDouble();
        System.out.print("Desconto: ");
        Double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);
        System.out.println("Pedido código: " + order.getCode());
        System.out.printf("Valor Total: %.2f ", orderService.total(order));
        sc.close();

    }

}
