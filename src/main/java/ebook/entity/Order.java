package ebook.entity;

import java.util.List;

public class Order {
    List<CartInfo> carts;
    String receiverAddress;
    String receiverName;
    String receiverPhone;

    public List<CartInfo> getCarts() {
        return carts;
    }

    public void setCarts(List<CartInfo> carts) {
        this.carts = carts;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
}
