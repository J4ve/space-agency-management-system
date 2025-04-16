# SPACE AGENCY MANAGEMENT SYSTEM
(Diagram is in the pdf attached contained with the same documentation)

### Team Members:
● Jave
● Carl Renz
● Fernanne Hannah

## Project Description:

The Space Agency Management System (SAMS) is a console-based program
created to equip Space Agencies with a tool for organising and managing expeditions,
spacecrafts, space science research projects and other utilities. Its features allow
efficient mission planning and monitoring, spacecraft listing, resource allocation and
inventory, and data collection and analysis. In addition, the system comes with a
user-friendly interface for intuitive navigation. By allowing authorized personnel to
create, manage, and update missions, spacecrafts, resources, and research projects,
SAMS aims to improve the efficiency and collaboration of space agencies. Its
user-friendly, text-based interface makes navigation intuitive, supporting role-based
access to ensure that personnel can only perform tasks within their authorized capacity.

## Features/Functionality:

● Role-based User Login
- Log In menu for authorised Space Agency personnel.
- User roles include Administrator (1), Spacecraft Engineer (2), Mission
Planner (3), Resource Manager (4), and Scientist/Researcher (5). Each role
has different levels of access.

● Administrator: Full access to all system functionalities.

● Spacecraft Engineer: Access to modify spacecraft information and
manage spacecraft status.

● Authority to create and update missions, assign spacecraft and
resources.

● Resource Manager: Manages inventory, including adding,
removing, and updating resources.

● Scientist/Researcher: Responsible for managing research projects
and assigning them to relevant missions.

● Mission Planning
- Authorised personnel can create new missions and modify information
regarding existing ones.

● Spacecraft Management
- Authorised personnel can access and modify the list of Spacecrafts and
its status.

● Resource Management
- Authorised personnel can access and modify inventory including adding
resources like fuel, equipment and food to the system.
- They can deallocate and allocate resources to specific missions ensuring
that mission planners have necessary resources for space expeditions.

● Research Project Management
- Authorised personnel can add new Research Projects and modify
information regarding existing ones. Research/Scientists can add and
specify research areas (e.g Astronomy, Biology, and Technology
Development) and also update the status of the research mission
initiatives.


## Scope and Limitation:
The Space Agency Management System (SAMS) is a console-based program
that will have a text-based UI. This project’s functions will cover basic input-output
options (i.e., creating, deleting, updating, displaying, inventory, and allocation).
Moreover, a User Login Menu is also included to control user access and
permission. In the meantime, only five user roles will be able to login. These are:
Administrator (1), Spacecraft Engineer/s (2), Mission Planner/s (3), Resource Manager
(4), and Scientist/Researcher (5) with permission tailored to each role/s responsibilities.
The level of authorisation is subject to the user's role.
The system is limited to a console-based user interface, which means no
graphical user interface (GUI) or advanced interaction. Resource and mission
assignments require manual entry, and there are no advanced validation checks for
resource conflicts or mission feasibility.
Furthermore, a limit of 100 entries for Missions, Spacecrafts, Resources, and
Research Projects was set. While this limit is sufficient for the scope of the project, it may
not scale for larger operations.

## Basic Classes:

● Scanner – this is used to take user input.

● MainSpace – this is the superclass of the program. It consists of the user
interface (user menu) along with methods for managing user input in
creating, modifying, assigning, and accessing missions, spacecraft lists,
resource inventory, and space research projects.

● Mission – this represents a space voyage and serves as a container for mission
details (name, type, objective, assigned spacecraft, assigned resources,
duration, status) and its alteration.

● Spacecraft – this represents a spacecraft that can be assigned to a mission
and serves as a container for spacecraft details (name, details, status).

● Resource - this represents a resource that can be added (increments
quantity) to or removed (decrements quantity) from missions and serves as a
container for resource details (name, quantity).

● ResearchProject - this represents a research project and serves as a container
for research project details (name, details, assigned mission).

