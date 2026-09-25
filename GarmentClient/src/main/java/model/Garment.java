package model;

import java.math.BigDecimal;

public class Garment {

    private Integer garmentid;
    private String garmentname;
    private String size;
    private String category;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public Garment() {
    }

    public Garment(Integer garmentid, String garmentname, String size,
                   String category, String description,
                   BigDecimal price, Integer stock) {
        this.garmentid = garmentid;
        this.garmentname = garmentname;
        this.size = size;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Integer getGarmentid() {
        return garmentid;
    }

    public void setGarmentid(Integer garmentid) {
        this.garmentid = garmentid;
    }

    public String getGarmentname() {
        return garmentname;
    }

    public void setGarmentname(String garmentname) {
        this.garmentname = garmentname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Garment{" +
                "garmentid=" + garmentid +
                ", garmentname='" + garmentname + '\'' +
                ", size='" + size + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}