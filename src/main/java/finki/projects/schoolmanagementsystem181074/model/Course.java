package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Double credits;

    private Boolean isEvenSemester;


}
