package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @ManyToOne
    private Class1 c;

    @OneToOne
    private Student student;

    public Registration() {
    }

    public Registration(Integer id, Timestamp timestamp, Class1 c, Student student) {
        this.id = id;
        this.timestamp = timestamp;
        this.c = c;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Class1 getC() {
        return c;
    }

    public void setC(Class1 c) {
        this.c = c;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
