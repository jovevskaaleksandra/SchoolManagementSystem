package finki.projects.schoolmanagementsystem181074.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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
    private Set<Course> courses;


}
