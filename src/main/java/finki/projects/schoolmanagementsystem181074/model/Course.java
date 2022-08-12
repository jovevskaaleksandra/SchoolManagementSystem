package finki.projects.schoolmanagementsystem181074.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
//    @SequenceGenerator(name = "course_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    private Double credits;

    private Boolean isEvenSemester;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", credits=" + credits +
                ", isEvenSemester=" + isEvenSemester +
                ", students=" + students +
                ", teacher=" + teacher.getId()+
                '}';
    }
}
