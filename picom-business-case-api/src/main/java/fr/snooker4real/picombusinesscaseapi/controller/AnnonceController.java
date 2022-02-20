package fr.snooker4real.picombusinesscaseapi.controller;

import fr.snooker4real.picombusinesscaseapi.entity.UserEntity;
import fr.snooker4real.picombusinesscaseapi.model.Annonce;
import fr.snooker4real.picombusinesscaseapi.services.AnnonceService;
import fr.snooker4real.picombusinesscaseapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class AnnonceController {

    private final AnnonceService annonceService;

    private final UserService userService;

    public AnnonceController(AnnonceService annonceService, UserService userService) {
        this.annonceService = annonceService;
        this.userService= userService;
    }

    @PostMapping("/annonces/{idUser}")
    public Annonce createAnnonce(@RequestBody Annonce annonce, @PathVariable Long idUser) {
        UserEntity user = userService.recupererUserParId(idUser);
        annonce.setUser(user);
        return annonceService.createAnnonce(annonce, idUser);
    }

    @GetMapping("/annonces")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Annonce> getAllAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @DeleteMapping("/annonces/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = annonceService.deleteAnnonce(id);
        return ResponseEntity.ok(Map.of("deleted", deleted));
    }

    @GetMapping("/annonces/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id) {
        Annonce annonce = null;
        annonce = annonceService.getAnnonceById(id);
        return ResponseEntity.ok(annonce);
    }

    @PutMapping("/annonces/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable Long id,
                                                 @RequestBody Annonce annonce) {
        annonce = annonceService.updateAnnonce(id, annonce);
        return ResponseEntity.ok(annonce);
    }

}
