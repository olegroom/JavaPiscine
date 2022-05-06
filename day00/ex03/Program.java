import java.lang.*;
import java.util.Scanner;

public class Program {
    static long grades = 0;

    private static void printLine(long gradeToPrint) {
        for (int i = 0; i < gradeToPrint; i++)
            System.out.print("=");
        System.out.println(">");
    }

    private static void printAllGraph() {
        long minGradeOnWeekI;
        int i = 1;
        while (grades > 0) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            minGradeOnWeekI = grades % 10;
            printLine(minGradeOnWeekI);
            grades /= 10;
            i++;
        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int weekNumber = 1;
        while (weekNumber <= 18) {
            String str = scan.nextLine();
            if (str.equals("42"))
                break;
            if (!str.equals("Week " + weekNumber)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            String strGrade = scan.nextLine();
            Scanner gradesScan = new Scanner(strGrade);
            int minGrade = 10;
            for (int j = 0; j < 5; j++) {
                int curGrade;
                curGrade = gradesScan.nextInt();
                if (curGrade < minGrade)
                    minGrade = curGrade;
            }
            addGradeToLong(weekNumber, minGrade);
            weekNumber++;
        }
        printAllGraph();
    }

    private static void addGradeToLong(int weekNumber, int minGrade) {
        if (weekNumber == 1)
            grades += minGrade;
        else {
            int tenSqureN = 10;
            for (int i = 2; i < weekNumber; i++) {
                tenSqureN *= 10;
            }
            tenSqureN *= minGrade;
            grades += tenSqureN;
        }
    }
}