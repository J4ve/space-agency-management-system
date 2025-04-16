package com.example.mainspacers;

//SUPERCLASS
class Spacecraft {
    // basic spacecraft info we need like name and details, and status/availability tracking
    private String name;
    private String status;
    private boolean isAvailable;

    // initializing spacecraft with name and details, defaults to available
    public Spacecraft(String spacecraftName) {
        this.name = spacecraftName;
        this.status = "Available";  // starts off available
        this.isAvailable = true;
    }

    // we toggle availability and update the status accordingly
    public void setAvailability(boolean availability) {
        isAvailable = availability;
        status = availability ? "Available" : "Assigned/Occupied";
    }

    // getting the name of the spacecraft
    public String getName() {
        return name;
    }

    // checking the current status
    public String getStatus() {
        return status;
    }

    // whether the spacecraft is currently available
    public boolean isAvailable() {
        return isAvailable;
    }

    // prints out all spacecraft info in a readable format
    public void displayDetails() {
        System.out.println("Spacecraft Name: " + name);
        System.out.println("Status: " + status);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

//SUBCLASSES
class ExplorationSpacecraft extends Spacecraft {
    // exploration spacecraft need a range for how far they can go
    private int range;  // in kilometers

    public ExplorationSpacecraft(String name, int range) {
        //name and detail attributes were inherited from the Superclass Spacecraft
        super(name);
        this.range = range;  // setting the range
    }

    // returns the exploration range
    public int getRange() {
        return range;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        //overrides Spacecraft's display method to add line for printing range attribute
        System.out.println("Exploration Range: " + range + " km");
    }
}

class MannedSpacecraft extends Spacecraft {
    // we need to keep track of how many crew members it can hold
    private int crewCapacity;

    public MannedSpacecraft(String name, int crewCapacity) {
        super(name);
        this.crewCapacity = crewCapacity;
    }

    // retrieves the number of crew it can hold
    public int getCrewCapacity() {
        return crewCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        //overrides Spacecraft's display method to add line for printing crewCapacity attribute
        System.out.println("Crew Capacity: " + crewCapacity);
    }
}

class UnmannedSpacecraft extends Spacecraft {
    // for unmanned spacecraft, we want to know if it's remote controlled
    private boolean remoteControlled;

    public UnmannedSpacecraft(String name, boolean remoteControlled) {
        super(name);
        this.remoteControlled = remoteControlled;
    }

    // tells us if it's remote controlled or not
    public boolean isRemoteControlled() {
        return remoteControlled;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        //overrides Spacecraft's display method to add line for printing remoteControlled attribute
        System.out.println("Remote Controlled: " + (remoteControlled ? "Yes" : "No"));
    }
}

class ResearchSpacecraft extends Spacecraft {
    // research spacecraft are assigned to specific research fields
    private String researchField;

    public ResearchSpacecraft(String name, String researchField) {
        super(name);
        this.researchField = researchField;  // assigning research field
    }

    // we can fetch what field the spacecraft is researching
    public String getResearchField() {
        return researchField;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        //overrides Spacecraft's display method to add line for printing researchField attribute
        System.out.println("Research Field: " + researchField);
    }
}

class DefenseSpacecraft extends Spacecraft {
    // defense spacecraft come with weapon power for protection or attacks
    private int weaponPower;  // arbitrary power units

    public DefenseSpacecraft(String name, int weaponPower) {
        super(name);
        this.weaponPower = weaponPower;  // setting weapon power level
    }

    // returns the weapon power level
    public int getWeaponPower() {
        return weaponPower;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        //overrides Spacecraft's display method to add line for printing weaponPower attribute
        System.out.println("Weapon Power: " + weaponPower);
    }
}
