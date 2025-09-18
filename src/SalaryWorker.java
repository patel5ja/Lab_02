

public class SalaryWorker extends Worker{

    private double annualSalary;

    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int yob, double hourlyPayRate, double annualSalary) {
        super(IDNum, firstName, lastName, title, yob, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary/52.0;
    }
    @Override
    public void displayWeeklyPay(double hoursWorked){
        double weeklyPay = this.calculateWeeklyPay(hoursWorked);
        System.out.println("weekly Pay is a fraction of the yearly salary: ");
        System.out.println("annual salary: $" + annualSalary);
        System.out.println("weekly pay: $ " + weeklyPay);
    }


    @Override
    public String toString()
    {
        return this.getIDNum() + " " + this.getFirstName() + " " + this.getLastName() + " " +
                this.getTitle() + " " + this.getYOB() + " " + this.getHourlyPayRate() +
                " " + this.getAnnualSalary();
    }


    @Override
    public String toCSVDataString(){
        return super.toCSVDataString() + " " + "annual salary=" + annualSalary;

    }


    @Override
    public String toXMLDataString() {
        return "<SalaryWorker>" +
                "<IDNum>" + this.getIDNum() + "</IDNum>" +
                "<firstName>" + this.getFirstName() + "</firstName>" +
                "<lastName>" + this.getLastName() + "</lastName>" +
                "<title>" + this.getTitle() + "</title>" +
                "<YOB>" + this.getYOB() + "</YOB>" +
                "<hourlyPayRate>" + this.getHourlyPayRate() + "</hourlyPayRate>" +
                "<annualSalary>" + this.getAnnualSalary() + "</annualSalary>" +
                "</SalaryWorker>";
    }

    @Override
    public String toJSONDataString() {
        return "{" +
                "\"IDNum\":\"" + this.getIDNum() + "\"," +
                "\"firstName\":\"" + this.getFirstName() + "\"," +
                "\"lastName\":\"" + this.getLastName() + "\"," +
                "\"title\":\"" + this.getTitle() + "\"," +
                "\"YOB\":" + this.getYOB() + "," +
                "\"hourlyPayRate\":" + this.getHourlyPayRate() + "," +
                "\"annualSalary\":" + this.getAnnualSalary() +
                "}";
    }

}