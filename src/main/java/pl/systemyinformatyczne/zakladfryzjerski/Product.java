package pl.systemyinformatyczne.zakladfryzjerski;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private int id;
    private String manufacturer;
    private String model;
    private int numberOf;
}
