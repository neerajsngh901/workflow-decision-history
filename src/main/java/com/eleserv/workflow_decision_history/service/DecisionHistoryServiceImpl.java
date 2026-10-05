package com.eleserv.workflow_decision_history.service;

import com.eleserv.workflow_decision_history.dto.DecisionHistoryDTO;
import com.eleserv.workflow_decision_history.entity.DecisionHistory;
import com.eleserv.workflow_decision_history.reposistory.DecisionHistoryReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class DecisionHistoryServiceImpl implements DecisionHistoryService {
    @Autowired
    private DecisionHistoryReposistory decisionHistoryReposistory;
    @Override
    public DecisionHistory saveDecisionHistory(DecisionHistoryDTO decisionHistoryDTO) {
       if(Objects.isNull(decisionHistoryDTO)){
            throw new IllegalArgumentException("DecisionHistoryDTO cannot be null");
        }else{
           DecisionHistory decisionHistory = DecisionHistory.builder()
                   .caseId(decisionHistoryDTO.caseId())
                   .decision(decisionHistoryDTO.decision())
                   .remarks(decisionHistoryDTO.remarks())
                   .dateTime(java.time.LocalDateTime.now())
                   .build();

           System.out.println("Saving DecisionHistory: " + decisionHistory + " at " + java.time.LocalDateTime.now() + " caseId: " + decisionHistoryDTO.caseId() + " decision: " + decisionHistoryDTO.decision() + " remarks: " + decisionHistoryDTO.remarks());
           return decisionHistoryReposistory.save(decisionHistory);

       }


    }

    @Override
    public List<DecisionHistory> getDecisionHistoryByCaseId(String caseId) {
        if(StringUtils.quoteIfString(caseId) == null || caseId.isEmpty()){
            throw new IllegalArgumentException("CaseId cannot be null or empty");
        }else {
            List<DecisionHistory> decisionHistories = decisionHistoryReposistory.findHistoryByCaseId(caseId);
            if (decisionHistories.isEmpty()) {
                System.out.println("No decision history found for caseId: " + caseId);
            } else {
                System.out.println("Found " + decisionHistories.size() + " decision history records for caseId: " + caseId);
            }
            return decisionHistories;
        }

    }
}
