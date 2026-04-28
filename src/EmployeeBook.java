public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }

        return false;
    }

    public Employee getEmployeeById(int id) {

        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public void printAllEmployees() {

        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateAverageSalary() {

        int sum = 0;
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return (double) sum / count;
    }

    public void printTaxes(String taxType) {

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            double tax = 0;

            switch (taxType) {
                case "PROPORTIONAL":
                    tax = employee.getSalary() * 0.13;
                    break;

                case "PROGRESSIVE":
                    if (employee.getSalary() <= 150) {
                        tax = employee.getSalary() * 0.13;
                    } else if (employee.getSalary() <= 350) {
                        tax = employee.getSalary() * 0.17;
                    } else {
                        tax = employee.getSalary() * 0.21;
                    }
                    break;
            }

            System.out.println(employee.getFullName() + " tax = " + tax);
        }
    }

    public void indexSalary(double percent) {

        for (Employee employee : employees) {

            if (employee == null) {
                continue;
            }

            int newSalary = (int) (employee.getSalary() *
                    (1 + percent / 100));

            employee.setSalary(newSalary);
        }
    }

    public void indexSalaryByDepartment(int department, double percent) {

        for (Employee employee : employees) {

            if (employee == null || employee.getDepartment() != department) {
                continue;
            }

            int newSalary = (int) (employee.getSalary() *
                    (1 + percent / 100));

            employee.setSalary(newSalary);
        }
    }

    public Employee findEmployeeByDepartmentAndSalaryMoreThan(
            int department,
            int salary) {

        Employee result = null;

        for (Employee employee : employees) {

            if (employee != null &&
                    employee.getDepartment() == department &&
                    employee.getSalary() > salary) {

                result = employee;
                break;
            }
        }

        return result;
    }

    public void printEmployeesWithSalaryLessThan(
            int wage,
            int employeeNumber) {

        int index = 0;
        int count = 0;

        while (index < employees.length) {

            Employee employee = employees[index];

            if (employee != null && employee.getSalary() < wage) {
                System.out.println(employee);
                count++;
            }

            if (count == employeeNumber) {
                break;
            }

            index++;
        }
    }

    public boolean containsEmployee(Employee employee) {

        for (Employee currentEmployee : employees) {

            if (currentEmployee != null &&
                    currentEmployee.equals(employee)) {

                return true;
            }
        }

        return false;
    }
}

