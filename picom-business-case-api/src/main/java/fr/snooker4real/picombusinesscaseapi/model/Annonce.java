package fr.snooker4real.picombusinesscaseapi.model;

import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annonces")
public class Annonce {

    protected long id;

    protected String titre;

    protected String description;

    private String image_url;

    protected OffsetDateTime date_debut;

    protected OffsetDateTime date_fin;

    protected LocalDate dateCreation = LocalDate.now();

    protected UserEntity user;


}
