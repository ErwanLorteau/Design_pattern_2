package fr.rtp.loan;

import java.util.Date;

public abstract class CapitalStrategy {
    private final double commitment;
    private final int riskRating;
    private final double outstanding;
    private final Date maturity;
    private final Date expiry;
    private final Date start;
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;
    private Date today;

    public CapitalStrategy(double commitment, double outstanding, Date maturity, Date expiry, Date start, int riskRating) {
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.outstanding = outstanding;
        this.maturity = maturity;
        this.expiry = expiry;
        this.start = start;
    }
     protected double yearsTo(Date endDate) {
        //*
        Date beginDate = (today == null ? getStart() : today);
        return ((double) (endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }

    protected double getCommitment() {
        return commitment;
    }

    protected int getRiskRating() {
        return riskRating;
    }

    protected double getOutstanding() {
        return outstanding;
    }

    protected Date getMaturity() {
        return maturity;
    }

    protected Date getExpiry() {
        return expiry;
    }

    protected Date getStart() {
        return start;
    }

    double unusedRiskAmount() {
        return (getCommitment() - getOutstanding());
    }

    double outstandingRiskAmount() {
        return getOutstanding();
    }

    double riskFactor() {
        return RiskFactor.getFactors().forRating(getRiskRating());
    }

    double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(getRiskRating());
    }

    double getUnusedPercentage() {
        return 0.05;
    }

   abstract double capital(Loan loan) ;

    abstract double duration(Loan loan) ;

}


