import java.util.*;
public class financial_forecast {
    public static double future_value_Simplerecursive(double principal, double rate, int years, int steps){
        //if time is 0, that means you gain  no interest, just the principal
        if(years==0){
             System.out.println("Steps taken recursive approach = "+steps);
            return principal;
        }
        //Here I am considering simple interest
        steps++;
        double amount = principal*rate+future_value_Simplerecursive(principal, rate,years-1,steps);
        return amount;
    }
    public static double future_value_SimpleOptimized(double principal, double rate,int years, int steps){
        double interest=principal*rate*years;
        steps++;
        System.out.println("Steps taken optimized approach = "+steps);
        return principal+interest;
    }
    public static double future_value_Compoundrecursive(double principal, double rate, int years, int steps){
        //if time is 0, that means you gain no interest, just the principal remains
        if(years==0){
             System.out.println("Steps taken in recursive approach = "+steps);
            return principal;
        }
        //Here I am considering compound interest for growth
        steps++;
        double amount = future_value_Compoundrecursive(principal, rate, years-1,steps)* (1+rate);
        return amount;
    }
    public static double future_value_Compoundoptimized(double principal, double rate, int years, int steps){
        //using compound interest formula
        steps++;
        System.out.println("Steps taken in recursive approach = "+steps);
        return principal*Math.pow((1+rate),years);
    }

    public static void predictFutureValue(double principal, double rate, int years){
        int decision=0;
        System.out.println("Press 1 to predict recursive compound growth of your fund");
        System.out.println("Press 2 to predict Optimized compound growth of your fund");
        System.out.println("Press 3 to predict recursive Simple growth of your fund");
        System.out.println("Press 4 to predict Optimized compound growth of your fund");
        Scanner sc=new Scanner(System.in);
        decision=sc.nextInt();
        switch(decision){
            case 1:
               System.out.println("Your amount after "+years+" years "+future_value_Compoundrecursive(principal, rate, years,0));
               break;
            case 2:
               System.out.println("Your amount after "+years+" years "+future_value_Compoundoptimized(principal, rate, years,0));
               break;
            case 3:
               System.out.println("Your amount after "+years+" years "+future_value_Simplerecursive(principal, rate, years,0));
               break;
            case 4:
               System.out.println("Your amount after "+years+" years "+future_value_SimpleOptimized(principal, rate, years,0));
               break;
            default: System.out.println("oops!!! may be you have pressed a wrong key");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to our Future Finance forecasting tool");
        double principal,rate;
        int years;
        System.out.println("Enter Principal amount(Amount you want to deposit)");
        principal=sc.nextDouble();
        System.out.println("Enter Rate of interest as said by bank(Avoid % sign)");
        rate=sc.nextInt();
        rate=rate/100;
        System.out.println("Enter the time(in years) for which you want to invest");
        years=sc.nextInt();
        predictFutureValue(principal, rate, years);
    }
}
