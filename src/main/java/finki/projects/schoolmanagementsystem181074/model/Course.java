package finki.projects.schoolmanagementsystem181074.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Integer credits;
}
