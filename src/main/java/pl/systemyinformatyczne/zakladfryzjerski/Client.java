package pl.systemyinformatyczne.zakladfryzjerski;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client
{
    private int id;
    private String name;
    private String surname;
}
