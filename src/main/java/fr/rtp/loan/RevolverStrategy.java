package fr.rtp.loan;

import java.util.Date;

public class RevolverStrategy extends CapitalStrategy {
    public RevolverStrategy(double commitment, double outstanding, Date maturity, Date expiry, Date start, int riskRating) {
        super(commitment, outstanding, maturity, expiry, start, riskRating);
    }

    double capital(Loan loan) {
        return getCommitment() * getUnusedPercentage() * duration(loan) * riskFactor();
    }

    double duration(Loan loan) {
        return this.yearsTo(this.getExpiry());
    }
}