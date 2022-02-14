package fr.snooker4real.picombusinesscaseapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "annonces")
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false)
    protected long id;

    protected String titre;

    @Lob
    protected String description;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "date_debut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date date_debut;

    @Column(name = "date_fin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date date_fin;

    @Column(name = "date_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected UserEntity user;

}
