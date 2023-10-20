package br.alanna.rangel.proposta_service.Model;

import jakarta.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "proposal_id", nullable = false)
    private Long proposalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "voto_type", nullable = false)
    private VotoType votoType;

    public Vote() {

    }

    public Vote(String employeeId, Long proposalId, VotoType votoType) {
        this.employeeId = employeeId;
        this.proposalId = proposalId;
        this.votoType = votoType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public VotoType getVotoType() {
        return votoType;
    }

    public void setVotoType(VotoType votoType) {
        this.votoType = votoType;
    }
}
