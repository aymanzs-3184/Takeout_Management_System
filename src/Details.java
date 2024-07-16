/**
 * This interface is a part of Assignment 4 of FIT1051.
 *
 * This interface makes sure that the computed price and computed meal type of FoodItem object or
 * OrderObject can be accessed by enforcing necessary methods on both the classes.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public interface Details
{

    /**
     * This accessor method returns the computed meal type of the respective object.
     * @return MealType
     */
    public abstract FoodItem.MealType getComputedMealType();

    /**
     * This accessor method returns computed price of the respective object.
     * @return MealType
     */
    public abstract float getComputedPrice();

}
