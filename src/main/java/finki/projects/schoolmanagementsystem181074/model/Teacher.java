package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Teacher extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="teacher")
    private List<Teaching> teachings;


    public Teacher() {
        super();
    }

    public Teacher(Integer id) {
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
