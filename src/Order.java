import java.util.ArrayList;

/**
 * This class is a part of Assignment 4 of FIT1051.
 *
 * This server and client class stores the information related to an order and provides methods to access and modify information of an order.
 * It is used by RestaurantDriver class, that is, the main client class.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public class Order implements Details
{
    private ArrayList<FoodItem> foodItems;

    private Customer customer;

    private FoodItem.MealType mealType;

    private float totalPrice;

    /**
     * This default constructor initialises a Order object with appropriate default values.
     */
    public Order()
    {
        customer = new Customer();
        foodItems = new ArrayList<FoodItem>();
    }

    /**
     * This non-default constructor initialises a Order object with only the correct values
     * out of the values provided by the User.
     */
    public Order(String customerName, String customerNumber, String deliveryAddress,Customer customer, ArrayList<FoodItem> foodItems)
    {
        this.customer = customer;
        this.setFoodItems(foodItems);
    }

    /**
     * This method adds a food item to the order.
     * @param foodItem
     */
    public void addFoodItem(FoodItem foodItem)
    {
        this.foodItems.add(foodItem);
    }

    /**
     * This method computes the meal type of the order.
     */
    private void computeMealType()
    {
        if (this.hasMeatFoodItem())
        {
            this.setMealType(FoodItem.MealType.MEAT);
        }
        else if (this.hasVegetarianFoodItem())
        {
            this.setMealType(FoodItem.MealType.VEGETARIAN);
        }
        else if (this.hasVeganFoodItem())
        {
            this.setMealType(FoodItem.MealType.VEGAN);
        }
        else
        {
            this.setMealType(null);
        }
    }

    /**
     * This method computes the price of the order.
     */
    private void computePrice()
    {
        float orderPrice = 0f;
        for (FoodItem foodItem : foodItems)
        {
            orderPrice += foodItem.getComputedPrice();
        }
        this.setTotalPrice(orderPrice);
    }

    /**
     * This accessor method returns the computed meal type of the Order object.
     * @return MealType
     */
    @Override
    public FoodItem.MealType getComputedMealType()
    {
        this.computeMealType();
        return this.getMealType();
    }

    /**
     * This accessor method returns the computed price of the Order object.
     * @return float
     */
    @Override
    public float getComputedPrice()
    {
        this.computePrice();
        return this.getTotalPrice();
    }

    /**
     * This accessor method returns Customer object of the Order object.
     * @return Customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * This accessor method returns an ArrayList of FoodItems of the Order object.
     * @return ArrayList of FoodItems
     */
    public ArrayList<FoodItem> getFoodItems()
    {
        return foodItems;
    }

    /**
     * This accessor method returns the current meal type of the Order object.
     * @return MealType
     */
    public FoodItem.MealType getMealType()
    {
        return mealType;
    }

    /**
     * This accessor method returns the current price of the Order object.
     * @return float
     */
    public float getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * This method checks and returns true if the order has a FoodItem that contains Meat.
     * Returns false otherwise.
     * @return boolean
     */
    private boolean hasMeatFoodItem()
    {
        FoodItem.MealType foodItemMealType;
        for (FoodItem foodItem : foodItems)
        {
            foodItemMealType = foodItem.getComputedMealType();
            if (foodItemMealType.equals(FoodItem.MealType.MEAT))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks and returns true if the order has a FoodItem that is Vegan.
     * Returns false otherwise.
     * @return boolean
     */
    private boolean hasVeganFoodItem()
    {
        FoodItem.MealType foodItemMealType;
        for (FoodItem foodItem : foodItems)
        {
            foodItemMealType = foodItem.getComputedMealType();
            if (foodItemMealType.equals(FoodItem.MealType.VEGAN))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks and returns true if the order has a FoodItem that is Vegetarian.
     * Returns false otherwise.
     * @return boolean
     */
    private boolean hasVegetarianFoodItem()
    {
        FoodItem.MealType foodItemMealType;
        for (FoodItem foodItem : foodItems)
        {
            foodItemMealType = foodItem.getComputedMealType();
            if (foodItemMealType.equals(FoodItem.MealType.VEGETARIAN))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * This mutator method sets the Customer object of the Order object with the Customer object provided to the method.
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * This mutator method sets the FoodItems ArrayList of the Order object with the ArrayList object provided to the method.
     */
    public void setFoodItems(ArrayList<FoodItem> foodItems)
    {
        this.foodItems = foodItems;
    }

    /**
     * This mutator method sets the MealType of the Order object with the MealType object provided to the method.
     */
    public void setMealType(FoodItem.MealType mealType)
    {
        this.mealType = mealType;
    }

    /**
     * This mutator method sets the current price of the Order object with the value provided to the method.
     */
    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    /**
     * This method returns the String representation, that is, the state of Order object in String format.
     * @return String
     */
    @Override
    public String toString()
    {

        String orderString;

        orderString = this.customer.toString();

        orderString += "\nItems in the order: ";
        orderString += "\n-----------------------";
        for (FoodItem foodItem : this.foodItems)
        {
            orderString += "\n\t"+foodItem+" ----> Price: $"+foodItem.getComputedPrice();
        }
        orderString += "\n-----------------------";


        orderString += "\nOrder Information: ";
        orderString += "\n----------------------";
        orderString += "\n\tTotal Order Price: $"+this.getComputedPrice();
        orderString += "\n\tOrder Meal Type: "+this.getComputedMealType();
        orderString += "\n----------------------";

        return orderString;

    }

}
