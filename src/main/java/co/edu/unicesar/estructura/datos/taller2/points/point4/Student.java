package co.edu.unicesar.estructura.datos.taller2.points.point4;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student extends Person {

    private List<Double> gradesList;
    private double prom;
}
