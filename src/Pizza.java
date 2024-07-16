import java.util.ArrayList;

/**
 * This class is a part of Assignment 4 of FIT1051.
 *
 * This server class stores the information about a food item pizza and provides methods to access
 * and modify information of a pizza.
 * It is used by Order class and RestaurantDriver class.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public class Pizza extends FoodItem
{
    enum PizzaTopping
    {
        HAM, CHEESE, PINEAPPLE, MUSHROOMS, TOMATO, SEAFOOD
    }
    private ArrayList<PizzaTopping> pizzaToppings;

    private final PizzaTopping[] MEAT_TOPPINGS = {PizzaTopping.HAM, PizzaTopping.SEAFOOD};
    private final PizzaTopping[] VEGETARIAN_TOPPINGS = {PizzaTopping.CHEESE};

    private final PizzaTopping[] VEGAN_TOPPINGS = {PizzaTopping.PINEAPPLE,PizzaTopping.MUSHROOMS,PizzaTopping.TOMATO};

    /**
     * This default constructor initialises a Pizza object with appropriate default values.
     */
    public Pizza()
    {
        super();
        pizzaToppings = new ArrayList<PizzaTopping>();
    }

    /**
     * This non-default constructor initialises a Pizza object with the values provided by the User.
     */
    public Pizza(ArrayList<PizzaTopping> pizzaToppings)
    {
        super();
        this.setPizzaToppings(pizzaToppings);
    }

    /**
     * This method adds a topping to the pizza.
     * @param pizzaTopping
     */
    public void addPizzaTopping(PizzaTopping pizzaTopping)
    {
        this.pizzaToppings.add(pizzaTopping);
    }

    /**
     * This method computes the meal type of the pizza.
     */
    private void computeMealType()
    {
        if (this.hasToppings())
        {
            if (this.hasMeatToppings())
            {
                super.setMealType(MealType.MEAT);
            }
            else if (this.hasVegetarianToppings())
            {
                super.setMealType(MealType.VEGETARIAN);
            }
            else if (this.hasVeganToppings())
            {
                super.setMealType(MealType.VEGAN);
            }
        }
        else
        {
            super.setMealType(MealType.VEGAN);
        }
    }

    /**
     * This method computes the price of the pizza.
     */
    private void computePrice()
    {
        float currentPrice;
        currentPrice = this.getBasePrice();
        if(! hasToppings())
        {
            super.setPrice(currentPrice);
        }
        else
        {
            for (PizzaTopping pizzaTopping : this.pizzaToppings)
            {
                float toppingPrice = this.getToppingPrice(pizzaTopping);
                currentPrice += toppingPrice;
            }
            super.setPrice(currentPrice);
        }
    }

    /**
     * This method display's all the available toppings for a Pizza object.
     */
    @Override
    public void displayAllToppings()
    {
        for(PizzaTopping topping : PizzaTopping.values())
        {
            System.out.println(topping);
        }
    }

    /**
     * This accessor method returns the computed meal type of the Pizza object.
     * @return MealType
     */
    @Override
    public float getComputedPrice() {
        this.computePrice();
        return this.getPrice();
    }

    /**
     * This accessor method returns the computed price of the Pizza object.
     * @return float
     */
    @Override
    public MealType getComputedMealType() {
        this.computeMealType();
        return this.getMealType();
    }

    /**
     * This accessor method returns all the meat toppings for a Pizza.
     * @return PizzaTopping[]
     */
    public PizzaTopping[] getMeatToppings()
    {
        return MEAT_TOPPINGS;
    }

    /**
     * This accessor method returns all the toppings of the Pizza object.
     * @return ArrayList of PizzaTopping
     */
    public ArrayList<PizzaTopping> getPizzaToppings()
    {
        return this.pizzaToppings;
    }

    /**
     * This method returns the appropriate pizza topping for a string provided to the method.
     * If the string doesn't represent a topping, the method will return null.
     * @return PizzaTopping
     */
    public static Pizza.PizzaTopping getPizzaToppingFromString(String topping)
    {
        topping = topping.trim().toLowerCase();
        if (topping.equals("ham"))
        {
            return Pizza.PizzaTopping.HAM;
        }
        else if (topping.equals("cheese"))
        {
            return Pizza.PizzaTopping.CHEESE;
        }
        else if (topping.equals("pineapple"))
        {
            return Pizza.PizzaTopping.PINEAPPLE;
        }
        else if (topping.equals("mushrooms"))
        {
            return Pizza.PizzaTopping.MUSHROOMS;
        }
        else if (topping.equals("tomato"))
        {
            return Pizza.PizzaTopping.TOMATO;
        }
        else if (topping.equals("seafood"))
        {
            return Pizza.PizzaTopping.SEAFOOD;
        }
        else
        {
            return null;
        }
    }

    /**
     * This method returns price of the topping provided to the method.
     * @return float
     */
    private float getToppingPrice(PizzaTopping pizzaTopping)
    {
        if (pizzaTopping.equals(PizzaTopping.SEAFOOD))
        {
            return 3.5f;
        }
        else if (pizzaTopping.equals(PizzaTopping.PINEAPPLE))
        {
            return 2.5f;
        }
        else
        {
            return 2.0f;
        }
    }

    /**
     * This accessor method returns all the vegan toppings for a Pizza.
     * @return PizzaTopping[]
     */
    public PizzaTopping[] getVeganToppings()
    {
        return VEGAN_TOPPINGS;
    }

    /**
     * This accessor method returns all the vegetarian toppings for a Pizza.
     * @return PizzaTopping[]
     */
    public PizzaTopping[] getVegetarianToppings()
    {
        return VEGETARIAN_TOPPINGS;
    }

    /**
     * This method returns true if the Pizza has a meat topping.
     * @return boolean
     */
    private boolean hasMeatToppings()
    {
        for (PizzaTopping pizzaTopping : this.pizzaToppings)
        {
            for (PizzaTopping meatTopping : this.MEAT_TOPPINGS)
            {
                if (meatTopping.equals(pizzaTopping))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns true if the Pizza object has toppings,
     * false otherwise.
     * @return boolean
     */
    private boolean hasToppings()
    {
        if (this.pizzaToppings.size() != 0)
        {
            return true;
        }
        return false;
    }

    /**
     * This method returns true if the Pizza has a vegan topping.
     * @return boolean
     */
    private boolean hasVeganToppings()
    {
        for (PizzaTopping pizzaTopping : this.pizzaToppings)
        {
            for (PizzaTopping veganTopping : this.VEGAN_TOPPINGS)
            {
                if (veganTopping.equals(pizzaTopping))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method returns true if the Pizza has a vegetarian topping.
     * @return boolean
     */
    private boolean hasVegetarianToppings()
    {
        for (PizzaTopping pizzaTopping : this.pizzaToppings)
        {
            for (PizzaTopping vegetarianTopping : this.VEGETARIAN_TOPPINGS)
            {
                if (vegetarianTopping.equals(pizzaTopping))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This mutator method sets the topping of the Pizza object with the topping provided by the user.
     */
    public void setPizzaToppings(ArrayList<PizzaTopping> pizzaToppings)
    {
        for (PizzaTopping pizzaTopping : pizzaToppings)
        {
            this.addPizzaTopping(pizzaTopping);
        }
    }

    /**
     * This method returns the String representation, that is, the state of Pizza object in String format.
     * @return String
     */
    @Override
    public String toString()
    {
        String pizzaString ;
        pizzaString = "Pizza with ";
        if (this.hasToppings())
        {
            for (PizzaTopping pizzaTopping : pizzaToppings)
            {
                pizzaString += pizzaTopping + ", ";
            }
            pizzaString += "topping(s). ";
        }
        else
        {
            pizzaString += "no topping(s). ";
        }

        pizzaString += FoodItem.getStringForMealType(getComputedMealType());

        return pizzaString;
    }

}