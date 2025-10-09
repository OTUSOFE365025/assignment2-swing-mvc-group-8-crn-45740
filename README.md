[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/57HVEcop)
Example of an MVC design based on Swing. Answer questions 1 & 2 in this README file.

**1. Do some investigation into the Swing framework and write a short paragraph describing the
purpose of the Swing framework. Submit a class diagram of the components of Swing.**

The purpose of Java Swing is to provide an easy and adaptable way to create graphical user interfaces for desktop applications in Java. It includes built-in tools and components, like JFrame, JPanel, JButton, and JLabel, to design windows, forms, and menus without starting scratch. Also, Swing can run on any operating system because it is written entirely in Java. It's event-driven too, so the program responds to what the user is doing, through listeners, and follows the Model-View-Controller (MVC) principle, where the data, the visual display and the logic are separate, making it easy to build applications that are both clean and interactive.

<img width="1965" height="956" alt="image" src="https://github.com/user-attachments/assets/ce91660e-eae9-4ce0-a465-e477463c3089" />


**2. Look through the example code in the GitHub repository and explain how this example
implements the MVC pattern. How does it differ from the conventional MVC pattern
described in the lectures?**

In the GitHub repository example code, the Model-View-Controller pattern is implemented in a Java Swing by clearly separating data, interface, and control logic. The Model class stores its two main attributes, first and last names. Also, it provides methods to get and set them. 
The View, which is the visual part of the application, creates the user interface with Swing components such as JFrame, JLabel, JTextField, and JButton. It's all about laying out and presenting the information.
The Controller bridges the two by hooking up buttons in the View so that when clicked, it asks the View for the input, updates the Model, and shows a pop-up message box. The MySwingMVCApp class initializes the components and starts the application. 
Swing takes a slightly different approach than the conventional MVC pattern we have learned in lectures. From the perspective that controllers MVC are embedded as listeners inside GUI components rather than being completely separate modules. In the conventional MVC, the Model would send notifications to the View and Controller through the Observer pattern, which keeps them separate. Here, the Controller goes straight to the View and Model, cutting loose on the separation, but simplifying event handling. This shows how Swing takes the MVC idea we learned in class and applies it to a real GUI setup, keeping each part focused on its own job and making it easier to understand how MVC actually works.


**4.Create a sequence diagram of your design for the scenario presented in question 3 representing a single press of the scan button.**
<img width="1356" height="703" alt="image" src="https://github.com/user-attachments/assets/90f493e9-7c7e-4883-b9eb-e82ff140bc3c" />
