package com.example.mainspacers;
import java.util.Scanner;

public class MainSpace{
    //Scanner object for user input
    private static Scanner space = new Scanner(System.in);

    //Array to store objects of different classes
    private static Mission[] missions = new Mission[100];
    private static Mission[] missionHistory = new Mission[100];
    private static Spacecraft[] spacecrafts = new Spacecraft[100];
    private static Resource[] resources = new Resource[100];
    private static ResearchProject[] researchProj = new ResearchProject[100];

    //Counters to keep track of number of objects created
    private static int spacecraftCount = 0;
    private static int resourceCount = 0;
    private static int missionCount = 0;
    private static int historyCount = 0;
    private static int researchCount = 0;

    //Main method
    public static void main(String[] args){
        System.out.println("\n=+=+= SPACE AGENCY MANAGEMENT SYSTEM =+=+=");

        //Main loop for login and navigation
        while (true){
            //User login and role selection
            String userRole = userLogin();

            //Role-specific menus
            switch (userRole){
                case "Admin":
                    adminMenu();
                    break;

                case "Mission Planner":
                    manageMissionsMenu();
                    break;

                case "Spacecraft Engineer":
                    manageSpacecraftMenu();
                    break;

                case "Resource Manager":
                    manageResourcesMenu();
                    break;

                case "Scientist/Researcher":
                    manageResearchProjsMenu();
                    break;

                default:
                    System.out.println("You are not authorized to take any action.");
            }
        }
    }

    //Exit program
    public static void progExit(){
        System.out.println("\nExiting... Thank you!");
        System.exit(0);
    }

    //User login
    private static String userLogin(){
        System.out.println("\n==== LOG IN ====\n");
        System.out.println("1. Admin");
        System.out.println("2. Mission Planner");
        System.out.println("3. Spacecraft Engineer");
        System.out.println("4. Resource Manager");
        System.out.println("5. Scientist/Researcher");
        System.out.println("6. Exit Program");

        System.out.print("\nSelect option (enter 1-6): ");
        int roleChoice = space.nextInt();
        space.nextLine();

        switch (roleChoice){
            case 1:
                return "Admin";

            case 2:
                return "Mission Planner";

            case 3:
                return "Spacecraft Engineer";

            case 4:
                return "Resource Manager";

            case 5:
                return "Scientist/Researcher";

            case 6:
                progExit();     //exit

            default:
                System.out.println("Invalid input. Please enter an integer from 1 to 6 only.");
                return userLogin(); //Retry login
        }
    }

    //Admin menu
    private static void adminMenu(){
        while (true){
            System.out.println("\n==== ADMIN MENU ====");
            System.out.println("1. Manage Missions");
            System.out.println("2. Manage Spacecraft");
            System.out.println("3. Manage Resources");
            System.out.println("4. Manage Research Projects");
            System.out.println("5. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-5): ");
            int choice = space.nextInt();
            space.nextLine();

            switch (choice){
                case 1:
                    manageMissionsMenu();
                    break;

                case 2:
                    manageSpacecraftMenu();
                    break;

                case 3:
                    manageResourcesMenu();
                    break;

                case 4:
                    manageResearchProjsMenu();
                    break;

                case 5:
                    return;         //return login page

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 5 only.");
            }
        }
    }

    //MISSIONS
    //Manage Missions Menu
    public static void manageMissionsMenu(){
        while (true){
            System.out.println("\n==== Manage Missions ====\n");
            System.out.println("1. Create New Mission");
            System.out.println("2. Add/Remove Assigned Spacecraft");
            System.out.println("3. Add/Remove Assigned Resources");
            System.out.println("4. Display Missions");
            System.out.println("5. End A Mission");
            System.out.println("6. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-6): ");
            int missionChoice = space.nextInt();
            space.nextLine();

            switch (missionChoice){
                case 1:
                    createMission();
                    break;

                case 2:
                    modifyAssignedSpacecraft();
                    break;

                case 3:
                    modifyAssignedResources();
                    break;

                case 4:
                    displayAllMissions();
                    break;

                case 5:
                    missionEnded();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 6 only.");
            }
        }
    }

