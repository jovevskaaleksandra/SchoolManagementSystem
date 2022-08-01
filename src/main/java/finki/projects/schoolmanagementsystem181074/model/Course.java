package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Double credits;

    private Boolean isEvenSemester;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Student> students;
}
