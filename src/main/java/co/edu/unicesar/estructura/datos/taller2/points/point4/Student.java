package co.edu.unicesar.estructura.datos.taller2.points.point4;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Student extends Entity {

    private String name;
    private List<Double> gradesList;
    private double prom;

    public Student(String id, String name, double prom) {
        super(id);
        this.name = name;
        this.gradesList = new ArrayList<>();
        this.prom = prom;
    }

    @Override
    public String toString() {
        return (
            "{" +
            "name='" +
            name +
            '\'' +
            ", gradesList=" +
            gradesList +
            ", prom=" +
            prom +
            '}'
        );
    }
}
