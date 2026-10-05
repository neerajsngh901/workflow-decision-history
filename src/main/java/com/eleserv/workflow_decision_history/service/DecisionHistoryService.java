package com.eleserv.workflow_decision_history.service;

import com.eleserv.workflow_decision_history.dto.DecisionHistoryDTO;
import com.eleserv.workflow_decision_history.entity.DecisionHistory;

import java.util.List;

public interface DecisionHistoryService {
    DecisionHistory saveDecisionHistory(DecisionHistoryDTO decisionHistoryDTO);
    List<DecisionHistory> getDecisionHistoryByCaseId(String caseId);
}
