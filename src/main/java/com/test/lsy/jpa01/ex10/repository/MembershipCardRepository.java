package com.test.lsy.jpa01.ex10.repository;

import com.test.lsy.jpa01.ex10.domain.MembershipCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembershipCardRepository extends JpaRepository<MembershipCard, Long> {
    @Query("select m from MembershipCard m join fetch m.owner")
    List<MembershipCard> findAllWithOwner();
}
