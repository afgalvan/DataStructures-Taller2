package co.edu.unicesar.estructura.datos.taller2.points.point6;

import co.edu.unicesar.estructura.datos.taller2.models.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ValueObject
public class ActionItem {

    private int code;
    private char action;

    @Override
    public String toString() {
        return "{ código: " + code + ", acción: '" + action + "' }";
    }
}
