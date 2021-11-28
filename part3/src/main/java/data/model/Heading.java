package data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Heading {
    private String intitule;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Heading(String intitule) {
        this.intitule = intitule;
    }

    public String toString(){
        return this.intitule;
    }
}
