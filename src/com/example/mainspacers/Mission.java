package com.example.mainspacers;

//ABSTRACT SUPERCLASS
abstract class Mission { //The abstract class Mission provides a blueprint for different mission types.

    // Encapsulation: Fields like name, staff, and objective etc. are private.
    private String name;
    private String staff;
    private String objective;
    private int duration;
    private String missionStatus = "Ongoing"; // Default status
    private Spacecraft assignedSpacecraft;
    private Resource[] assignedResources = new Resource[100];
    private int resourceCount = 0;

    // Encapsulation: Private fields are accessed through public methods.
    // Constructor to initialize mission attributes
    public Mission(String name, String staff, String objective, int duration) {
        this.name = name;
        this.staff = staff;
        this.objective = objective;
        this.duration = duration;
    }

    // Public getters for mission name, staff, objective, duration, status, spacecraft, and resources (Encapsulation: Controlled access)
    public String getName() {
        return name;
    }

    public String getStaff() {
        return staff;
    }

    public String getObjective() {
        return objective;
    }

    public int getDuration() {
        return duration;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public Spacecraft getAssignedSpacecraft() {
        return assignedSpacecraft;
    }

    public Resource[] getAssignedResources() {
        return assignedResources;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    // Public setter for mission status (Encapsulation: Controlled access)
    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    // Method to assign a spacecraft to the mission
    public void assignSpacecraft(Spacecraft spacecraft) {
        assignedSpacecraft = spacecraft;
        spacecraft.setAvailability(false);
    }

    // Method to remove the assigned spacecraft
    public void removeSpacecraft() {
        if (assignedSpacecraft != null) {
            assignedSpacecraft.setAvailability(true);
            assignedSpacecraft = null;
        } else {
            System.out.println("No assigned spacecraft to remove.");
        }
    }

    // Method to add a resource to the mission
    public void addResource(Resource resource) {
        if (resourceCount < assignedResources.length) {
            if (resource.getQuantity() > 0) {
                assignedResources[resourceCount++] = resource;
            }
        } else {
            System.out.println("Maximum number of resources reached.");
        }
    }

    // Method to remove a resource from the mission
    public void removeResource(String resourceName) {
        for (int i = 0; i < resourceCount; i++) {
            if (assignedResources[i].getName().equalsIgnoreCase(resourceName)) {
                assignedResources[i] = assignedResources[--resourceCount];
                assignedResources[resourceCount] = null;
                System.out.println("Resource " + resourceName.toUpperCase() + " removed.");
                return;
            }
        }
        System.out.println("Resource not found.");
    }

    // Method to end the mission
    public void endMission(String status) {
        System.out.println("Ending the mission: " + name + "...");
        missionStatus = status;
        resourceCount = 0;
        if (assignedSpacecraft != null) {
            assignedSpacecraft.setAvailability(true);
            assignedSpacecraft = null;
        }
    }

    // Abstract method for mission type
    public abstract String getMissionType(); // The Mission class is incorporating an abstraction, serving as a template for all the user

    // Method to display mission details
    // Polymorphism: Different subclasses will have different implementations of this method
    public void displayDetails(boolean isHistory) {
        String spacecraftName = (assignedSpacecraft != null) ? assignedSpacecraft.getName().toUpperCase() : "None";
        String resources = (resourceCount > 0) ? String.valueOf(resourceCount) : "None";

        System.out.printf("%-30s %-15s %-15s %-30s %-15s %-15s %-20s %-30s\n",
                name.toUpperCase(), getMissionType().toUpperCase(), staff.toUpperCase(), objective,
                duration, missionStatus.toUpperCase(), spacecraftName, resources);
    }
}

//SUBCLASSESS
class ExplorationMission extends Mission {// Inheritance
    //this subclass inherits from the abstract Mission class.
    public ExplorationMission(String name, String staff, String objective, int duration) {
        super(name, staff, objective, duration);
    }

    @Override//Polymorphism
    // By override, polymorphism is implement for the parents class Mission.
    public String getMissionType() {
        return "Exploration";
    }
}

class MannedMission extends Mission {//Inheritance
   //: Inherits specific implementation behavior from class Mission.
    public MannedMission(String name, String staff, String objective, int duration) {
        super(name, staff, objective, duration);//ask for crew members details, objective and how many it will take them to complete it.
    }

    @Override//Polymorphism
    // This method overrides the parent class's Mission class implementation.
    public String getMissionType() {
        return "Manned";
    }
}

class UnmannedMission extends Mission {//Inheritance
    ////inherits a method implementation from Mission class
    public UnmannedMission(String name, String staff, String objective, int duration) {
        super(name, staff, objective, duration);// for unmanned mission it ask details for remote controlled objects(ie. Robots)
    }

    @Override//Polymorphism
    //overrides the parent class's implementation for specific behavior.
    public String getMissionType() {
        return "Unmanned";
    }
}

class ResearchMission extends Mission {//Inheritance
    //This subclass inherits from the abstract Mission class.
    public ResearchMission(String name, String staff, String objective, int duration) {
        super(name, staff, objective, duration);//for research Mission this details include implementation from parent class(name,objective duration)
    }

    @Override
    // Polymorphism: This method overrides the parent class's implementation
    public String getMissionType() {
        return "Research";
    }
}

class DefenseMission extends Mission {
    //Inheritance//: Inherits specific implementation behavior from class Mission.
    public DefenseMission(String name, String staff, String objective, int duration) {
        super(name, staff, objective, duration);// want to ask implementation(name,their objective and how many days it will take) from the super class Mission
    }

    @Override
    // Polymorphism: This method overrides the parent class's implementation.
    public String getMissionType() {
        return "Defense";
    }
}
