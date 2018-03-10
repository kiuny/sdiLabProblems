package ro.ubb.labproblems.ui;

import ro.ubb.labproblems.controller.StudentController;

import java.util.Scanner;

public class StudentsMenu extends CommandMenu {

    private final StudentController studentController;

    public StudentsMenu(StudentController studentController, Scanner scanner) {
        super("Students operations", scanner);
        this.studentController = studentController;
        registerCommands();
    }

    @Override
    protected void registerCommands() {
        registerCommand("add", "Adds a new student", this::addCommand);
        registerCommand("all", "Shows all students", this::showAllCommand);
        registerCommand("remove", "Remove a student", this::removeCommand);
        registerCommand("update", "Update a student", this::updateCommand);
        super.registerCommands();
    }

    private void showAllCommand() {
        System.out.println(studentController.showAll());
    }

    private void addCommand() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Registration number: ");
        Integer registrationNumber = scanner.nextInt();

        System.out.print("Group number: ");
        Integer groupNumber = scanner.nextInt();

        System.out.println(studentController.add(name, registrationNumber, groupNumber));
    }

    private void removeCommand() {
        System.out.print("Registration number: ");
        Integer registrationNumber = scanner.nextInt();

        System.out.println(studentController.remove(registrationNumber));

    }

    private void updateCommand() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Registration number: ");
        Integer registrationNumber = scanner.nextInt();

        System.out.print("Group number: ");
        Integer groupNumber = scanner.nextInt();

        System.out.println(studentController.update(name, registrationNumber, groupNumber));
    }
}
