package com.mining.controller;

import com.mining.facade.OrderFacade;
import com.mining.dto.OrderDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FrontController {
    private OrderFacade orderFacade = new OrderFacade();

    public void handleRequest(String command, Long orderId) {
        System.out.println("\n🚪 Front Controller: принял команду '" + command +
                "' для заказа #" + orderId);

        logRequest(command, orderId);
        checkSecurity(orderId);

        switch (command.toLowerCase()) {
            case "view" -> handleView(orderId);
            case "cancel" -> handleCancel(orderId);
            default -> System.out.println("❌ Неизвестная команда: " + command);
        }
    }

    private void handleView(Long orderId) {
        OrderDTO order = orderFacade.getOrderDetails(orderId);

        if (order != null) {
            System.out.println("\n📄 РЕЗУЛЬТАТ (Transfer Object):");
            System.out.println(order);
        } else {
            System.out.println("❌ Заказ #" + orderId + " не найден");
        }
    }

    private void handleCancel(Long orderId) {
        orderFacade.cancelOrder(orderId);
        handleView(orderId);
    }

    //Запись поступающих команд в реальном времени по ID (логирование)
    private void logRequest(String command, Long orderId) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("📝 Лог: действие=" + command + ", orderId=" + orderId + ", дата = " + date +
                ", время = " + time);
    }

    //Что-то типа фильтра?
    private void checkSecurity(Long orderId) {
        System.out.println("🔒 Проверка прав: пользователь имеет доступ к заказу #" + orderId);
    }
}

