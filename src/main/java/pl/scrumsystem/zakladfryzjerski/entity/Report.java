package pl.scrumsystem.zakladfryzjerski.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String salon = "Unknown";
    private String name;
    private String manufacturer;
    private String model;
    private String workplace;
    private String date_of_damage = "Unknown";
    private String priority = "Unknown";
    private String description;
    private String info;
}
