package com.swcat.giftapp.JpaRepo;

import java.util.Optional;

import com.swcat.giftapp.Entities.gorderAddons;

import org.springframework.data.jpa.repository.JpaRepository;

public interface gorderAddonsRepo extends JpaRepository<gorderAddons, Integer> {
    gorderAddons findByGorderId(Integer gorderId);
    boolean existsByGorderId(Integer gorderId);
    void deleteByGorderId(Integer gorderId);
}
