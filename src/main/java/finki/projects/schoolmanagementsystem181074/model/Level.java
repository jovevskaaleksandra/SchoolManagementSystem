package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="level")
    private List<Class1> classes;

    public Level(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Level() {
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
