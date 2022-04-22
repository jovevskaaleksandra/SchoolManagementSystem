package finki.projects.schoolmanagementsystem181074.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "korisnici")
public class User {
    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

}
