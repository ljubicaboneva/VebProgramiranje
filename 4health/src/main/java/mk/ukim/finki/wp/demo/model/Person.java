package mk.ukim.finki.wp.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firstName")
    private String name;

    @Column(name = "lastName")
    private String surname;

    private String gender;

    private int age;

    @ManyToMany
    private List<Exercise> exercises;

    @ManyToMany
    private List<Food> foods;

    @ManyToMany
    private  List<Supplement> supplements;

    @ManyToOne
    private Diet diet;

    public Person(String name,String surname, String gender, int age){
        this.name = name;
        this.surname= surname;
        this.gender = gender;
        this.age = age;
        this.exercises = new ArrayList<>();
        this.foods = new ArrayList<>();

    }

}
