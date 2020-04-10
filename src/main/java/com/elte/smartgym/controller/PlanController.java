package com.elte.smartgym.controller;

import com.elte.smartgym.model.Plan;
import com.elte.smartgym.model.User;
import com.elte.smartgym.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanRepository planRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Plan>> getAll() {
        return ResponseEntity.ok(planRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> get(@PathVariable Integer id) {
        Optional<Plan> plan = planRepository.findById(id);
        if (plan.isPresent()) {
            return ResponseEntity.ok(plan.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Plan> post(@RequestBody Plan plan) {
        Plan savedPlan = planRepository.save(plan);
        return ResponseEntity.ok(savedPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> put(@RequestBody Plan plan, @PathVariable Integer id) {
        Optional<Plan> oPlan = planRepository.findById(id);
        if (oPlan.isPresent()) {
            plan.setId(id);
            return ResponseEntity.ok(planRepository.save(plan));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Plan> oPlan = planRepository.findById(id);
        if (oPlan.isPresent()) {
            for(User user : oPlan.get().getUsers())
                user.setPlan(null);

            planRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}