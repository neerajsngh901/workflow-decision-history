package com.eleserv.workflow_decision_history.dto;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record DecisionHistoryDTO(
         String decision,
         String stage,
         String userId,
         String caseId,
         Boolean stUpper,
         Boolean stLower,
         Boolean stOther,
         String remarks

) {
}
