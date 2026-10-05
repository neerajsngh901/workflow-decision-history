package com.eleserv.workflow_decision_history.controller;

import com.eleserv.workflow_decision_history.dto.DecisionHistoryDTO;
import com.eleserv.workflow_decision_history.entity.DecisionHistory;
import com.eleserv.workflow_decision_history.service.DecisionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DecisionHistoryController {
    private final DecisionHistoryService decisionHistoryService;

    @QueryMapping
    public List<DecisionHistory> getDecisionHistory(
            @Argument String caseId
            ) {
        return decisionHistoryService.getDecisionHistoryByCaseId(caseId);
    }

    @MutationMapping
    public DecisionHistory processDecisionHistory(
            @Argument String caseId,
            @Argument String decision,
            @Argument String remarks,
            @Argument String userId
    ) {
        DecisionHistoryDTO decisionHistory = DecisionHistoryDTO.builder()
                .caseId(caseId)
                .decision(decision)
                .remarks(remarks)
                .userId(userId)
                .build();
        return decisionHistoryService.saveDecisionHistory(decisionHistory);
    }
}
