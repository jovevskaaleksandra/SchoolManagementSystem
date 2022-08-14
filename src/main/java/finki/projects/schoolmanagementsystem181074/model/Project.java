package finki.projects.schoolmanagementsystem181074.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="diplomski")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String code;

    private String title;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;
}
