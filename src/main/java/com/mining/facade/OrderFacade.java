package com.mining.facade;

import com.mining.dao.OrderDAO;
import com.mining.dto.OrderDTO;
import com.mining.entity.Order;

import java.math.BigDecimal;

public class OrderFacade {
    private OrderDAO orderDAO = new OrderDAO();

    public OrderDTO getOrderDetails(Long orderId) {
        System.out.println("📞 Session Facade: получаю данные для заказа #" + orderId);

        //Находим заказ в базе данных по ID
        Order order = orderDAO.findById(orderId);

        if (order == null) {
            return null;
        }

        //Тут может быть сложная логика обработки данных
        BigDecimal total = BigDecimal.ZERO;
        for (String product : order.getProducts()) {
            BigDecimal price = switch (product) {
                case "Ноутбук" -> BigDecimal.valueOf(50000);
                case "Мышь" -> BigDecimal.valueOf(1500);
                case "Коврик" -> BigDecimal.valueOf(800);
                case "Телефон" -> BigDecimal.valueOf(30000);
                case "Чехол" -> BigDecimal.valueOf(1200);
                case "Книга Java" -> BigDecimal.valueOf(2500);
                default -> BigDecimal.valueOf(1000);
            };
            total = total.add(price);
        }

        //Создаем DTO (только нужные клиенту данные)
        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                total,
                order.getProducts(),
                order.getStatus()
        );
    }

    public void cancelOrder(Long orderId) {
        System.out.println("📞 Session Facade: отменяю заказ #" + orderId);
        orderDAO.updateStatus(orderId, "Отменен");
    }
}
