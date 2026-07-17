package com.mining;

import com.mining.controller.FrontController;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Интернет-магазин (консольная версия) ===\n");

        // Это единая точка входа
        FrontController frontController = new FrontController();

        // Симулируем запросы пользователей
        System.out.println("1️⃣ Запрос: показать заказ #1");
        frontController.handleRequest("view", 1L);

        System.out.println("\n2️⃣ Запрос: показать заказ #2");
        frontController.handleRequest("view", 2L);

        System.out.println("\n3️⃣ Запрос: отменить заказ #2");
        frontController.handleRequest("cancel", 2L);

        System.out.println("\n4️⃣ Запрос: показать несуществующий заказ #99");
        frontController.handleRequest("view", 99L);
    }
}