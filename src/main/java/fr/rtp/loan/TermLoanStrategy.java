package fr.rtp.loan;

import java.util.Date;

public class TermLoanStrategy extends CapitalStrategy {
    public TermLoanStrategy(double commitment, double outstanding, Date maturity, Date start, int riskRating) {
        super(commitment, outstanding, maturity, null, start, riskRating);
    }

    double capital(Loan loan) {
        return getCommitment() * duration(loan) * riskFactor();
    }

    double duration(Loan loan) {
            return loan.weightedAverageDuration();
    }
}