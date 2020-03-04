package mk.ukim.finki.wp.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Food")
@Data
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idF;

    @Column(name = "nameFood")
    private String name;

    @Column (name = "picFood")
    private String picUrl;

    private float kcal;

    @ManyToMany
    private List<Diet> diets;

    @ManyToMany(mappedBy = "foods",fetch = FetchType.EAGER)
    private List<Person> people;


    public Food(String name, String picUrl, float kcal){
        this.name= name;
        this.picUrl = picUrl;
        this.kcal = kcal;

    }

}
