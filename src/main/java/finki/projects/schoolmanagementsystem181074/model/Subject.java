package finki.projects.schoolmanagementsystem181074.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "predmeti")
public class Subject {

    @Id
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
    private List<Teacher> teachers;

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

