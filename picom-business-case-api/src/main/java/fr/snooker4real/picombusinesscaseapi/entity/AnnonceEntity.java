package fr.snooker4real.picombusinesscaseapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

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
    protected OffsetDateTime date_debut;

    @Column(name = "date_fin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected OffsetDateTime date_fin;

    @Column(name = "date_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate dateCreation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    protected UserEntity user;

}
