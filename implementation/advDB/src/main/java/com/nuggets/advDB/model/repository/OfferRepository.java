package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Offer;
import com.nuggets.advDB.model.OfferId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, OfferId> {
}