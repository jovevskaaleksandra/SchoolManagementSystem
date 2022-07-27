package finki.projects.schoolmanagementsystem181074.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String index;

    private String name;

    private String surname;

    @ManyToMany
    private List<Course> courses;
}
