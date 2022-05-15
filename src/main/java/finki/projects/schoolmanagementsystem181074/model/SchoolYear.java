package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class SchoolYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="schoolYear")
    private List<Class1> classes;

    public SchoolYear() {
    }

    public SchoolYear(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
