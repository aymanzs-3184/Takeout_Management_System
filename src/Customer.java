/**
 * This class is a part of Assignment 4 of FIT1051.
 * 
 * This server class stores the information related to a customer and provides methods to access and modify its information.
 * It is used by Order class and Restaurant Driver class.
 * 
 * @author Ayman Z.S
 * @version 1.0
 */
public class Customer
{
    private String customerName;

    private String customerNumber;

    private String customerAddress;

    /**
     * This default constructor initialises a Customer object with appropriate default values.
     */
    public Customer()
    {
        customerName = "Unknown Customer";
        customerNumber = "0000000000";
        customerAddress = "Unknown Address";
    }

    /**
     * This non-default constructor initialises a Customer object with only the correct values 
     * out of the values provided by the User.
     */
    public Customer(String customerName, String customerNumber, String deliveryAddress)
    {
        this.setCustomerName(customerName);
        this.setCustomerNumber(customerNumber);
        this.setCustomerAddress(deliveryAddress);
    }

    /**
     * This accessor method returns customer address of the Customer object.
     * @return String
     */
    public String getCustomerAddress()
    {
        return customerAddress;
    }

    /**
     * This accessor method returns customer name of the Customer object.
     * @return String
     */
    public String getCustomerName()
    {
        return customerName;
    }

    /**
     * This accessor method returns customer number of the Customer object.
     * @return String
     */
    public String getCustomerNumber()
    {
        return customerNumber;
    }

    /**
     * This mutator method sets the customer address of the Customer object with the value provided by the user.
     * Returns true if the value provided is appropriate.
     * Returns false otherwise.
     * @return boolean
     */
    public boolean setCustomerAddress(String deliveryAddress)
    {
        if (deliveryAddress.length() > 0 && deliveryAddress.length() <= 100)
        {
            this.customerAddress = deliveryAddress;
            return true;
        }
        return false;
    }

    /**
     * This mutator method sets the customer name of the Customer object with the value provided by the user.
     * Returns true if the value provided is appropriate.
     * Returns false otherwise.
     * @return boolean
     */
    public boolean setCustomerName(String customerName)
    {
        if (customerName.length() > 0 && customerName.length() <= 35)
        {
            this.customerName = customerName;
            return true;
        }
        return false;
    }

    /**
     * This mutator method sets the customer name of the Customer object with the value provided by the user.
     * Returns true if the value provided is appropriate.
     * Returns false otherwise.
     * @return boolean
     */
    public boolean setCustomerNumber(String customerNumber)
    {
        if (customerNumber.length() == 10)
        {
            for (int i = 0; i < 10; i++)
            {
                char x;
                x = customerNumber.charAt(i);
                if (! Character.isDigit(x))
                {
                    return false;
                }
            }
            this.customerNumber = customerNumber;
            return true;
        }
        return false;
    }

    /**
     * This method returns the String representation, that is, the state of Customer object in String format.
     * @return
     */
    @Override
    public String toString()
    {
        String customerString;
        customerString = "Customer Information: ";
        customerString += "\n-------------------------";
        customerString += "\n\tCustomer Name: " + this.customerName;
        customerString += "\n\tCustomer Address: " + this.customerAddress;
        customerString += "\n\tCustomer Phone Number: " + this.customerNumber;
        customerString += "\n-------------------------";
        return customerString;
    }

}
