package finki.projects.schoolmanagementsystem181074.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teachers")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teachers_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "teacher_code", nullable = false)
    private String code;

    @Column(name = "teacher_name", nullable = false)
    private String name;

    @Column(name = "teacher_surname", nullable = false)
    private String surname;

    @Column(name = "teacher_email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.PERSIST)
    private List<Course> courses;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.PERSIST)
    private List<Project> projects;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", courses=" + courses +
                '}';
    }
}
