package com.example.SpringAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sensor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле с именем не должно быть пустым")
    @Size(min = 3, max = 30, message = "Поле должно содержать от 3 до 30 символов")
    @Column(name = "name")
    private String name;


    @JsonBackReference
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerSensor")
    private List<Measurement> measurements;

    public void addSensorToMeasurement(Measurement measurement) {
        measurement.setOwnerSensor(this);
    }
}
