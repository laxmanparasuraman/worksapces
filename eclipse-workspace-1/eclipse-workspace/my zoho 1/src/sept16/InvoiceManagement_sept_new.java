package sept16;

import java.util.Scanner;

//import round__3.Customer;
//import round__3.Invoice;

//public class lk {
//
//}
class Customer{
    private String name;
    private int customerId;

    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }
}

class Invoice {
    private int invoiceId;
    private int customerId;
    private String[] items;
    private double[] itemPrices;
    private int itemCount;

    public Invoice(int invoiceId, int customerId, int maxItems) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.items = new String[maxItems];
        this.itemPrices = new double[maxItems];
        this.itemCount = 0;
    }
public int getInvoiceId() {
	return invoiceId;
}
public int getCustomerId() {
	return customerId;
}
    public void addItem(String item, double price) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemPrices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Invoice is full. Cannot add more items.");
        }
    }

    public void displayDetails(Customer[] customers) {
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Customer Name: " + getCustomerName(customers));
        System.out.println("Items:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i] + ": $" + itemPrices[i]);
        }
        System.out.println("Total Amount: $" + calculateTotal());
    }

    private String getCustomerName(Customer[] customers) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer.getName();
            }
        }
        return "Customer not found";
    }

    private double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }
}

public class InvoiceManagement_sept_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Customer[] customers = new Customer[100];
        Invoice[] invoices = new Invoice[100];
        int customerCount = 0;
        int invoiceCount = 0;

        while (true) {
            System.out.println("\nInvoice Management System");
            System.out.println("1. Add a customer");
            System.out.println("2. Add an invoice");
            System.out.println("3. Add items to an invoice");
            System.out.println("4. List all customers");
            System.out.println("5. List all invoices");
            System.out.println("6. List all invoices of a customer");
            System.out.println("7. Display the full details of an invoice");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    customers[customerCount] = new Customer(customerName, customerCount + 1);
                    customerCount++;
                    break;

                case 2:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    invoices[invoiceCount] = new Invoice(invoiceCount + 1, customerId, 10);
                    invoiceCount++;
                    break;

                case 3:
                    System.out.print("Enter invoice ID: ");
                    int invoiceId = scanner.nextInt();
                    Invoice selectedInvoice = findInvoice(invoiceId, invoices, invoiceCount);

                    if (selectedInvoice != null) {
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter item price: ");
                        double itemPrice = scanner.nextDouble();
                        selectedInvoice.addItem(itemName, itemPrice);
                    } else {
                        System.out.println("Invoice not found.");
                    }
                    break;

                case 4:
                    System.out.println("List of Customers:");
                    for (int i = 0; i < customerCount; i++) {
                        System.out.println(customers[i].getCustomerId() + ". " + customers[i].getName());
                    }
                    break;

                case 5:
                    System.out.println("List of Invoices:");
                    for (int i = 0; i < invoiceCount; i++) {
                        System.out.println("Invoice ID: " + invoices[i].getInvoiceId() +
                                ", Customer ID: " + invoices[i].getCustomerId());
                    }
                    break;

                case 6:
                    System.out.print("Enter customer ID: ");
                    int customerToFind = scanner.nextInt();
                    System.out.println("Invoices for Customer " + customerToFind + ":");
                    for (int i = 0; i < invoiceCount; i++) {
                        if (invoices[i].getCustomerId() == customerToFind) {
                            System.out.println("Invoice ID: " + invoices[i].getInvoiceId());
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter invoice ID: ");
                    int invoiceToDisplay = scanner.nextInt();
                    Invoice invoice = findInvoice(invoiceToDisplay, invoices, invoiceCount);
                    if (invoice != null) {
                        invoice.displayDetails(customers);
                    } else {
                        System.out.println("Invoice not found.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Invoice findInvoice(int invoiceId, Invoice[] invoices, int invoiceCount) {
        for (int i = 0; i < invoiceCount; i++) {
            if (invoices[i].getInvoiceId() == invoiceId) {
                return invoices[i];
            }
        }
        return null;
    }
}
