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

    @Column(nullable = true)
    private Long chassisId;;

    @Column(nullable = true)
    private Long engineId;

    @Column(nullable = true)
    private Long tireId;
}
