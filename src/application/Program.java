package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main( String[] args ) throws ParseException {

        Worker employee = new Worker();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter worker data: ");

        System.out.print("Enter department's name: ");
        employee.setDepartment(new Department(sc.nextLine()));

        System.out.print("Employee name: ");
        sc.next();
        employee.setName(sc.nextLine());


        System.out.print("Enter employee level: ");
        employee.setLevel(WorkerLevel.valueOf(sc.next()));

        System.out.print("Enter employee's base salary: ");
        employee.setBaseSalary(sc.nextDouble());

        System.out.print("How many contracts you'd like to register ? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i ++){
            System.out.printf("Registering contract [%d/%d]...\n", i+1, n);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            HourContract contract = new HourContract();

            System.out.print("Date (DD/MM/YYYY): ");
            contract.setDate(sdf.parse(sc.next()));

            System.out.print("Value per hour($): ");
            contract.setValuePerHour(sc.nextDouble());

            System.out.print("Duration (hours): ");
            contract.setHours(sc.nextInt());

            employee.addContract(contract);

        }


        System.out.print("Enter the month and year to calculate the income (MM/YYYY): ");
        String monthYear = sc.next();
        String[] dateRequired = monthYear.split("/");

        System.out.println("Name: "+ employee.getName());
        System.out.println("Department: "+ (employee.getDepartment()).getName());
        System.out.println(
                "Income for "
                + monthYear
                + ": "
                + employee.income(Integer.parseInt(dateRequired[0]), Integer.parseInt(dateRequired[1]))
        );

        sc.close();
    }
}
