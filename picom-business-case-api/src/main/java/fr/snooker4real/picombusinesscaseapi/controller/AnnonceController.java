package fr.snooker4real.picombusinesscaseapi.controller;

import fr.snooker4real.picombusinesscaseapi.model.Annonce;
import fr.snooker4real.picombusinesscaseapi.services.AnnonceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AnnonceController {

    private final AnnonceService annonceService;


    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/annonces")
    public Annonce createAnnonce(@RequestBody Annonce annonce) {
        return annonceService.createAnnonce(annonce);
    }

    @GetMapping("/annonces")
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
