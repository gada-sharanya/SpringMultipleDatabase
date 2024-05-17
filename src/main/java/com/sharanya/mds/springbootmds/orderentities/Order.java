package com.sharanya.mds.springbootmds.orderentities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Order {


    @Id
    private int orderId;
    private String orderFrom;
    private LocalDate orderDate;

    public Order() {
    }

    public Order(int orderId, String orderFrom, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderFrom = orderFrom;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderFrom='" + orderFrom + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
