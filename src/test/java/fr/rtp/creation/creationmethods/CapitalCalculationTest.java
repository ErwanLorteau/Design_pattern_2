package fr.rtp.creation.creationmethods;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class CapitalCalculationTest {

    @Test
    void testTermLoanNoPayments() {
        Date maturity = new Date(2024, 11, 31);
        int riskRating = 1;
        double commitment = 0.0;
        Loan termLoan = new Loan(commitment, 0.00, riskRating, maturity, null);

        assert termLoan.capitalStrategy.getClass() == CapitalStrategyTermLoan.class;
    }

    @Test
    void testRevolvingCreditTermLoan() {
        Date maturity = new Date(2024, 11, 30);
        Date expiry = new Date(2020,  10, 15);
        int riskRating = 1;
        double commitment = 0.0;

        Loan revolvingCreditTermLoan  = new Loan(commitment, riskRating, maturity, expiry);

        assert revolvingCreditTermLoan.capitalStrategy.getClass() == CapitalStrategyRCTL.class;
    }

    @Test
    void testRevolvingCreditTermLoanWithOutstanding() {
        Date maturity = new Date(2024, 11, 30);
        Date expiry = new Date(2020,  10, 15);
        int riskRating = 1;
        double commitment = 0.0;
        double outstanding = 2.0;

        Loan loan = new Loan(commitment,  outstanding,  riskRating,  maturity,  expiry);

        assert loan.capitalStrategy.getClass() == CapitalStrategyRCTL.class;
    }

}
