package domain.offer;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferFacade  {

    OfferRepository offerRepository;

    public List<Offer> findAllByOffers() {
        List<Offer> offerList = offerRepository.findAllOffers();
        return offerList;
    }
    public Offer findOfferById(String id) {
        Offer offer = offerRepository.getOfferById(id).orElseThrow(() -> new RuntimeException("not found"));
        return offer;
    }
    public Offer saveOffer(Offer offer) {
        offerRepository.saveOffer(offer);
        return offer;
    }
    public void fetchAllOffersAndSaveAllIfNotExists() {

    }
}
