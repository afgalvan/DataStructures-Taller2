package co.edu.unicesar.estructura.datos.taller2.points.point4;

import co.edu.unicesar.estructura.datos.taller2.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ValueObject
public class Person {

    private String id;
    private String name;
}
