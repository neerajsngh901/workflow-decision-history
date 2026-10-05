package com.eleserv.workflow_decision_history.reposistory;

import com.eleserv.workflow_decision_history.entity.DecisionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecisionHistoryReposistory extends JpaRepository<DecisionHistory, Long>, JpaSpecificationExecutor<DecisionHistory> {
    List<DecisionHistory> findHistoryByCaseId(String caseId);
}
