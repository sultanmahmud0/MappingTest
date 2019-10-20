package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    int orderId;
    String orderNumber;
}
