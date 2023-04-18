package domain.offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {
    Offer saveOffer(Offer offer);
    Optional<Offer> getOfferById(String id);
    List<Offer> findAllOffers();
}
