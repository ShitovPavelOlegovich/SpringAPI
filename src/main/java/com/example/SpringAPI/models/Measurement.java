package com.example.SpringAPI.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Min(value = -100, message = "Значение должно быть от -100 до 100")
    @Max(value = 100, message = "Значение должно быть от -100 до 100")
    @Column(name = "value")
    private double value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "date_of_created")
    private LocalDateTime dateOfCreated;


//    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor ownerSensor;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }


}
