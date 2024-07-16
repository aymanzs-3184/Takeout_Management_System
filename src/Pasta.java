/**
 * This class is a part of Assignment 4 of FIT1051.
 *
 * This server class stores the information about a food item pasta and provides methods to access
 * and modify information of a pasta.
 * It is used by Order class and RestaurantDriver class.
 *
 * @author Ayman Z.S
 * @version 1.0
 */
public class Pasta extends FoodItem
{
    enum PastaTopping
    {
        BOLOGNESE, MARINARA, PRIMAVERA, TOMATO
    }

    private PastaTopping pastaTopping;

    private boolean hasTopping;

    /**
     * This default constructor initialises a Customer object with appropriate default values.
     */
    public Pasta()
    {
        super();
        hasTopping = false;
    }

    /**
     * This non-default constructor initialises a Customer object with the values provided by the User.
     */
    public Pasta(PastaTopping pastaTopping)
    {
        super();
        hasTopping = true;
        this.pastaTopping = pastaTopping;
    }

    /**
     * This method computes the meal type of the pasta.
     */
    private void computeMealType()
    {
        if (hasTopping)
        {
            if (this.hasMeatTopping())
            {
                super.setMealType(MealType.MEAT);
            }
            else if(this.hasVegetarianTopping())
            {
                super.setMealType(MealType.VEGETARIAN);
            }
            else if(this.hasVeganTopping())
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
     * This method computes the price of the pasta.
     */
    private void computePrice()
    {
        float currentPrice;
        currentPrice = this.getBasePrice();
        if(! hasTopping)
        {
            super.setPrice(currentPrice);
        }
        else
        {
            currentPrice += getToppingPrice(pastaTopping);
            super.setPrice(currentPrice);
        }
    }

    /**
     * This method display's all the available toppings for a Pasta object.
     */
    @Override
    public void displayAllToppings()
    {
        for(PastaTopping topping : PastaTopping.values())
        {
            System.out.println(topping);
        }
    }

    /**
     * This method will display the topping of the Pasta object if it exists, otherwise display's no toppings.
     */
    public void displayPastaTopping()
    {
        if (hasTopping)
            System.out.println(pastaTopping);
        else
            System.out.println("No Topping");
    }

    /**
     * This accessor method returns the computed meal type of the Pasta object.
     * @return MealType
     */
    @Override
    public MealType getComputedMealType() {
        this.computeMealType();
        return this.getMealType();
    }

    /**
     * This accessor method returns the computed price of the Pasta object.
     * @return float
     */
    @Override
    public float getComputedPrice() {
        this.computePrice();
        return this.getPrice();
    }

    /**
     * This accessor method returns the pastaTopping of the Pasta object if it exists, returns null otherwise.
     * @return PastaTopping
     */
    public PastaTopping getPastaTopping()
    {
        if (hasTopping)
            return pastaTopping;
        else
            return null;
    }

    /**
     * This method returns the appropriate pasta topping for a string provided to the method.
     * If the string doesn't represent a topping, the method will return null.
     * @return PastaTopping
     */
    public static PastaTopping getPastaToppingFromString(String topping)
    {
        topping = topping.trim().toLowerCase();
        if (topping.equals("tomato"))
        {
            return PastaTopping.TOMATO;
        }
        else if (topping.equals("bolognese"))
        {
            return PastaTopping.BOLOGNESE;
        }
        else if (topping.equals("marinara"))
        {
            return PastaTopping.MARINARA;
        }
        else if (topping.equals("primavera"))
        {
            return PastaTopping.PRIMAVERA;
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
    private float getToppingPrice(PastaTopping pastaTopping)
    {
        if (pastaTopping.equals(PastaTopping.TOMATO))
        {
            return 4.0f;
        }
        else if(pastaTopping.equals(PastaTopping.MARINARA))
        {
            return 6.8f;
        }
        else
        {
            return 5.2f;
        }
    }

    /**
     * This method returns true if the Pasta has a meat topping.
     * @return boolean
     */
    private boolean hasMeatTopping()
    {
        if (pastaTopping.equals(PastaTopping.BOLOGNESE) || pastaTopping.equals(PastaTopping.MARINARA))
        {
            return true;
        }
        return false;
    }

    /**
     * This method returns true if the Pasta has a vegan topping.
     * @return boolean
     */
    private boolean hasVeganTopping()
    {
        if (pastaTopping.equals(PastaTopping.TOMATO))
        {
            return true;
        }
        return false;
    }

    /**
     * This method returns true if the Pasta has a vegetarian topping.
     * @return boolean
     */
    private boolean hasVegetarianTopping()
    {
        if (pastaTopping.equals(PastaTopping.PRIMAVERA))
        {
            return true;
        }
        return false;
    }

    /**
     * This accessor method returns true if the Pasta object has a topping,
     * false otherwise.
     * @return boolean
     */
    public boolean isHasTopping()
    {
        return this.hasTopping;
    }

    /**
     * This mutator method sets the HasTopping variable of the Pasta object with
     * the boolean value provided by the user.
     */
    public void setHasTopping(boolean hasTopping)
    {
        this.hasTopping = hasTopping;
    }

    /**
     * This mutator method sets the topping of the Pasta object with the topping provided by the user.
     */
    public void setPastaTopping(PastaTopping pastaTopping)
    {
        this.hasTopping = true;
        this.pastaTopping = pastaTopping;
    }

    /**
     * This method returns the String representation, that is, the state of Pasta object in String format.
     * @return String
     */
    @Override
    public String toString()
    {
        String pastaString ;
        pastaString = "Pasta with ";
        if (this.hasTopping)
        {
            pastaString += this.pastaTopping + " topping. ";
        }
        else
        {
            pastaString += " no topping. ";
        }

        pastaString += FoodItem.getStringForMealType(getComputedMealType());


        return pastaString ;
    }

}
