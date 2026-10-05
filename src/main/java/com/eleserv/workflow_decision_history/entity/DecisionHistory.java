package com.eleserv.workflow_decision_history.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "decision_history", indexes = {
        @Index(name = "idx_case_id", columnList = "caseId")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DecisionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long decisionId;

    @Column(nullable = false, length = 100)
    private String decision;


    @Column(length = 100)
    private String userId;

    @Column(length = 30)
    private String caseId;


    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(nullable = false)
    private LocalDateTime dateTime;
}
