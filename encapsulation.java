// student id: 22059189
// name: Aaron Tetteh


public class CommissionEmployee {
    // Private fields
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales; 
    private double commissionRate; 

    // Constructor with validations
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, 
                               double grossSales, double commissionRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    // Getters and setters with validations
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0.0 || commissionRate > 1.0) {
            throw new IllegalArgumentException("Commission rate must be between 0.0 and 1.0");
        }
        this.commissionRate = commissionRate;
    }

    // Method to calculate earnings
    public double earnings() {
        return grossSales * commissionRate;
    }

    // Overriding toString() to display details
    @Override
    public String toString() {
        return String.format("CommissionEmployee[firstName=%s, lastName=%s, socialSecurityNumber=%s, grossSales=%.2f, commissionRate=%.2f]", 
                firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
    }

    // Main method for testing
    public static void main(String[] args) {
        try {
            // Create a CommissionEmployee object
            CommissionEmployee employee = new CommissionEmployee("John", "Doe", "123-45-6789", 5000.0, 0.1);

            // Display the employee's details
            System.out.println("Employee details:");
            System.out.println(employee);

            // Update grossSales and commissionRate
            employee.setGrossSales(7000.0);
            employee.setCommissionRate(0.15);

            // Display updated details
            System.out.println("\nUpdated employee details:");
            System.out.println(employee);

            // Calculate and display earnings
            System.out.println("\nEmployee earnings: " + employee.earnings());

            // Test validation with invalid values
            System.out.println("\nTesting validation:");
            try {
                employee.setGrossSales(-100.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                employee.setCommissionRate(1.5);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error during initialization: " + e.getMessage());
        }
    }
}
