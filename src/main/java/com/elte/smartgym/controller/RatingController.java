package com.elte.smartgym.controller;

import com.elte.smartgym.model.Rating;
import com.elte.smartgym.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Rating>> getAll() {
        return ResponseEntity.ok(ratingRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> get(@PathVariable Integer id) {
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isPresent()) {
            return ResponseEntity.ok(rating.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Rating> post(@RequestBody Rating rating) {
        Rating savedRating = ratingRepository.save(rating);
        return ResponseEntity.ok(savedRating);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> put(@RequestBody Rating rating, @PathVariable Integer id) {
        Optional<Rating> oRating = ratingRepository.findById(id);
        if (oRating.isPresent()) {
            rating.setId(id);
            return ResponseEntity.ok(ratingRepository.save(rating));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Rating> oRating = ratingRepository.findById(id);
        if (oRating.isPresent()) {
            ratingRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}