    //Create New Mission
    public static void createMission(){
        System.out.print("\nEnter NAME of Mission: ");
        String missionName = space.nextLine();

        System.out.print("Enter ASSIGNED STAFF: ");
        String missionStaff = space.nextLine();

        System.out.print("Enter MISSION OBJECTIVE/s: ");
        String missionObjective = space.nextLine();

        System.out.print("Enter DURATION of mission (in days): ");
        int missionDuration = space.nextInt();
        space.nextLine();

        // Provide fixed options for mission types
        System.out.println("\nSelect TYPE of Mission:");
        System.out.println("1. Exploration");
        System.out.println("2. Manned");
        System.out.println("3. Unmanned");
        System.out.println("4. Research");
        System.out.println("5. Defense");

        System.out.print("\nEnter your choice (1-5): ");
        int typeChoice = space.nextInt();
        space.nextLine();

        // Create the specific mission subclass based on the type choice
        // Polymorphism: The new mission object can be of any subclass of Mission
        Mission newMission = null;
        switch (typeChoice) {
            case 1:
                newMission = new ExplorationMission(missionName, missionStaff, missionObjective, missionDuration);
                break;
            case 2:
                newMission = new MannedMission(missionName, missionStaff, missionObjective, missionDuration);
                break;
            case 3:
                newMission = new UnmannedMission(missionName, missionStaff, missionObjective, missionDuration);
                break;
            case 4:
                newMission = new ResearchMission(missionName, missionStaff, missionObjective, missionDuration);
                break;
            case 5:
                newMission = new DefenseMission(missionName, missionStaff, missionObjective, missionDuration);
                break;
            default:
                System.out.println("Invalid choice. Mission creation aborted.");
                return;
        }

        // Assign Spacecraft to mission
        System.out.println("\nASSIGN SPACECRAFT\n");

        System.out.println("Available Spacecraft/s: \n");
        boolean foundAvailableSpacecraft = false;
        for (int i = 0; i < spacecraftCount; i++) {
            if (spacecrafts[i].isAvailable()) {
                System.out.println((i + 1) + ". " + spacecrafts[i].getName().toUpperCase());
                foundAvailableSpacecraft = true;
            }
        }
        if (!foundAvailableSpacecraft) {
            System.out.println("No available spacecraft. Please add spacecrafts in Manage Spacecraft menu first.");
        } else {
            System.out.print("\nEnter spacecraft number to assign: ");
            int spacecraftChoice = space.nextInt();
            space.nextLine();

            if (spacecraftChoice >= 1 && spacecraftChoice <= spacecraftCount && spacecrafts[spacecraftChoice - 1].isAvailable()) {
                newMission.assignSpacecraft(spacecrafts[spacecraftChoice - 1]);
                System.out.println("\nSpacecraft " + spacecrafts[spacecraftChoice - 1].getName().toUpperCase() + " successfully assigned.\n");
            } else {
                System.out.println("Invalid input or spacecraft unavailable.");
            }
        }

        // Assign Resources to the mission
        System.out.println("\nASSIGN RESOURCES");

        System.out.println("\nAvailable Resource/s: \n");
        boolean foundAvailableResources = false;
        for (int i = 0; i < resourceCount; i++) {
            if (resources[i].getQuantity() > 0) {
                System.out.print((i + 1) + ". ");
                resources[i].displayInfo();         //Polymorphic call
                foundAvailableResources = true;
            }
        }

        if (!foundAvailableResources) {
            System.out.println("No available resources. Please add resources in the Manage Resource menu first.");
        } else {
            System.out.print("\nEnter resource name: ");
            String resourceName = space.nextLine();
            System.out.print("Enter quantity: ");
            int resourceQuantity = space.nextInt();
            space.nextLine();

            boolean resourceAssigned = false;
            for (int i = 0; i < resourceCount; i++) {
                if (resources[i].getName().equalsIgnoreCase(resourceName) && resources[i].getQuantity() >= resourceQuantity) {
                    Resource assignedResource = null;

                    // Clone the resource based on its type
                    if (resources[i] instanceof FuelResource) {
                        FuelResource fuel = (FuelResource) resources[i];
                        assignedResource = new FuelResource(fuel.getName(), resourceQuantity, fuel.getFuelType());
                    } else if (resources[i] instanceof EquipmentResource) {
                        EquipmentResource equipment = (EquipmentResource) resources[i];
                        assignedResource = new EquipmentResource(equipment.getName(), resourceQuantity, equipment.getEquipmentType());
                    } else if (resources[i] instanceof FoodResource) {
                        FoodResource food = (FoodResource) resources[i];
                        assignedResource = new FoodResource(food.getName(), resourceQuantity, food.getExpiryDate());
                    }

                    if (assignedResource != null) {
                        newMission.addResource(assignedResource); // Add to mission
                        resources[i].decrementQuantity(resourceQuantity); // Deduct from available resources
                        System.out.println("\nResource " + resourceName.toUpperCase() + " | Quantity: " + resourceQuantity
                                + " successfully added to mission.");
                        resourceAssigned = true;
                        break;
                    }
                }
            }

            if (!resourceAssigned) {
                System.out.println("Resource not found or insufficient quantity.");
            }
        }

        // Store the Mission in the Mission log
        missions[missionCount++] = newMission;
        System.out.println("\nMission " + missionName.toUpperCase() + " created successfully.");
    }

