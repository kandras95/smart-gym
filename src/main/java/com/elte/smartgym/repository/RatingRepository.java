package com.elte.smartgym.repository;

import com.elte.smartgym.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
