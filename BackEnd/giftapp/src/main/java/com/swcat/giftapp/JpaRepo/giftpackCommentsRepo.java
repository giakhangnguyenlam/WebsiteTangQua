package com.swcat.giftapp.JpaRepo;

import java.util.Optional;

import com.swcat.giftapp.Entities.giftpackComments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface giftpackCommentsRepo extends JpaRepository<giftpackComments, Integer> {
    giftpackComments findByGiftpackId(Integer giftpackId);
}
