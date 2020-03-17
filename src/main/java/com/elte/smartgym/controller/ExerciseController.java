package com.elte.smartgym.controller;

import com.elte.smartgym.model.Exercise;
import com.elte.smartgym.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Exercise>> getAll() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> get(@PathVariable Integer id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isPresent()) {
            return ResponseEntity.ok(exercise.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Exercise> post(@RequestBody Exercise exercise) {
        Exercise savedExercise = exerciseRepository.save(exercise);
        return ResponseEntity.ok(savedExercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> put(@RequestBody Exercise exercise, @PathVariable Integer id) {
        Optional<Exercise> oExercise = exerciseRepository.findById(id);
        if (oExercise.isPresent()) {
            exercise.setId(id);
            return ResponseEntity.ok(exerciseRepository.save(exercise));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Exercise> oExercise = exerciseRepository.findById(id);
        if (oExercise.isPresent()) {
            exerciseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
