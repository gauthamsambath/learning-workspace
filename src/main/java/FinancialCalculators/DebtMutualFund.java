package FinancialCalculators;

import DSAProblems.FractionAdditionAndSubtraction;

//11,539,853

//190,673,388,150


public class DebtMutualFund {

    public static void main(String[] args) {
        FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new FractionAdditionAndSubtraction();
        Double sipInvestmentAMount = 5000.0;
        double rateEveryDay = 5.07;
        double sipTimeGap = 30;
        double durationOfInvestMent = 5;
        Double finalAmount = findDebtGains(sipInvestmentAMount,rateEveryDay,sipTimeGap,durationOfInvestMent);
        Double gainInAMount = findGainInAamount(finalAmount,sipInvestmentAMount,durationOfInvestMent);
        Double gainInPercentage = findGainInPercentage(gainInAMount,sipInvestmentAMount,durationOfInvestMent);
        System.out.println("For an SIP amount of "+sipInvestmentAMount+" and rate of Everyday growth about "+rateEveryDay+"% \n" +
         "Your Final Amount = "+finalAmount+"\n"+
         "Final amount in dollars = "+finalAmount/78+"\n"+
         "Your Gained Amount = "+gainInAMount+"\n"+
         "Your Gain percentage = "+gainInPercentage+"\n\n"+
         "For a Total Investment of "+durationOfInvestMent*sipInvestmentAMount+"\n"+
         "For a Time period of "+durationOfInvestMent+" Months");
    }

    public static Double findGainInPercentage(Double gainInAMount, Double sipInvestmentAMount, double durationOfInvestMent) {
        return (gainInAMount/(sipInvestmentAMount*durationOfInvestMent))*100;
    }

    public static Double findGainInAamount(Double finalAMount, Double sipInvestmentAMount, double durationOfInvestMent) {
        return finalAMount - sipInvestmentAMount*durationOfInvestMent;
    }

    public static Double findDebtGains(Double sipInvestmentAmount, double rateEveryDay, double sipTimeGap, double durationOfInvestMent) {
        Double initialAmount = 0.0;
        Double multiplyngRateFactor = Math.pow((1+(rateEveryDay/100)),sipTimeGap);
        for (int i = 0; i < durationOfInvestMent; i++) {
            initialAmount+=sipInvestmentAmount;
            initialAmount = initialAmount*multiplyngRateFactor;
        }
        return initialAmount;
    }
}
