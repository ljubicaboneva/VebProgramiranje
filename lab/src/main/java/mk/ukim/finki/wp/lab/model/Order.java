package mk.ukim.finki.wp.lab.model;

import lombok.*;


@Data
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor

public class Order {

    public String pizzaType;
    public String clientName;
    public String clientAddress;
    public Long orderId;
    public String pizzaSize;

}
