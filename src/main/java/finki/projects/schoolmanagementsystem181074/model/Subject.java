package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "predmeti")
public class Subject {
    @Id
    private String name;

    //ucenici
    //ocena
}
