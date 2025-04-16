package com.example.mainspacers;

//ABSTRACT SUPERCLASS
abstract class ResearchProject {
    // Encapsulation: Private fields to restrict direct access
    private String name;
    private String details;
    private Mission assignedMission;

    // Constructor to initialize resource attributes
    public ResearchProject(String name, String details) {
        this.name = name;
        this.details = details;
    }

    // Public getter methods for name, details, and assigned mission (Encapsulation: Controlled access)
    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Mission getAssignedMission() {
        return assignedMission;
    }

    // Public setter for assigned mission (Encapsulation: Controlled access)
    public void setAssignedMission(Mission mission) {
        this.assignedMission = mission;
    }

    // Abstract method for specific assignment rules for each research project
    public abstract void assignProjMission(Mission mission);

    // Method to display research project details
    public void displayDetails() {                                  //POLYMORPHISM: Different subclasses will have different implementations of this method
        System.out.println("Research Project Name: " + name);
        System.out.println("Details: " + details);
        if (assignedMission != null) {
            System.out.println("Assigned Mission: " + assignedMission.getName());
        } else {
            System.out.println("No mission assigned.");
        }
    }
}

//SUBCLASSES
class AstronomyResearch extends ResearchProject {
    private String celestialObject;

    // Constructor to initialize astronomy research attributes
    public AstronomyResearch(String name, String details, String celestialObject) {
        super(name, details);
        this.celestialObject = celestialObject;
    }

    // Public getter for celestial object
    public String getCelestialObject() {
        return celestialObject;
    }

    // Method to assign mission to Astronomy Research project
    // Overrides the abstract method in the superclass
    @Override
    public void assignProjMission(Mission mission) {
        if (mission.getMissionType().equalsIgnoreCase("Manned") || mission.getMissionType().equalsIgnoreCase("Unmanned")) {
            setAssignedMission(mission);
            System.out.println("Mission assigned successfully to Astronomy Research project.");
        } else {
            System.out.println("Error: Astronomy Research can only be assigned Manned or Unmanned missions.");
        }
    }

    // Overridden method to display astronomy research details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Celestial Object: " + celestialObject);
    }
}

class BiologyResearch extends ResearchProject {
    private String organism;

    // Constructor to initialize biology research attributes
    public BiologyResearch(String name, String details, String organism) {
        super(name, details);
        this.organism = organism;
    }

    // Public getter for organism
    public String getOrganism() {
        return organism;
    }


    // Method to assign mission to Biology Research project
    // Overrides the abstract method in the superclass
    @Override
    public void assignProjMission(Mission mission) {
        if (mission.getMissionType().equalsIgnoreCase("Exploration")) {
            setAssignedMission(mission);
            System.out.println("Mission assigned successfully to Biology Research project.");
        } else {
            System.out.println("Error: Biology Research can only be assigned Exploration missions.");
        }
    }

    // Overridden method to display biology research details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Organism: " + organism);
    }
}

class TechnologyDevelopmentResearch extends ResearchProject {
    private String technology;

    // Constructor to initialize technology development research attributes
    public TechnologyDevelopmentResearch(String name, String details, String technology) {
        super(name, details);
        this.technology = technology;
    }

    // Public getter for technology
    public String getTechnology() {
        return technology;
    }

    // Method to assign mission to Technology Development Research project
    // Overrides the abstract method in the superclass
    @Override
    public void assignProjMission(Mission mission) {
        setAssignedMission(mission);
        System.out.println("Mission assigned successfully to Technology Development Research project.");
    }

    // Overridden method to display technology development research details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Technology: " + technology);
    }
}
