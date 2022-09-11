package Entity;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

    private Integer productId;
    private String productName;
    private Integer productCount;
    private LocalDate expiredTime;
    private Integer price;
    private TypeShop typeShopId;

        public Product(Integer productId, String productName, Integer productCount, LocalDate expiredTime, Integer price, TypeShop typeShopId) {
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
        this.expiredTime = expiredTime;
        this.price = price;
        this.typeShopId = typeShopId;
    }

    public Product(int productId, String hfhg, int productCount, LocalDate localDate, int price, Integer typeId) {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public LocalDate getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDate expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TypeShop getTypeShopId() {
        return typeShopId;
    }

    public void setTypeShopId(TypeShop typeShopId) {
        this.typeShopId = typeShopId;
    }

    @Override
    public String toString() {
        return productId + ". " + productName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }

}
