package FinancialCalculators;

/**
 * The type Emi duration calculator.
 */
public class EmiDurationCalculator {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        double principleAmount = 2500000;
        double rateOfInterest = 8;
        double extraAmountToBase = 16000;
        double constantAmount = 50000;
        System.out.println("Regular OD with baseAmountConstant and varying interest");
        OverDraft overDraft1 = findNumberOfMonthsToComplete(principleAmount, rateOfInterest, extraAmountToBase);
        System.out.println("\n Your OD loan of base amount = " + principleAmount +
                "\n can be finished in a time span of " + overDraft1.getMonthCount() + " months" +
                "\n that is = "+ overDraft1.getMonthCount() / 12 +" years and "+overDraft1.getMonthCount()%12+" months"+
                "\n if you are willing to add an extra amount of " + extraAmountToBase + " rupees each month \n" +
                " with total extra amount paid = " + overDraft1.getExtraAmount() +
                "\n and percentage of that extra amount is = " + overDraft1.getExtraAmountPercentage());

        System.out.println("\n OD with a constant Base Amount every month");
        OverDraft overDraft2 = findOverdraftWithConstantAmountPaidEveryMonth(principleAmount,rateOfInterest,constantAmount);
        System.out.println("\n Your OD loan of base amount = " + principleAmount +
                "\n can be finished in a time span of " + overDraft2.getMonthCount() + " months" +
                "\n that is = "+ overDraft2.getMonthCount() / 12 +" years and "+overDraft2.getMonthCount()%12+" months"+
                "\n if you are willing to pay a constant amount of " + constantAmount + " rupees each month \n" +
                " with total extra amount paid = " + overDraft2.getExtraAmount() +
                "\n and percentage of that extra amount is = " + overDraft2.getExtraAmountPercentage());

    }

    private static OverDraft findOverdraftWithConstantAmountPaidEveryMonth(double principleAmount, double rateOfInterest, double constantAmount) {
        double principle = principleAmount;
        int monthCounter = 0;
        double totalAmountPaidOverall = 0;
        System.out.println("\nMonth, Amount to Base, Interest paid");
        while (principle > 0) {
            double interest = principle * (rateOfInterest / 1200);
            principle = principle + interest;
            monthCounter++;
            principle = principle - constantAmount;
            totalAmountPaidOverall+=constantAmount;
            System.out.println(monthCounter+", "+(constantAmount - interest)+", "+interest);
        }
        return new OverDraft(monthCounter,totalAmountPaidOverall,totalAmountPaidOverall - principleAmount);
    }

    private static OverDraft findNumberOfMonthsToComplete(double principleAmount, double rateOfInterest, double extraAmountToBase) {
        int monthCounter = 0;
        double totalAmountPaidOverall = 0;
        double principle = principleAmount;
        double amountForCurrentMonth;
        System.out.println("Month, Current Month Total, Interest paid");
        while (principle > 0) {
            amountForCurrentMonth = principle * (rateOfInterest / 1200) + extraAmountToBase;
            principle = principle - extraAmountToBase;
            totalAmountPaidOverall += amountForCurrentMonth;
            monthCounter++;
            System.out.println(monthCounter+", "+amountForCurrentMonth+", "+(amountForCurrentMonth-extraAmountToBase));
        }
        OverDraft overDraft = new OverDraft(monthCounter, totalAmountPaidOverall, totalAmountPaidOverall - principleAmount);
        return overDraft;
    }
}

/**
 * The type Over draft.
 */
class OverDraft {
    private int monthCount;
    private double totalOverallAmountPaid;
    private double extraAmount;

    /**
     * Instantiates a new Over draft.
     *
     * @param monthCount             the month count
     * @param totalOverallAmountPaid the total overall amount paid
     * @param extraAmount            the extra amount
     */
    public OverDraft(int monthCount, double totalOverallAmountPaid, double extraAmount) {
        this.monthCount = monthCount;
        this.totalOverallAmountPaid = totalOverallAmountPaid;
        this.extraAmount = extraAmount;
    }

    /**
     * Gets month count.
     *
     * @return the month count
     */
    public int getMonthCount() {
        return monthCount;
    }

    /**
     * Sets month count.
     *
     * @param monthCount the month count
     */
    public void setMonthCount(int monthCount) {
        this.monthCount = monthCount;
    }

    /**
     * Gets total overall amount paid.
     *
     * @return the total overall amount paid
     */
    public double getTotalOverallAmountPaid() {
        return totalOverallAmountPaid;
    }

    /**
     * Sets total overall amount paid.
     *
     * @param totalOverallAmountPaid the total overall amount paid
     */
    public void setTotalOverallAmountPaid(double totalOverallAmountPaid) {
        this.totalOverallAmountPaid = totalOverallAmountPaid;
    }

    /**
     * Gets extra amount.
     *
     * @return the extra amount
     */
    public double getExtraAmount() {
        return extraAmount;
    }

    /**
     * Sets extra amount.
     *
     * @param extraAmount the extra amount
     */
    public void setExtraAmount(double extraAmount) {
        this.extraAmount = extraAmount;
    }

    /**
     * Gets extra amount percentage.
     *
     * @return the extra amount percentage
     */
    public double getExtraAmountPercentage() {
        double principle = totalOverallAmountPaid - extraAmount;
        return (extraAmount / principle) * 100;
    }
}
