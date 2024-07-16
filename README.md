# Takeaway Order Management System - README

## Overview

This Takeaway Order Management System is developed to help a restaurant manage its delivery orders for pizza and pasta. 
The program maintains a list of customer orders, allows the user to add new orders, deliver existing orders, and print details of all current orders. 
The system ensures that the next order to be delivered is always the one that has been on the list for the longest time.

## Features

1. **Add New Order**: 
   - Enter customer details (name, contact number, delivery address).
   - Enter a list of food items (pizza or pasta with specific toppings).
   - The program calculates the total cost and determines the meal type (meat, vegetarian, vegan) based on the food items.

2. **Deliver Order**: 
   - Remove the oldest order from the list.
   - Print details of the delivered order to the screen.

3. **Print All Orders**: 
   - Display details of all current orders in the list.

4. **Exit**: 
   - Exit the program gracefully.

## Order Details

An order contains:
- A list of food items
- Customer name
- Customer contact number
- Delivery address
- Meal type (meat, vegetarian, vegan)
- Total cost

## Food Items

### Pizza
- Base price: $11.50
- Toppings:
  - Ham: +$2.00
  - Cheese: +$2.00
  - Pineapple: +$2.50
  - Mushrooms: +$2.00
  - Tomato: +$2.00
  - Seafood: +$3.50

### Pasta
- Base price: $11.50
- Toppings:
  - Tomato: +$4.00 (vegan)
  - Bolognese: +$5.20 (meat)
  - Primavera: +$5.20 (vegetarian)
  - Marinara: +$6.80 (meat)

## Design Requirements

The project is designed with the following principles:
- **Inheritance**: An abstract class is used as the super class.
- **Interface**: Ensures that the price and meal type can always be retrieved from both food items and orders.
- **Enum Type**: Used for managing meal types and food items.
- **Classes**: At least four classes, including the abstract class.

## Classes Overview

### Abstract Class: `FoodItem`
- Base class for `Pizza` and `Pasta`.
- Contains common properties and methods for food items.

### Class: `Pizza`
- Inherits from `FoodItem`.
- Contains properties for pizza toppings.
- Calculates price and determines meal type based on toppings.

### Class: `Pasta`
- Inherits from `FoodItem`.
- Contains properties for pasta type.
- Calculates price and determines meal type based on type of pasta.

## Developer

This project has been developed by Ayman Zuhair Shashavali as part of the Introduction to Java FIT1051 unit at Monash University. 
Ayman is a passionate software developer with a keen interest in object-oriented programming and creating practical solutions using Java.
