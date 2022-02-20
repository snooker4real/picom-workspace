package fr.snooker4real.picombusinesscaseapi.services;

import fr.snooker4real.picombusinesscaseapi.model.Annonce;

import java.util.List;

public interface AnnonceService {

    Annonce createAnnonce(Annonce annonce, Long idUser);

    List<Annonce> getAllAnnonces();

    boolean deleteAnnonce(Long id);

    Annonce getAnnonceById(Long id);

    Annonce updateAnnonce(Long id, Annonce annonce);

}
