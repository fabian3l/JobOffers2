package domain.offer;

import lombok.Builder;

@Builder
public record Offer (
        String id,
        String title,
        String company,
        String salary,
        String offerUrl
) {
}
