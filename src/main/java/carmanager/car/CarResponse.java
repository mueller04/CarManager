package carmanager.car;

import lombok.Builder;

@Builder
public class CarResponse {

    private String carName;

    private int price;

    @Override
    public String toString() {
        return "car name "+ carName + " price: " + String.valueOf(price);
    }
}
