package com.mining.dao;

import com.mining.entity.Order;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OrderDAO {
    private static final Map<Long, Order> DB = new HashMap<>();

    static {
        DB.put(1L, new Order(1L, "Иван Петров",
                Arrays.asList("Ноутбук", "Мышь", "Коврик"), "Доставлен"));
        DB.put(2L, new Order(2L, "Мария Смирнова",
                Arrays.asList("Телефон", "Чехол"), "В обработке"));
        DB.put(3L, new Order(3L, "Алексей Иванов",
                Arrays.asList("Книга Java"), "Отменен"));
    }

    public Order findById(Long id) {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        return DB.get(id);
    }

    public void updateStatus(Long id, String newStatus) {
        Order order = DB.get(id);
        if (order != null) {
            order.setStatus(newStatus);
            System.out.println("✅ Статус заказа #" + id + " обновлен на: " + newStatus);
        }
    }
}
