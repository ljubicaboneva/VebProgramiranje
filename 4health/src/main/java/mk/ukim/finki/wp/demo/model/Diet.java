package mk.ukim.finki.wp.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Diet")
@Data
@NoArgsConstructor
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idD;

    @Column(name = "nameDiet")
    private String name;

    private String desc;

    @ManyToMany(mappedBy = "diets",fetch = FetchType.EAGER)
    private List<Food> foods;

    @OneToMany(mappedBy = "diet")
    private List<Person> people;

    public Diet(String name, String desc){
        this.name = name;
        this.desc = desc;
        this.foods = new ArrayList<>();
        this.people = new ArrayList<>();
    }

}
