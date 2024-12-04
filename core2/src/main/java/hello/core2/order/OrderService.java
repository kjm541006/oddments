package hello.core2.order;

public interface OrderService {
    Order createOrder(Long id, String productName, int price);
}
