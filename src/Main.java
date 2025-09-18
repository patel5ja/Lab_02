import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        Worker Jeel = new Worker("001", "Jeel", "Patel", "Ms.", 2004, 25.0);
        workers.add(Jeel);

        Worker Pranjal = new Worker("002", "Pranjal", "Pokharel", "Mr.", 2002, 26.5);
        workers.add(Pranjal);

        Worker Jigna = new Worker("003", "Jigna", "patel", "Ms.", 1983, 25.0);
        workers.add(Jigna);

        SalaryWorker Amit = new SalaryWorker("00A", "Amit", "Patel", "Ms.", 1976, 30.0, 52000.0);
        workers.add(Amit);

        SalaryWorker Abhi = new SalaryWorker("00B", "Abhi", "Patel", "Mr.", 1970, 23.0, 85000.0);
        workers.add(Abhi);

        SalaryWorker Bilbo = new SalaryWorker("00C", "Bilbo", "Baggins", "Mr.", 1988, 20.0, 96000.0);
        workers.add(Bilbo);

        int[] weeklyHours = {40, 50, 40};

        System.out.printf("\n%-10s %-15s %-15s %-15s %-15s%n", "ID", "Name", "Week 1 Pay", "Week 2 Pay", "Week 3 Pay");
        System.out.printf("=========================================================================");


        for (Worker w : workers) {
            double week1 = w.calculateWeeklyPay(40);
            double week2 = w.calculateWeeklyPay(50);
            double week3 = w.calculateWeeklyPay(40);

            System.out.printf("\n%-10s %-20s $%-14.2f $%-14.2f $%-14.2f%n", w.getIDNum(), w.getFullName(), week1, week2, week3);

        }
    }
}