    //Modify Assigned Spacecraft
    public static void modifyAssignedSpacecraft(){
        System.out.print("\nEnter mission name to modify: ");
        String missionName = space.nextLine();

        for(int i = 0; i < missionCount; i++){
            if(missions[i].getName().equalsIgnoreCase(missionName)){
                System.out.println("\nCurrent Assigned Spacecraft: " + (missions[i].getAssignedSpacecraft() != null ? missions[i].getAssignedSpacecraft().getName() : "None"));

                System.out.println("\n1. Remove Assigned Spacecraft");
                System.out.println("2. Add New Spacecraft");

                System.out.print("\nEnter choice number (1-2): ");
                int choice = space.nextInt();

                //Switch case to remove or add spacecraft
                switch (choice){
                    case 1:
                        if (spacecraftCount != 0){
                            missions[i].removeSpacecraft();
                            System.out.println("Assigned spacecraft removed.");
                        } else{
                            System.out.println("No spacecraft to be removed.");
                        }
                        break;

                    case 2:
                        System.out.println("\nAvailable Spacecraft/s:\n");
                        boolean foundAvailableSpacecraft = false;
                        for (int j = 0; j < spacecraftCount; j++) {
                            if (spacecrafts[j].isAvailable()) {
                                System.out.println((j + 1) + ". " + spacecrafts[j].getName());
                                foundAvailableSpacecraft = true;
                            }
                        }

                        if (!foundAvailableSpacecraft) {
                            System.out.println("No available spacecraft. Please add spacecrafts in Manage Spacecraft menu first.");
                        } else {
                            System.out.print("\nEnter spacecraft number to assign: ");
                            int spacecraftChoice = space.nextInt();
                            space.nextLine();

                            if (spacecraftChoice >= 1 && spacecraftChoice <= spacecraftCount && spacecrafts[spacecraftChoice - 1].isAvailable()) {
                                missions[i].assignSpacecraft(spacecrafts[spacecraftChoice - 1]);
                                System.out.println("\nNew spacecraft assigned.");
                            } else {
                                System.out.println("\nInvalid choice or spacecraft not available.");
                            }
                        }
                        break;
                    default:
                        System.out.println("\nInvalid input. Please enter either 1 or 2.");
                }
                return;
            }
        }
        System.out.println("\nMission not found.");
    }

