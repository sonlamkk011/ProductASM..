package com.example.productasm.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private String shipName;
    private String shipPhone;
    private String shipAddress;
    private String shipNote;
    private HashMap<Integer, CartItem> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public List<CartItem> getListItems() {
        return new ArrayList<>(items.values()); // chuyển từ một map sang một list
    }

    public boolean add(Product product, int quantity) {
        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            Integer updateQuantity = quantity + cartItem.getQuantity();
            if (updateQuantity <= 0) {
                // nếu số lượng nhỏ hơn hoặc bằng không thì xóa bỏ
                items.remove(product.getId());
            } else {
                //  cập nhật số lượng theo số lượng mới
                cartItem.setQuantity(updateQuantity);
            }
        } else {
            if (quantity > 0) {
                cartItem = CartItem.CartItemBuilder.aCartItem()
                        .productId(product.getId())
                        .productName(product.getName())
                        .productThumbnail(product.getThumbnail())
                        .unitPrice(product.getPrice())
                        .quantity(quantity)
                        .build();
                items.put(product.getId(), cartItem);
            }
        }
        return true;
    }

    public boolean sub(Product product, int quantity) {
        CartItem cartItem = null;
        if (items.containsKey(product.getId())) {
            cartItem = items.get(product.getId());
            int updateQuantity = cartItem.getQuantity() - quantity;
            if (updateQuantity <= 0) {
                items.remove(product.getId());
            } else {
                cartItem.setQuantity(updateQuantity);
            }
        }
        return true;
    }

    public boolean remove(int producttId) {
        if (items.containsKey(producttId)) {
            items.remove(producttId);
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }


    public double getTotalPrice() {
        if (items.size() == 0) {
            return 0;
        }
        for (CartItem item : getListItems()) {
            totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        return totalPrice;
    }


    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipNote() {
        return shipNote;
    }

    public void setShipNote(String shipNote) {
        this.shipNote = shipNote;
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }


}
