package hello.core1.order;

public interface OrderService {
    Order createOrder(Long id, String itemName, int itemPrice);
}
