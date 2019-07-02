package ebook.entity;

import java.util.Date;

public class SeeOrder {
    Integer id;
    String cover;
    Float price;
    String title;
    Integer color;
    String shopname;
    String writer;
    Integer remains;
    Integer remarknum;
    Integer salenum;
    String isbn;
    String intro;
    Date time;
    Integer valid;
    Integer sales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getRemains() {
        return remains;
    }

    public void setRemains(Integer remains) {
        this.remains = remains;
    }

    public Integer getRemarknum() {
        return remarknum;
    }

    public void setRemarknum(Integer remarknum) {
        this.remarknum = remarknum;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
