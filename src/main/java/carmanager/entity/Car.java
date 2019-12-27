package carmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;

    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHASSIS_ID")
    private Chassis chassis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIRE_ID")
    private Tire tire;
}
