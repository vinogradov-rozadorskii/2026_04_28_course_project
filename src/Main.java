//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        book.addEmployee(new Employee("Ivan Ivanov", 1, 100));
        book.addEmployee(new Employee("Petr Petrov", 2, 200));
        book.addEmployee(new Employee("Anna Sidorova", 3, 400));

        book.printAllEmployees();

        System.out.println("Average salary = " +
                book.calculateAverageSalary());

        book.printTaxes("PROPORTIONAL");

        book.indexSalary(10);

        System.out.println("After indexation:");
        book.printAllEmployees();

        book.indexSalaryByDepartment(2, 10);

        System.out.println("After department indexation:");
        book.printAllEmployees();

        System.out.println(
                book.findEmployeeByDepartmentAndSalaryMoreThan(3, 300)
        );

        book.printEmployeesWithSalaryLessThan(300, 2);

        System.out.println(
                book.containsEmployee(new Employee("Test Test", 5, 220))
        );
    }
}