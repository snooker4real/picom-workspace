package fr.snooker4real.picombusinesscaseapi.services.impl;

import fr.snooker4real.picombusinesscaseapi.entity.AnnonceEntity;
import fr.snooker4real.picombusinesscaseapi.model.Annonce;
import fr.snooker4real.picombusinesscaseapi.repository.AnnonceRepository;
import fr.snooker4real.picombusinesscaseapi.repository.UserRepository;
import fr.snooker4real.picombusinesscaseapi.services.AnnonceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private final AnnonceRepository annonceRepository;

    private final UserRepository userRepository;

    public AnnonceServiceImpl(AnnonceRepository annonceRepository, UserRepository userRepository) {
        this.annonceRepository = annonceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Annonce createAnnonce(Annonce annonce, Long idUser) {
        AnnonceEntity annonceEntity = new AnnonceEntity();
        userRepository.findById(idUser).ifPresent(annonce::setUser);
        BeanUtils.copyProperties(annonce, annonceEntity);
        annonceRepository.save(annonceEntity);
        return annonce;
    }


    @Override
    public List<Annonce> getAllAnnonces() {
        List<AnnonceEntity> annonceEntities = annonceRepository.findAll();
        return annonceEntities
                .stream()
                .map(annonce -> new Annonce(
                        annonce.getId(),
                        annonce.getTitre(),
                        annonce.getDescription(),
                        annonce.getImage_url(),
                        annonce.getDate_debut(),
                        annonce.getDate_fin(),
                        annonce.getDateCreation(),
                        annonce.getUser()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteAnnonce(Long id) {
        AnnonceEntity annonceEntity = annonceRepository.findById(id).get();
        annonceRepository.delete(annonceEntity);
        return true;
    }

    @Override
    public Annonce getAnnonceById(Long id) {
        AnnonceEntity annonceEntity = annonceRepository.findById(id).get();
        Annonce annonce = new Annonce();
        BeanUtils.copyProperties(annonceEntity, annonce);
        return annonce;
    }

    @Override
    public Annonce updateAnnonce(Long id, Annonce annonce) {
        AnnonceEntity annonceEntity = annonceRepository.findById(id).get();
        annonceEntity.setTitre(annonce.getTitre());
        annonceEntity.setDescription(annonce.getDescription());
        annonceEntity.setImage_url(annonce.getImage_url());
        annonceEntity.setDate_debut(annonce.getDate_debut());
        annonceEntity.setDate_fin(annonce.getDate_fin());

        annonceRepository.save(annonceEntity);
        return annonce;
    }


}
