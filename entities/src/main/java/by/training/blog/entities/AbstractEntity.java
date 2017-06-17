package by.training.blog.entities;

import javax.persistence.*;

/**
 * Created by Win on 12.06.2017.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    protected int id;

    public AbstractEntity(){}
}
