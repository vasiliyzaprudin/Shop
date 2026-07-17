package com.mining.dto;
import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private String customerName;
    private BigDecimal totalAmount;
    private List<String> productNames;
    private String status;

    public OrderDTO(Long orderId, String customerName,
                    BigDecimal totalAmount, List<String> productNames,
                    String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.productNames = productNames;
        this.status = status;
    }

    public Long getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public List<String> getProductNames() { return productNames; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Заказ #" + orderId +
                "\nКлиент: " + customerName +
                "\nСумма: " + totalAmount + " руб." +
                "\nСтатус: " + status +
                "\nТовары: " + productNames +
                "\n------------------------";
    }
}