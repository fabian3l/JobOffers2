package domain.offer;

public class OfferFacade  {

    public void findAllByOffers() {

    }
    public Offer findOfferById(String id) {
        return Offer.builder()
                .title("title")
                .offerUrl("offerurl")
                .company("companyName")
                .salary("salary")
                .build();
    }
    public Offer saveOffer(Offer offer) {
        //saved
        return offer;
    }
    public void fetchAllOffersAndSaveAllIfNotExists() {

    }
}
