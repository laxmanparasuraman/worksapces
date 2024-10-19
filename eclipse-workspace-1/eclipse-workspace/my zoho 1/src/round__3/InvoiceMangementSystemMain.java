package round__3;

import java.util.*;

class Customer {
    private String customerId;
    private String customerName;

    public Customer(String id, String name) {
        customerId = id;
        customerName = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Item {
    private String itemName;
    private double itemPrice;

    public Item(String name, double price) {
        itemName = name;
        itemPrice = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}

class Invoice {
    private int invoiceId;
    private Customer customer;
    private List<Item> items;

    public Invoice(int id, Customer c) {
        invoiceId = id;
        customer = c;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}

class InvoiceManagementSystem {
    private List<Customer> customers;
    private List<Invoice> invoices;

    public InvoiceManagementSystem() {
        customers = new ArrayList<>();
        invoices = new ArrayList<>();
    }

    public void addCustomer(String id, String name) {
        customers.add(new Customer(id, name));
    }

    public void addInvoice(int id, String customerId) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            invoices.add(new Invoice(id, customer));
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void addItemToInvoice(int invoiceId, String itemName, double itemPrice) {
        Invoice invoice = findInvoiceById(invoiceId);
        if (invoice != null) {
            invoice.addItem(new Item(itemName, itemPrice));
        } else {
            System.out.println("Invoice not found.");
        }
    }

    public void listAllCustomers() {
        System.out.println("List of Customers:");
        for (Customer customer : customers) {
            System.out.println(customer.getCustomerId() + " - " + customer.getCustomerName());
        }
    }

    public void listAllInvoices() {
        System.out.println("List of Invoices:");
        for (Invoice invoice : invoices) {
            System.out.println("Invoice ID: " + invoice.getInvoiceId() + ", Customer: " + invoice.getCustomer().getCustomerName());
        }
    }

    public void listInvoicesOfCustomer(String customerId) {
        System.out.println("Invoices of Customer " + customerId + ":");
        for (Invoice invoice : invoices) {
            if (invoice.getCustomer().getCustomerId().equals(customerId)) {
                System.out.println("Invoice ID: " + invoice.getInvoiceId());
            }
        }
    }

    public void displayInvoiceDetails(int invoiceId) {
        Invoice invoice = findInvoiceById(invoiceId);
        if (invoice != null) {
            System.out.println("Invoice ID: " + invoice.getInvoiceId());
            System.out.println("Customer: " + invoice.getCustomer().getCustomerName());
            System.out.println("Items:");
            for (Item item : invoice.getItems()) {
                System.out.println(item.getItemName() + " - $" + item.getItemPrice());
            }
        } else {
            System.out.println("Invoice not found.");
        }
    }

    private Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private Invoice findInvoiceById(int invoiceId) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceId() == invoiceId) {
                return invoice;
            }
        }
        return null;
    }
}

public class InvoiceMangementSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManagementSystem ims = new InvoiceManagementSystem();

        while (true) {
            System.out.println("\nChoose an option:");
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
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    ims.addCustomer(customerId, customerName);
                    break;
                case 2:
                    System.out.print("Enter invoice ID: ");
                    int invoiceId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter customer ID: ");
                    String custId = scanner.nextLine();
                    ims.addInvoice(invoiceId, custId);
                    break;
                case 3:
                    System.out.print("Enter invoice ID: ");
                    int invId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double itemPrice = scanner.nextDouble();
                    ims.addItemToInvoice(invId, itemName, itemPrice);
                    break;
                case 4:
                    ims.listAllCustomers();
                    break;
                case 5:
                    ims.listAllInvoices();
                    break;
                case 6:
                    System.out.print("Enter customer ID: ");
                    String custID = scanner.nextLine();
                    ims.listInvoicesOfCustomer(custID);
                    break;
                case 7:
                    System.out.print("Enter invoice ID: ");
                    int invID = scanner.nextInt();
                    ims.displayInvoiceDetails(invID);
                    break;
                case 8:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
