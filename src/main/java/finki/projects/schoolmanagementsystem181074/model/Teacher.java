package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Teacher extends User{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

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
