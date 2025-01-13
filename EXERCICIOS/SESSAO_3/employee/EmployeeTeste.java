package employee;

public class EmployeeTeste {
    public static void main(String[] args) {
        Employee employee = new Employee("Belchior", "Sapalo", 5000);
        Employee employee2 = new Employee("Agostinho", "Mendes", 8000);

        System.out.println(employee.getSalario());
        System.out.println(employee2.getSalario());
        employee.setSalario(employee.getSalario() + employee.getSalario() * (10 / 100));
        employee2.setSalario(employee2.getSalario() + employee2.getSalario() * (10 / 100));
        System.out.println(employee.getSalario());
        System.out.println(employee2.getSalario());
    }
}
