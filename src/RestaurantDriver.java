import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is a part of Assignment 4 of FIT1051.
 *
 * This client class provides methods that can be used to simulate the processes of a Take-Away Management Portal of
 * a Restaurant.
 *
 * This is the Driver class (main client class) of the assignment that uses all the other classes in this Assignment.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public class RestaurantDriver
{

    private ArrayList<Order> customerOrders;

    private int option;

    private boolean continueProgram;

    /**
     * This default constructor initialises a RestaurantDriver object with appropriate default values.
     */
    public RestaurantDriver()
    {
        this.option = 0;
        customerOrders = new ArrayList<Order>();
        continueProgram = true;
    }

    /**
     * This non-default constructor initialises a RestaurantDriver object with the values provided by the User.
     */
    public RestaurantDriver(int option, ArrayList<Order> customerOrders, boolean continueProgram)
    {
        this.option = option;
        this.customerOrders = customerOrders;
        this.continueProgram = continueProgram;
    }

    /**
     * This method accepts customer details from the user.
     * @param customer
     */
    private void acceptCustomerDetails(Customer customer)
    {
        acceptCustomerName(customer);
        acceptCustomerAddress(customer);
        acceptCustomerNumber(customer);
    }

    /**
     * This method accepts an appropriate customer name from the user and updates the customer object accordingly.
     * @param customer
     */
    private void acceptCustomerName(Customer customer)
    {
        boolean wrongName = false;
        String customerName = "";
        int i = 0;
        while(!wrongName)
        {
            if (i > 0)
                System.out.println("\nInvalid name, please enter name again!\n");
            System.out.println("Enter Customer Name:");
            customerName = acceptInput();
            wrongName = customer.setCustomerName(customerName);
            i++;
        }
    }

    /**
     * This method accepts an appropriate customer number from the user and updates the customer object accordingly.
     * @param customer
     */
    private void acceptCustomerNumber(Customer customer)
    {
        boolean wrongNumber = false;
        String customerNumber = "";
        int i = 0;
        while(!wrongNumber)
        {
            if (i > 0)
                System.out.println("\nInvalid number, please enter number again!\n");
            System.out.println("Enter Customer Number:");
            customerNumber = acceptInput();
            wrongNumber = customer.setCustomerNumber(customerNumber);
            i++;
        }
    }

    /**
     * This method accepts an appropriate customer address from the user and updates the customer object accordingly.
     * @param customer
     */
    private void acceptCustomerAddress(Customer customer)
    {
        boolean wrongAddress = false;
        String customerAddress = "";
        int i = 0;
        while(!wrongAddress)
        {
            if (i > 0)
                System.out.println("\nInvalid address, please enter address again!\n");
            System.out.println("Enter Customer Address:");
            customerAddress = acceptInput();
            wrongAddress = customer.setCustomerAddress(customerAddress);
            i++;
        }
    }

    /**
     * This method accepts food items from the user and adds it to the order.
     * @param order
     */
    private void acceptFoodItems(Order order)
    {
        int foodOption;

        displayMenuForAddingFoodItems();

        foodOption = Integer.parseInt(acceptInput());

        switch(foodOption)
        {
            case 1:
            {
                addPizzaToOrder(order);
                acceptFoodItems(order);
                break;
            }
            case 2:
            {
                addPastaToOrder(order);
                acceptFoodItems(order);
                break;
            }
            case 3:
            {
                runMainProgram();
                break;
            }
            default:
            {
                System.out.println("Invalid option, Please try again! \n");
                acceptFoodItems(order);
                break;
            }

        }

    }

    /**
     * This method accepts input from the user and returns it.
     * @return String
     */
    private String acceptInput()
    {
        String inputString;
        Scanner input = new Scanner(System.in);
        inputString = input.nextLine();
        return inputString;
    }

    /**
     * This method accepts option from the user and updates it.
     */
    private void acceptOption()
    {
        String optionString = acceptInput().trim();
        option = Integer.parseInt(optionString);
    }

    /**
     * This method accepts details for an order and updates the order accordingly.
     */
    private void acceptOrderDetails()
    {
        Order customerOrder = new Order();
        customerOrders.add(customerOrder);
        System.out.println("Please enter customer details:");
        Customer customer = new Customer();
        acceptCustomerDetails(customer);
        customerOrder.setCustomer(customer);
        System.out.println("Adding items to "+customer.getCustomerName()+"'s order!");
        acceptFoodItems(customerOrder);
    }

    /**
     * This method adds a Pasta object that is modified according to the user to the Order object.
     * @param order
     */
    private void addPastaToOrder(Order order)
    {
        Pasta pasta = new Pasta();
        System.out.println("Topping Options:");
        pasta.displayAllToppings();
        addToppingToPasta(pasta);
        order.addFoodItem(pasta);
        System.out.println(pasta+" was added to the order.");
    }

    /**
     * This method adds a Pizza object that is modified according to the user to the Order object.
     * @param order
     */
    private void addPizzaToOrder(Order order)
    {
        Pizza pizza = new Pizza();
        System.out.println("Topping Options:");
        pizza.displayAllToppings();
        addToppingsToPizza(pizza);
        order.addFoodItem(pizza);
        System.out.println(pizza+" was added to the order.");
    }

    /**
     * This method accepts a pasta topping from the user and adds it to the Pasta object passed to it.
     * @param pasta
     */
    private void addToppingToPasta(Pasta pasta)
    {
        String toppingsString;
        System.out.println("Enter the topping you want (you can only choose one or enter blank for no topping):");
        toppingsString = acceptInput();
        Pasta.PastaTopping pastaTopping = pasta.getPastaToppingFromString(toppingsString);
        if( pastaTopping != null)
                pasta.setPastaTopping(pastaTopping);
    }

    /**
     * This method accepts pizza toppings from the user and adds it to the Pizza object passed to it.
     * @param pizza
     */
    private void addToppingsToPizza(Pizza pizza)
    {
        String toppingsString;
        System.out.println("Enter toppings you want separated by a comma (you can choose more than one or enter blank for no toppings):");
        toppingsString = acceptInput();
        String[] stringToppingsList = toppingsString.split(",");
        for (String topping : stringToppingsList)
        {
            topping = topping.trim();
            Pizza.PizzaTopping pizzaTopping = pizza.getPizzaToppingFromString(topping);
            if( pizzaTopping != null)
            {
                pizza.addPizzaTopping(pizzaTopping);
            }
        }
    }

    /**
     * The method displays all the orders currently in Restaurant Driver.
     */
    private void displayAllOrders()
    {
        if (customerOrders.isEmpty())
        {
            displayNoOrdersMessage();
            runMainProgram();
        }
        else
        {
            System.out.println("\nYou have selected to display all Orders in the System");
            System.out.println("Order Details:");
            System.out.println("==========================================");
            int i = 1;
            for (Order order : customerOrders) {
                System.out.println("\nOrder " + i + ":");
                System.out.println(order);
                i++;
            }

            System.out.println("==========================================");
        }
    }

    /**
     * This method displays an exit message once the program is going to shut down.
     */
    private void displayExitMessage()
    {
        System.out.println("Shutting Down System. Goodbye!");
    }

    /**
     * This method displays a Menu that shows what food item can be added to the order.
     */
    private void displayMenuForAddingFoodItems()
    {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Add a Pizza to the Order");
        System.out.println("2. Add a Pasta to the Order");
        System.out.println("3. Back to Main Menu");
        System.out.println("Please enter your choice (1-3):");
    }

    /**
     * This method displays no order message if there are no orders currently in the Restaurant Driver.
     */
    private void displayNoOrdersMessage()
    {
        System.out.println("There are no orders yet, Please place an order first!\n");
    }

    /**
     * This method displays the order details of the order that is going to be delivered.
     */
    private void displayOrderToBeDelivered()
    {
        if (customerOrders.isEmpty())
        {
            displayNoOrdersMessage();
            runMainProgram();
        }
        else
        {
            Order order = customerOrders.remove(0);

            Customer customer = order.getCustomer();
            System.out.println("\nYou have selected to deliver an order");
            System.out.println("Delivering "+customer.getCustomerName()+"'s order to "+customer.getCustomerAddress());
            System.out.println("Order Details:");
            System.out.println("==========================================");

            System.out.println(order);
            System.out.println("There are now "+customerOrders.size()+" order(s) pending to be delivered.");


            System.out.println("==========================================");
        }

    }

    /**
     * This method displays the main program menu with four options to highlight the restaurant processes available.
     */
    private void displayProgramMenu()
    {
        System.out.println("Welcome to the Take-Away Management Portal");
        System.out.println("==========================================");
        System.out.println("\nPlease select an option:");
        System.out.println("1. Enter Order Details");
        System.out.println("2. Deliver an Order");
        System.out.println("3. Display all items and customer details in the Order");
        System.out.println("4. Exit");
        System.out.println("Please enter your choice (1-4):");
    }

    /**
     * This accessor method returns the boolean value of continueProgram variable of the RestaurantDriver object.
     * @return boolean
     */
    public boolean getContinueProgram()
    {
        return continueProgram;
    }

    /**
     * This accessor method returns the list of orders of the Restaurant Driver object.
     * @return ArrayList of Orders
     */
    public ArrayList<Order> getCustomerOrders()
    {
        return customerOrders;
    }

    /**
     * This accessor method returns the value of variable option of the RestaurantDriver object.
     * @return int
     */
    public int getOption()
    {
        return option;
    }

    /**
     * This method executes a restaurant process according to the option chosen by the user. 
     */
    private void performActionBasedOnChosenOption()
    {
        switch (option)
        {
            case 1:
            {
                acceptOrderDetails();
                runMainProgram();
                break;
            }
            case 2:
            {
                displayOrderToBeDelivered();
                runMainProgram();
                break;
            }
            case 3:
            {
                displayAllOrders();
                runMainProgram();
                break;
            }
            case 4:
            {
                this.setContinueProgram(false);
                displayExitMessage();
                break;
            }
            default:
            {
                System.out.println("Invalid Option, Please Try Again!\n");
                runMainProgram();
                break;
            }
        }
    }

    /**
     * This method is the gateway to simulating the processes of a Take-Away Management Portal of
     * a Restaurant, that is, this method starts and runs the main program.
     */
    public void runMainProgram()
    {
        while (continueProgram) {
            displayProgramMenu();
            acceptOption();
            performActionBasedOnChosenOption();
        }
    }

    /**
     * This mutator method sets the continueProgram variable of the RestaurantDriver object
     * with the boolean value provided by the user.
     */
    public void setContinueProgram(boolean continueProgram)
    {
        this.continueProgram = continueProgram;
    }

    /**
     * This mutator method sets the list of customer orders of the RestaurantDriver object
     * with the list of orders provided by the user.
     */
    public void setCustomerOrders(ArrayList<Order> customerOrders)
    {
        this.customerOrders = customerOrders;
    }

    /**
     * This mutator method sets the option variable of the RestaurantDriver object
     * with the integer value provided by the user.
     */
    public void setOption(int option)
    {
        this.option = option;
    }

    /**
     * This method creates a RestaurantDriver object and runs the main program method of the Driver
     * to start the processes of a Take-Away Management Portal Program.
     * @param args
     */
    public static void main(String[] args)
    {
        RestaurantDriver restaurantDriver = new RestaurantDriver();
        restaurantDriver.runMainProgram();
    }
}