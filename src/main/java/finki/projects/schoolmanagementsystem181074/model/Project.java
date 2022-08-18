package finki.projects.schoolmanagementsystem181074.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.function.Supplier;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher.getId() +
                ", user=" + user.getUsername() +
                '}';
    }

}
