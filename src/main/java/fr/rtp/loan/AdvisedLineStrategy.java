package fr.rtp.loan;

import java.util.Date;

public class AdvisedLineStrategy extends CapitalStrategy {
    public AdvisedLineStrategy(double commitment, double outstanding, Date maturity, Date expiry, Date start, int riskRating) {
        super(commitment, outstanding, maturity, expiry, start, riskRating);
    }

    double capital(Loan loan) {
        return (outstandingRiskAmount() * duration(loan) * riskFactor())
                + (unusedRiskAmount() * duration(loan) * unusedRiskFactor());
    }

    double duration(Loan loan) {
        return this.yearsTo(this.getExpiry());
    }
}
