public class Worker extends Person {

    private double hourlyPayRate;

    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40.0);
        double overtimeHours = Math.max(hoursWorked - 40.0, 0);
        return (regularHours * hourlyPayRate) + (overtimeHours * hourlyPayRate * 1.5);
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(hoursWorked, 40.0);
        double overtimeHours = Math.max(hoursWorked - 40.0, 0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%n",
                "Regular Hours", "Overtime Hours", "Regular Pay", "Overtime Pay", "Total Pay");
        System.out.println("=========================================================================");
        System.out.printf("%-15.2f%-15.2f$%-14.2f$%-14.2f$%-14.2f%n", regularHours, overtimeHours, regularPay, overtimePay, totalPay);

    }


    @Override
    public String toString() {
        return super.toString() + "worker{" +
                "hourlyRate=" + hourlyPayRate +
                '}';
    }

    @Override
    public String toCSVDataString() {
        return super.toCSVDataString() + "," + hourlyPayRate;
    }


    @Override
    public String toXMLDataString() {
        return "<Worker>" +
                "<IDNum>" + this.getIDNum() + "</IDNum>" +
                "<firstName>" + this.getFirstName() + "</firstName>" +
                "<lastName>" + this.getLastName() + "</lastName>" +
                "<title>" + this.getTitle() + "</title>" +
                "<YOB>" + this.getYOB() + "</YOB>" +
                "<hourlyPayRate>" + this.getHourlyPayRate() + "</hourlyPayRate>" +
                "</Worker>";
    }

    @Override
    public String toJSONDataString() {
        return "{" +
                "\"IDNum\":\"" + this.getIDNum() + "\"," +
                "\"firstName\":\"" + this.getFirstName() + "\"," +
                "\"lastName\":\"" + this.getLastName() + "\"," +
                "\"title\":\"" + this.getTitle() + "\"," +
                "\"YOB\":" + this.getYOB() + "," +
                "\"hourlyPayRate\":" + this.getHourlyPayRate() +
                "}";
    }


}