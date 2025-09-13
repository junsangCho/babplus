package org.example.babplus.ticketWallet.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.babplus.ticketWallet.infrastructure.persistence.projection.TicketWalletInfo;

import java.util.List;

@Getter
@ToString
@Builder
public class GetTicketWalletsResponse {
    @Schema(description = "식권아이디")
    private final Long id;

    @Schema(description = "결제아이디")
    private final Long paymentId;

    @Schema(description = "식권 갯수")
    private final int totalAmount;

    @Schema(description = "식권 사용갯수")
    private final int usedAmount;


    public static List<GetTicketWalletsResponse> of(List<TicketWalletInfo> ticketWalletInfos) {
        return ticketWalletInfos.stream()
                .map(GetTicketWalletsResponse::of)
                .toList();
    }

    public static GetTicketWalletsResponse of(TicketWalletInfo ticketWalletInfo) {
        return GetTicketWalletsResponse.builder()
                .id(ticketWalletInfo.getId())
                .paymentId(ticketWalletInfo.getPaymentId())
                .totalAmount(ticketWalletInfo.getTotalAmount())
                .usedAmount(ticketWalletInfo.getUsedAmount())
                .build();
    }
}
