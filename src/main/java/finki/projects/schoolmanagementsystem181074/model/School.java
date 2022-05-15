package finki.projects.schoolmanagementsystem181074.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="school")
    private List<Class1> classes;

    public School() {
    }

    public School(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
