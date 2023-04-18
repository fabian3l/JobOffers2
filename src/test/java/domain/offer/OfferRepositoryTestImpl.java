package domain.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class OfferRepositoryTestImpl implements OfferRepository{

    private final Map<String, Offer> offerMap = new ConcurrentHashMap<>();
    @Override
    public Offer saveOffer(Offer offer) {
        offerMap.put(offer.id(), offer);
        return offer;
    }

    @Override
    public Optional<Offer> getOfferById(String id) {
        Optional<Offer> findedOffer = offerMap.values()
                .stream()
                .filter(offer -> offer.id().equals(id))
                .findFirst();
        return findedOffer;
    }

    @Override
    public List<Offer> findAllOffers() {
        List<Offer> allOffers = new ArrayList<>();
        for (String id : offerMap.keySet()) {
            allOffers.add(offerMap.get(id));
        }
        return allOffers;
    }
}
