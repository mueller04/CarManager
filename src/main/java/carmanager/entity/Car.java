package carmanager.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carName;

    private int price;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHASSIS_ID")
    private Chassis chassis;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ENGINE_ID")
    private Engine engine;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TIRE_ID")
    private Tire tire;
}
