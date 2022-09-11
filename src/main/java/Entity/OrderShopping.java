package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class OrderShopping {

    private Integer orderId;
    private Integer total_price;
    private Customer customer_id;
    private Product product_id;
    private LocalDate orderTime;


    public OrderShopping(Integer orderId, Integer total_price, Customer customer_id, Product product_id, LocalDate orderTime) {
        this.orderId = orderId;
        this.total_price = total_price;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.orderTime = orderTime;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderShopping{" +
                "orderId=" + orderId +
                ", total_price=" + total_price +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", orderTime=" + orderTime +
                '}';
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderShopping)) return false;
        OrderShopping that = (OrderShopping) o;
        return Objects.equals(getOrderId(), that.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }
}
