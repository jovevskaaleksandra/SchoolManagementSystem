package finki.projects.schoolmanagementsystem181074.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @SequenceGenerator(name = "students_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "students_index", nullable = false)
    private String index;

    @Column(name = "students_name", nullable = false)
    private String name;

    @Column(name = "students_surname", nullable = false)
    private String surname;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private List<Course> courses;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Dashboard dashboard;

    public List<String> getCoursesNames() {
        List<String> names = new ArrayList<>();
        for (Course course:courses) {
            names.add(course.getName()+",");
        }
        return names;
    }

}
