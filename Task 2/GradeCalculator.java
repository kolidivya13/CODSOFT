import java.util.Scanner;
public class GradeCalculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subject :");
        if(!sc.hasNextInt()){
            System.out.println("Please enter the valid integer......");
            System.out.println("Enter the number of subject :");
            sc.next();
        }
        int totalSubject=sc.nextInt();
        if(totalSubject<0){
            System.out.println("Number of subject must be greater than zero");
        }
        double[] subjectMark=new double[totalSubject];
        double totalMark=0;
        for(int i=0;i < totalSubject; i++){
          
                System.out.print("Enter the mark obtained in the subject " + (i+1) +" (out of 100) :");
                if(sc.hasNextInt()){
                    int inputMark=sc.nextInt();
                    if(inputMark>=0 && inputMark<=100){
                        subjectMark[i]=inputMark;
                        totalMark += inputMark;
                    }
                    else{
                        System.out.println("Invalid Entry! Marks betweeen the 0 and 100");
                    }
                }
                else{
                    System.out.println("Invalid Entry! Please enter the double value");
                }
            
        }
        double averagePercentage=totalMark/totalSubject;
        char grade;
        if(averagePercentage>=90){
            grade= 'A';
        }
        else if(averagePercentage>=80){
            grade= 'B';
        }
        else if(averagePercentage>=70){
            grade= 'C';
        }
        else if(averagePercentage>=60){
            grade= 'D';
        }
        else if(averagePercentage>=50){
            grade= 'E';
        }
        else{
            grade = 'F';
        }
        System.out.println("\n======================================");
        System.out.println("             FINAL REPORT             ");
        System.out.println("======================================");
        System.out.println("Total Marks Obtained :"+totalMark + "/" +(totalSubject*100));
        System.out.println("Average Percentage:"+averagePercentage);
        System.out.println("Assigned Final Grade:"+grade);
        
    }
}
