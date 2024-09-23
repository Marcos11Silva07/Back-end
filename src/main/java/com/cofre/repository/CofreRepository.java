package com.cofre.repository;

import com.cofre.model.CofreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CofreRepository extends JpaRepository<CofreItem, Long> {
}
