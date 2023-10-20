package br.alanna.rangel.proposta_service.Model;

public enum VotoType {
    APPROVE, REJECT;

    public static void main(String[] args) {
        VotoType voto = VotoType.APPROVE;

        if (voto == VotoType.APPROVE) {
            System.out.println("O voto foi aprovado.");
        } else if (voto == VotoType.REJECT) {
            System.out.println("O voto foi rejeitado.");
        }
    }
}
