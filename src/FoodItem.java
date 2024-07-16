/**
 * This class is a part of Assignment 4 of FIT1051.
 *
 * This class stores data and provides methods to obtain and modify the price and the meal type of a food item.
 * This class is used as a super class for Pizza and Pasta.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public abstract class FoodItem implements Details
{
    enum MealType
    {
        MEAT, VEGETARIAN, VEGAN
    }
    private final float BASE_PRICE = 11.50f;

    private float foodItemPrice;

    private MealType mealType;

    /**
     * This default constructor initialises a FoodItem object with appropriate default values.
     */
    public FoodItem()
    {
        this.foodItemPrice = this.BASE_PRICE;
        this.mealType = MealType.VEGAN;
    }

    /**
     * This non-default constructor initialises a FoodItem object with the values provided by the User.
     */
    public FoodItem(MealType mealType)
    {
        this.foodItemPrice = this.BASE_PRICE;
        this.mealType = mealType;
    }

    /**
     * This non-default constructor initialises a FoodItem object with the values provided by the User.
     */
    public FoodItem(float foodItemPrice, MealType mealType)
    {
        this.foodItemPrice = foodItemPrice;
        this.mealType = mealType;
    }

    /**
     * This method display's all the available toppings for a FoodItem object.
     */
    public abstract void displayAllToppings();

    /**
     * This accessor method returns the base price of the FoodItem object.
     * @return float
     */
    public float getBasePrice() {
        return BASE_PRICE;
    }

    /**
     * This accessor method returns the computed meal type of the FoodItem object.
     * @return MealType
     */
    public abstract MealType getComputedMealType();

    /**
     * This accessor method returns the computed price of the FoodItem object.
     * @return float
     */
    public abstract float getComputedPrice();

    /**
     * This accessor method returns the current meal type of the FoodItem object.
     * @return MealType
     */
    public MealType getMealType()
    {
        return this.mealType;
    }

    /**
     * This accessor method returns the current price of the FoodItem object.
     * @return float
     */
    public float getPrice()
    {
        return this.foodItemPrice;
    }

    /**
     * This accessor method returns the String representation of the provided MealType.
     * @return String
     */
    public static String getStringForMealType(MealType mealType)
    {
        if (mealType.equals(MealType.MEAT))
        {
            return "(Contains Meat)";
        }
        else if (mealType.equals(MealType.VEGETARIAN))
        {
            return "(Vegetarian)";
        }
        else if (mealType.equals(MealType.VEGAN))
        {
            return "(Vegan)";
        }
        else
        {
            return null;
        }

    }

    /**
     * This mutator method sets the meal type of the FoodItem object with the MealType provided to the method.
     */
    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }


    /**
     * This mutator method sets the price of the FoodItem object with the Price provided to the method.
     * @return
     */
    public void setPrice(float foodItemPrice)
    {
        this.foodItemPrice = foodItemPrice;
    }

}
