package co.edu.unicesar.estructura.datos.taller2.points.point4;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GradeSet extends Entity {

    private final List<Double> gradesList = new ArrayList<>();

    public GradeSet(String id) {
        super(id);
    }

    public void add(double grade) {
        gradesList.add(grade);
    }
}
