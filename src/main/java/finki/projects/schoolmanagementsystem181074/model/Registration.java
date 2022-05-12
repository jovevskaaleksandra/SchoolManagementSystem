package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
public class Registration {
    @Id
    private Integer id;

    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

    @ManyToOne
    private Class c;

    @OneToOne
    private Student student;

    public Registration() {
    }

    public Registration(Integer id, Timestamp timestamp, Class c, Student student) {
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

    public Class getC() {
        return c;
    }

    public void setC(Class c) {
        this.c = c;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
