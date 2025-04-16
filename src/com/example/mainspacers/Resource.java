package com.example.mainspacers;

//ABSTRACT SUPERCLASS
abstract class Resource {
    private String name;
    private int quantity;

    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Public getters for resource name, details, assigned mission (Encapsulation: Controlled access)
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Public setter for resource quantity (Encapsulation: Controlled access)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to increment the resource quantity
    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    // Method to decrement the resource quantity
    public void decrementQuantity(int amount) {
        this.quantity -= amount;
    }

    // Abstract method for displaying resource information
    public abstract void displayInfo();   //POLYMORPHISM: Different subclasses will have different implementations of this method
}

//SUBCLASSES
class FuelResource extends Resource {
    private String fuelType;

    // Constructor to initialize fuel resource attributes
    public FuelResource(String name, int quantity, String fuelType) {
        super(name, quantity);
        this.fuelType = fuelType;
    }

    // Public getter for fuel type
    public String getFuelType() {
        return fuelType;
    }

    // Overridden method to display fuel resource information
    @Override
    public void displayInfo() {
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Fuel Type: " + fuelType);
    }
}

class EquipmentResource extends Resource {
    private String equipmentType;

    // Constructor to initialize equipment resource attributes
    public EquipmentResource(String name, int quantity, String equipmentType) {
        super(name, quantity);
        this.equipmentType = equipmentType;
    }

    // Public getter for equipment type
    public String getEquipmentType() {
        return equipmentType;
    }

    // Overridden method to display equipment resource information
    @Override
    public void displayInfo() {
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Equipment Type: " + equipmentType);
    }
}

class FoodResource extends Resource {
    private String expiryDate;

    // Constructor to initialize food resource attributes
    public FoodResource(String name, int quantity, String expiryDate) {
        super(name, quantity);
        this.expiryDate = expiryDate;
    }

    // Public getter for expiry date
    public String getExpiryDate() {
        return expiryDate;
    }

    // Overridden method to display food resource information
    @Override
    public void displayInfo() {
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Expiry Date: " + expiryDate);
    }
}
