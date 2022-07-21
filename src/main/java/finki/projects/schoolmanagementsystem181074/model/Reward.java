package finki.projects.schoolmanagementsystem181074.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reward {

    @Id
    @GeneratedValue
    private Long id;

    //proveri koi se ocenite na studentot ako prosekot e >8.0 nagradi go so krediti
}
