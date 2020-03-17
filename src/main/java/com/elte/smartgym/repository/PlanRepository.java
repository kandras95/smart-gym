package com.elte.smartgym.repository;

import com.elte.smartgym.model.Plan;
import org.springframework.data.repository.CrudRepository;

public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
