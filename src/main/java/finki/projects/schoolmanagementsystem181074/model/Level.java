package finki.projects.schoolmanagementsystem181074.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Level {
    @Id
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="level")
    private List<Class> classes;

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
