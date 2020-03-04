package mk.ukim.finki.wp.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Exercise")
@Data
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idE;

    @Column(name = "NameExercise")
    private String name;

    private String description;

    private String picUrl;

    @ManyToMany(mappedBy = "exercises",fetch = FetchType.EAGER)
    private List<Person> people;

    public Exercise(String name, String description, String picUrl) {
        this.name = name;
        this.description = description;
        this.picUrl = picUrl;
        this.people = new ArrayList<>();
    }




}