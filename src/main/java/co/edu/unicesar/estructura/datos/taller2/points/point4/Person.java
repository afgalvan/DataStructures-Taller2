package co.edu.unicesar.estructura.datos.taller2.points.point4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Person extends Entity {

    private String name;

    public Person(String id, String name) {
        super(id);
        this.name = name;
    }
}
