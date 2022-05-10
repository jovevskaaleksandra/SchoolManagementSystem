package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class SchoolYear {

    @Id
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="schoolYear")
    private List<Class> classes;

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
