package domain.offer;

public class OfferFacadeConfiguration {
    OfferFacade createForTest(OfferRepository offerRepository) {
        return new OfferFacade(offerRepository);
    }
}
