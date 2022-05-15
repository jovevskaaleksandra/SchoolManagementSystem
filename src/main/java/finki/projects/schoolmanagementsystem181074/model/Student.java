package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy="student")
    private Registration registration;

    public Student() {
        super();
    }

    public Student(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
