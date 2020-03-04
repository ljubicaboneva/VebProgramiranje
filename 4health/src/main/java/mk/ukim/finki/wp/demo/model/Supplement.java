package mk.ukim.finki.wp.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Supplement")
@Data
@NoArgsConstructor
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idS;

    @Column(name = "nameSupplement")
    private String name;

    @Column(name = "descSupplement")
    private String desc;

    private int price;

    @Column (name = "picSupplement")
    private String picUrl;

    @Column(name="gr")
    private int grams;

    @ManyToMany(mappedBy = "supplements",fetch = FetchType.EAGER)
    private List<Person> people;

    public Supplement(String name, String desc,int price, String picUrl, int grams){
        this.name = name;
        this.desc = desc;
        this.price=price;
        this.picUrl=picUrl;
        this.grams=grams;
        this.people = new ArrayList<>();
    }
}
