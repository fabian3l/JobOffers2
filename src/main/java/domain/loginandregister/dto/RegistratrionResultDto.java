package domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record RegistratrionResultDto(
        String id,
        Boolean isCreated,
        String username) {
}
