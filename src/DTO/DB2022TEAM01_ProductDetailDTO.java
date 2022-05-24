package DTO;

import jdk.jfr.Category;

import java.time.LocalDateTime;

public class DB2022TEAM01_ProductDetailDTO {
    private String productName;
    private String IdolGroup;
    private Long IdolID;
    private String IdolMemeber;
    private String Category;
    private String Seller;
    private long price;
    private LocalDateTime resisterAt;
    private boolean isInWishlist;
    private boolean isSold;

    // productName, price, Seller, Category, IdolID, resisterAt
    public DB2022TEAM01_ProductDetailDTO(String ProductName, long price, String Seller, String Category, Long IdolId, LocalDateTime resisterAt) {
        this.productName = productName;
        this.IdolID = IdolID;
        this.price = price;
        this.Seller = Seller;
        this.Category = Category;
        this.IdolID = IdolID;
        this.resisterAt = resisterAt;
    }



    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setIdolGroup(String idolGroup) {
        IdolGroup = idolGroup;
    }

    public void setIdolMemeber(String idolMemeber) {
        IdolMemeber = idolMemeber;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setSeller(String seller) {
        Seller = seller;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setResisterAt(LocalDateTime resisterAt) {
        this.resisterAt = resisterAt;
    }

    public void setInWishlist(boolean inWishlist) {
        isInWishlist = inWishlist;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getProductName() {
        return productName;
    }

    public String getIdolGroup() {
        return IdolGroup;
    }

    public String getIdolMemeber() {
        return IdolMemeber;
    }

    public String getCategory() {
        return Category;
    }

    public String getSeller() {
        return Seller;
    }

    public long getPrice() {
        return price;
    }

    public LocalDateTime getResisterAt() {
        return resisterAt;
    }

    public boolean isInWishlist() {
        return isInWishlist;
    }

    public boolean isSold() {
        return isSold;
    }
}