    //Modify Assigned Resources
    public static void modifyAssignedResources(){
        System.out.print("\nEnter mission name to modify: ");
        String missionName = space.nextLine();

        for (int i = 0; i < missionCount; i++) {
            if (missions[i].getName().equalsIgnoreCase(missionName)) {
                System.out.println("\nCurrent Assigned Resources:");
                Resource[] assignedResources = missions[i].getAssignedResources();
                for (int j = 0; j < missions[i].getResourceCount(); j++) {
                    assignedResources[j].displayInfo();
                }

                System.out.println("\n1. Remove Assigned Resource");
                System.out.println("2. Add New Resource");

                System.out.print("\nEnter choice number (1-2): ");
                int choice = space.nextInt();
                space.nextLine();

                // Switch case to remove or add resources
                switch (choice) {
                    case 1:
                        System.out.print("\nEnter resource name to remove: ");
                        String resourceNameRemove = space.nextLine();
                        missions[i].removeResource(resourceNameRemove);
                        System.out.println("Resource " + resourceNameRemove.toUpperCase() + " removed.");
                        break;

                    case 2:
                        System.out.println("\nAvailable Resources:");
                        for (int j = 0; j < resourceCount; j++) {
                            resources[j].displayInfo();
                        }

                        System.out.print("\nEnter resource name to add: ");
                        String resourceNameAdd = space.nextLine();

                        System.out.print("Enter quantity to add: ");
                        int quantityToAdd = space.nextInt();
                        space.nextLine();

                        for (int j = 0; j < resourceCount; j++) {
                            if (resources[j].getName().equalsIgnoreCase(resourceNameAdd) &&
                                resources[j].getQuantity() >= quantityToAdd) {

                                Resource newResource = null;
                                if (resources[j] instanceof FuelResource) {
                                    FuelResource fuel = (FuelResource) resources[j];
                                    newResource = new FuelResource(fuel.getName(), quantityToAdd, fuel.getFuelType());
                                } else if (resources[j] instanceof EquipmentResource) {
                                    EquipmentResource equipment = (EquipmentResource) resources[j];
                                    newResource = new EquipmentResource(equipment.getName(), quantityToAdd, equipment.getEquipmentType());
                                } else if (resources[j] instanceof FoodResource) {
                                    FoodResource food = (FoodResource) resources[j];
                                    newResource = new FoodResource(food.getName(), quantityToAdd, food.getExpiryDate());
                                }

                                if (newResource != null) {
                                    missions[i].addResource(newResource);
                                    resources[j].decrementQuantity(quantityToAdd);
                                    System.out.println("Resource " + resourceNameAdd.toUpperCase() +
                                        " | Quantity: " + quantityToAdd + " added to mission.");
                                }
                                break;
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid input. Please enter either 1 or 2.");
                }
                return;
            }
        }
        System.out.println("\nMission not found.");
    }

    //Display All Missions
    private static void displayAllMissions(){
        System.err.println("\n========================================================================== MISSION LOG ==========================================================================");
        // Display current missions
        System.out.println("\nCURRENT MISSIONS ================================================================================================================================================");
        if (missionCount == 0) {
            System.out.println("No ongoing missions.");
        } else {
            printTableHeader();
            for (int i = 0; i < missionCount; i++) {
                missions[i].displayDetails(false);
            }
        }
        // Display mission history
        System.out.println("\nHISTORY =========================================================================================================================================================");
        if (historyCount == 0) {
            System.out.println("No missions in history.");
        } else {
            printTableHeader();
            for (int i = 0; i < historyCount; i++) {
                missionHistory[i].displayDetails(true);     //Polymorphic call
            }
        }
    }

    //End a Mission
    private static void missionEnded(){
        System.out.print("Enter Mission Name to End: ");
        String name = space.nextLine();

        for (int i = 0; i < missionCount; i++){
            if (missions[i].getName().equalsIgnoreCase(name)) {
                System.out.print("Enter Mission Status (e.g., Completed, Failed): ");
                String status = space.nextLine();
                missions[i].endMission(status);
                missionHistory[historyCount++] = missions[i];
                for (int j = i; j < missionCount - 1; j++) {
                    missions[j] = missions[j + 1];
                }
                missions[--missionCount] = null;
                System.out.println("Mission ended and moved to history.");
                return;
            }
        }
        System.out.println("Mission not found.");
    }

    //Print table header for displaying missions
    private static void printTableHeader(){
        System.out.printf("%-30s %-15s %-15s %-30s %-15s %-15s %-20s %-30s\n",
                "Name", "Type", "Staff", "Objective", "Duration", "Status", "Assigned Spacecraft", "Assigned Resources");
        System.out.println("-".repeat(150));
    }

    //SPACECRAFT
    //Manage Spacecraft Menu
    public static void manageSpacecraftMenu(){
        while (true){
            System.out.println("\n==== Manage Spacecraft ====\n");
            System.out.println("1. Add New Spacecraft");
            System.out.println("2. Display All Spacecraft");
            System.out.println("3. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-3): ");
            int spacecraftChoice = space.nextInt();
            space.nextLine();

            switch (spacecraftChoice){
                case 1:
                    addNewSpacecraft();
                    break;

                case 2:
                    displayAllSpacecraft();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 3 only.");
            }
        }
    }

    //Add New Spacecraft
    public static void addNewSpacecraft(){
        System.out.println("\nChoose type of spacecraft to add:");
        System.out.println("1. Exploration Spacecraft");
        System.out.println("2. Manned Spacecraft");
        System.out.println("3. Unmanned Spacecraft");
        System.out.println("4. Research Spacecraft");
        System.out.println("5. Defense Spacecraft");

        System.out.print("\nEnter your choice (1-5): ");
        int typeChoice = space.nextInt();
        space.nextLine();

        System.out.print("\nEnter spacecraft name: ");
        String spacecraftName = space.nextLine();

        // Create the specific spacecraft subclass based on the type choice
        switch (typeChoice) {

            //MainSpace uses subclasses - instances of the Spacecraft class - to provide specific types of Spacecrafts
            case 1:  //Exploration Spacecraft
                System.out.print("Enter exploration range (in km): ");
                int range = space.nextInt();
                spacecrafts[spacecraftCount++] = new ExplorationSpacecraft(spacecraftName, range);
                break;

            case 2:  //Manned Spacecraft
                System.out.print("Enter crew capacity: ");
                int crewCapacity = space.nextInt();
                spacecrafts[spacecraftCount++] = new MannedSpacecraft(spacecraftName, crewCapacity);
                break;

            case 3:  //Unmanned Spacecraft
                System.out.print("Is it remote controlled? (true/false): ");
                boolean remoteControlled = space.nextBoolean();
                spacecrafts[spacecraftCount++] = new UnmannedSpacecraft(spacecraftName, remoteControlled);
                break;

            case 4:  //Research Spacecraft
                System.out.print("Enter research field: ");
                String researchField = space.nextLine();
                spacecrafts[spacecraftCount++] = new ResearchSpacecraft(spacecraftName, researchField);
                break;

            case 5:  //Defense Spacecraft
                System.out.print("Enter weapon power: ");
                int weaponPower = space.nextInt();
                spacecrafts[spacecraftCount++] = new DefenseSpacecraft(spacecraftName, weaponPower);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\nSpacecraft " + spacecraftName + " added successfully.");
    }

    //Display All Spacecraft
    public static void displayAllSpacecraft(){
        System.out.println("\n======================================== SPACECRAFTS ========================================");
        if (spacecraftCount > 0) {
            // Print table headers
            System.out.printf("%-20s %-15s %-15s %-30s\n", "Spacecraft Name", "Status", "Available", "Details");
            System.out.println("------------------------------------------------------------------------------------------");

            // Print each spacecraft's details
            for (int i = 0; i < spacecraftCount; i++) {
                Spacecraft spacecraft = spacecrafts[i];

                if (spacecraft instanceof ExplorationSpacecraft) {
                    ExplorationSpacecraft exploration = (ExplorationSpacecraft) spacecraft;  // Downcasting
                    System.out.printf("%-20s %-15s %-15s %-30s\n",
                            exploration.getName(),
                            exploration.getStatus(),
                            exploration.isAvailable() ? "Yes" : "No",
                            "Range: " + exploration.getRange() + " km");
                } else if (spacecraft instanceof MannedSpacecraft) {                         // Downcasting
                    MannedSpacecraft manned = (MannedSpacecraft) spacecraft;
                    System.out.printf("%-20s %-15s %-15s %-30s\n",
                            manned.getName(),
                            manned.getStatus(),
                            manned.isAvailable() ? "Yes" : "No",
                            "Crew Capacity: " + manned.getCrewCapacity());
                } else if (spacecraft instanceof UnmannedSpacecraft) {                       // Downcasting
                    UnmannedSpacecraft unmanned = (UnmannedSpacecraft) spacecraft;
                    System.out.printf("%-20s %-15s %-15s %-30s\n",
                            unmanned.getName(),
                            unmanned.getStatus(),
                            unmanned.isAvailable() ? "Yes" : "No",
                            "Remote Controlled: " + (unmanned.isRemoteControlled() ? "Yes" : "No"));
                } else if (spacecraft instanceof ResearchSpacecraft) {                       // Downcasting
                    ResearchSpacecraft research = (ResearchSpacecraft) spacecraft;
                    System.out.printf("%-20s %-15s %-15s %-30s\n",
                            research.getName(),
                            research.getStatus(),
                            research.isAvailable() ? "Yes" : "No",
                            "Research Field: " + research.getResearchField());
                } else if (spacecraft instanceof DefenseSpacecraft) {                        // Downcasting
                    DefenseSpacecraft defense = (DefenseSpacecraft) spacecraft;
                    System.out.printf("%-20s %-15s %-15s %-30s\n",
                            defense.getName(),
                            defense.getStatus(),
                            defense.isAvailable() ? "Yes" : "No",
                            "Weapon Power: " + defense.getWeaponPower());
                }
            }
        } else {
            System.out.println("No spacecraft available.");
        }
    }

    //RESOURCE
    //Manage Resources Menu
    public static void manageResourcesMenu(){
        while (true){
            System.out.println("\n==== Manage Resources ====\n");
            System.out.println("1. Add New Resource");
            System.out.println("2. Display All Resources");
            System.out.println("3. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-3): ");
            int resourceChoice = space.nextInt();
            space.nextLine();

            switch (resourceChoice){
                case 1:
                    addNewResource();
                    break;

                case 2:
                    displayAllResources();
                    break;

                case 3:
                    return;
                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 3 only.");
            }
        }
    }

    //Add New Resource
    public static void addNewResource(){
        System.out.println("\nChoose type of resource to add:");
        System.out.println("1. Fuel Resource");
        System.out.println("2. Equipment Resource");
        System.out.println("3. Food Resource");

        System.out.print("\nEnter choice number: ");
        int typeChoice = space.nextInt();
        space.nextLine();

        System.out.print("\nEnter resource name: ");
        String resourceName = space.nextLine();

        System.out.print("Enter quantity: ");
        int resourceQuantity = space.nextInt();
        space.nextLine(); //Clear the scanner buffer

        //Create the specific resource subclass based on the type choice
        switch (typeChoice) {
            case 1: //Fuel Resource
                System.out.print("Enter fuel type: ");
                String fuelType = space.nextLine();
                resources[resourceCount++] = new FuelResource(resourceName, resourceQuantity, fuelType);
                break;

            case 2: // Equipment Resource
                System.out.print("Enter equipment type: ");
                String equipmentType = space.nextLine();
                resources[resourceCount++] = new EquipmentResource(resourceName, resourceQuantity, equipmentType);
                break;

            case 3: // Food Resource
                System.out.print("Enter expiry date (YYYY-MM-DD): ");
                String expiryDate = space.nextLine();
                resources[resourceCount++] = new FoodResource(resourceName, resourceQuantity, expiryDate);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Resource " + resourceName.toUpperCase() + " added successfully.");
    }

    //Display All Resources
    public static void displayAllResources(){
        System.out.println("\n==== All Resources ====\n");
        if (resourceCount > 0) {
            //Print the table header
            System.out.printf("%-20s %-10s %-20s\n", "Resource Name", "Quantity", "Details");
            System.out.println("---------------------------------------------------------------");

            //Print each resource in table format
            for (int i = 0; i < resourceCount; i++) {
                Resource resource = resources[i];

                if (resource instanceof FuelResource) {
                    FuelResource fuel = (FuelResource) resource;
                    System.out.printf("%-20s %-10d %-20s\n",
                            fuel.getName(),
                            fuel.getQuantity(),
                            "Fuel Type: " + fuel.getFuelType());
                } else if (resource instanceof EquipmentResource) {
                    EquipmentResource equipment = (EquipmentResource) resource;
                    System.out.printf("%-20s %-10d %-20s\n",
                            equipment.getName(),
                            equipment.getQuantity(),
                            "Equipment Type: " + equipment.getEquipmentType());
                } else if (resource instanceof FoodResource) {
                    FoodResource food = (FoodResource) resource;
                    System.out.printf("%-20s %-10d %-20s\n",
                            food.getName(),
                            food.getQuantity(),
                            "Expiry Date: " + food.getExpiryDate());
                }
            }
        } else {
            System.out.println("\nResource List Empty.");
        }
    }


    //RESEARCH
    //Manage Research Projects Menu
    public static void manageResearchProjsMenu(){
        while (true) {
            System.out.println("\n==== Manage Research Projects ====\n");
            System.out.println("1. Create New Research Project");
            System.out.println("2. Assign Mission to Research Project");
            System.out.println("3. Display All Research Projects");
            System.out.println("4. Back to Main Login Page");

            System.out.print("\nEnter menu number (1-4): ");
            int projectChoice = space.nextInt();
            space.nextLine();

            switch (projectChoice){
                case 1:
                    createNewResearchProject();
                    break;

                case 2:
                    assignMissionToResearchProject();
                    break;

                case 3:
                    displayAllResearchProjects();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 4 only.");
            }
        }
    }

    //Create New Research Project
    public static void createNewResearchProject(){
        System.out.println("\nChoose type of research project to create:");
        System.out.println("1. Astronomy Research");
        System.out.println("2. Biology Research");
        System.out.println("3. Technology Development Research");

        int typeChoice = space.nextInt();
        space.nextLine();

        System.out.print("Enter project name: ");
        String projectName = space.nextLine();

        System.out.print("Enter project details: ");
        String projectDetails = space.nextLine();

        ResearchProject newResearchProject = null;

        // Create the specific research project subclass based on the type choice
        switch (typeChoice) {
            case 1: // Astronomy Research
                System.out.print("Enter celestial object to study: ");
                String celestialObject = space.nextLine();
                newResearchProject = new AstronomyResearch(projectName, projectDetails, celestialObject);
                break;

            case 2: // Biology Research
                System.out.print("Enter organism to study: ");
                String organism = space.nextLine();
                newResearchProject = new BiologyResearch(projectName, projectDetails, organism);
                break;

            case 3: // Technology Development Research
                System.out.print("Enter technology to develop: ");
                String technology = space.nextLine();
                newResearchProject = new TechnologyDevelopmentResearch(projectName, projectDetails, technology);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (newResearchProject != null) {
            researchProj[researchCount++] = newResearchProject;
            System.out.println("Research project " + projectName.toUpperCase() + " created successfully.");
        }
    }

    //Assign Mission to Research Project
    public static void assignMissionToResearchProject(){
        System.out.print("\nEnter project name to assign a mission: ");
        String projectName = space.nextLine();

        // Find the research project by name
        ResearchProject selectedProject = null;
        for (int i = 0; i < researchCount; i++) {
            if (researchProj[i].getName().equalsIgnoreCase(projectName)) {
                selectedProject = researchProj[i];
                break;
            }
        }

        if (selectedProject == null) {
            System.out.println("Research project not found.");
            return;
        }

        // Check if there are available missions
        if (missionCount == 0) {
            System.out.println("No available missions to assign.");
            return;
        }

        // Display all available missions
        System.out.println("\nList of Available Missions:");
        displayAllMissions();                                   // Polymorphic call

        // Prompt the user to select a mission
        System.out.print("\nEnter mission name to assign: ");
        String missionName = space.nextLine();

        // Find the mission by name
        Mission selectedMission = null;
        for (int i = 0; i < missionCount; i++) {
            if (missions[i].getName().equalsIgnoreCase(missionName)) {
                selectedMission = missions[i];
                break;
            }
        }

        if (selectedMission == null) {
            System.out.println("Mission not found.");
            return;
        }

        // Assign the mission to the research project using polymorphism
        // The assignProjMission method is overridden in each subclass
        selectedProject.assignProjMission(selectedMission);
    }

    //Display All Research Projects
    public static void displayAllResearchProjects() {
        System.out.println("\n==== All Research Projects ====\n");

        if (researchCount > 0) {
            // Header for the table
            System.out.printf("%-25s %-50s %-20s %-25s\n",
                    "Project Name", "Details", "Assigned Mission", "Specific Attribute");
            System.out.println("=".repeat(125));

            for (int i = 0; i < researchCount; i++) {
                // Determine specific attribute dynamically
                String specificAttribute = "";

                if (researchProj[i] instanceof AstronomyResearch) {
                    specificAttribute = "Celestial Object: " + ((AstronomyResearch) researchProj[i]).getCelestialObject();
                } else if (researchProj[i] instanceof BiologyResearch) {
                    specificAttribute = "Organism: " + ((BiologyResearch) researchProj[i]).getOrganism();
                } else if (researchProj[i] instanceof TechnologyDevelopmentResearch) {
                    specificAttribute = "Technology: " + ((TechnologyDevelopmentResearch) researchProj[i]).getTechnology();
                }

                // Print the details in tabular format
                System.out.printf("%-25s %-50s %-20s %-25s\n",
                        researchProj[i].getName(),
                        researchProj[i].getDetails(),
                        researchProj[i].getAssignedMission() != null
                                ? researchProj[i].getAssignedMission().getName()
                                : "No mission assigned",
                        specificAttribute);
            }
            System.out.println("=".repeat(125));
        } else {
            System.out.println("Research Project List Empty.");
        }
    }

}

