package finki.projects.schoolmanagementsystem181074.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "predmeti")
public class Subject {

    @Id
    private Integer id;


    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
    private List<Teaching> teachings;

    public Subject(){
        super();
    }

    public Subject(Integer id, String name) {
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

