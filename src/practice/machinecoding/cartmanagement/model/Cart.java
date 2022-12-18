package practice.machinecoding.cartmanagement.model;

import java.util.Date;
import java.util.List;

public class Cart {
    long cartId;
    List<Product> products;
    Status cartStatus;
    Date lastUpdated;
}
