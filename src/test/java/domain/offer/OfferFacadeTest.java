package domain.offer;

import domain.loginandregister.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OfferFacadeTest {
    private final OfferRepository offerRepository = new OfferRepositoryTestImpl();
    @Test
    public void should_return_correct_offer_by_id() {
        //given
        String id = UUID.randomUUID().toString();
        Offer offer = Offer.builder()
                .id(id)
                .offerUrl("url")
                .title("title")
                .salary("500")
                .company("company")
                .build();
        OfferFacade offerFacade = new OfferFacadeConfiguration().createForTest(offerRepository);
        offerFacade.saveOffer(offer);
        //when
        Offer findedOffer = offerFacade.findOfferById(id);
        //then
        Offer expectedOffer = Offer.builder()
                .id(id)
                .offerUrl("url")
                .title("title")
                .salary("500")
                .company("company")
                .build();
        assertThat(findedOffer).isEqualTo(expectedOffer);
    }
    @Test
    public void should_return_correct_offer_list() {
        //given
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();
        Offer offer1 = Offer.builder()
                .id(id1)
                .offerUrl("url")
                .title("title1")
                .salary("500")
                .company("company")
                .build();
        Offer offer2 = Offer.builder()
                .id(id2)
                .offerUrl("url")
                .title("title2")
                .salary("500")
                .company("company")
                .build();
        Offer offer3 = Offer.builder()
                .id(id3)
                .offerUrl("url")
                .title("title3")
                .salary("500")
                .company("company")
                .build();
        OfferFacade offerFacade = new OfferFacadeConfiguration().createForTest(offerRepository);
        offerFacade.saveOffer(offer1);
        offerFacade.saveOffer(offer2);
        offerFacade.saveOffer(offer3);
        //when
        List<Offer> allByOffers = offerFacade.findAllByOffers();
        //then
        Offer expectedOffer1 = Offer.builder()
                .id(id1)
                .offerUrl("url")
                .title("title1")
                .salary("500")
                .company("company")
                .build();
        Offer expectedOffer2 = Offer.builder()
                .id(id2)
                .offerUrl("url")
                .title("title2")
                .salary("500")
                .company("company")
                .build();
        Offer expectedOffer3 = Offer.builder()
                .id(id3)
                .offerUrl("url")
                .title("title3")
                .salary("500")
                .company("company")
                .build();
        List<Offer> expectedList = new ArrayList<>();
        expectedList.add(expectedOffer1);
        expectedList.add(expectedOffer2);
        expectedList.add(expectedOffer3);
        assertThat(allByOffers.get(1)).isEqualTo(expectedList.get(0));
    }
    @Test
    public void should_throw_exception_when_offer_not_found() {
        String id = UUID.randomUUID().toString();
        Offer offer = Offer.builder()
                .id(id)
                .offerUrl("url")
                .title("title")
                .salary("500")
                .company("company")
                .build();
        OfferFacade offerFacade = new OfferFacadeConfiguration().createForTest(offerRepository);
        offerFacade.saveOffer(offer);
        //when
        //then
        assertThrows(RuntimeException.class, () -> offerFacade.findOfferById("wrongId"), "not found");
    }

}