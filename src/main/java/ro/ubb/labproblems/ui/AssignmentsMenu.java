package ro.ubb.labproblems.ui;

public class AssignmentsMenu extends CommandMenu {


    public AssignmentsMenu(CommandMenu parentMenu) {
        super("Assignment operations", parentMenu);
    }


    @Override
    protected void registerCommands() {
        registerCommand("assign", "Assign a problem to a student", this::assignCommand);
        registerCommand("grade", "Grade an assignment", this::gradeCommand);
        registerCommand("unassign", "Unassign a problem from a student", this::unassignCommand);
        registerCommand("showAll", "Shows all assignments", this::showAllCommand);
        registerCommand("solvers", "List of ids of students solving a problem for a grade greater than 8", this::bestStudents);
        super.registerCommands();
    }

    private void showAllCommand() {
        System.out.println(assignmentService.showAll());
    }

    private void unassignCommand() {
        String studentRegistrationNumber = readRegistrationNumber();
        String problemTitle = readProblemTitle();

        System.out.println(assignmentService.unassign(problemTitle, studentRegistrationNumber));
    }

    private void gradeCommand() {
        String studentRegistrationNumber = readRegistrationNumber();
        String problemTitle = readProblemTitle();

        System.out.print("Grade: ");
        Double grade = scanner.nextDouble();

        System.out.println(assignmentService.grade(problemTitle, studentRegistrationNumber, grade));
    }

    private void assignCommand() {
        String studentRegistrationNumber = readRegistrationNumber();
        String problemTitle = readProblemTitle();

        System.out.println(assignmentService.assign(problemTitle, studentRegistrationNumber));
    }

    private void bestStudents() {
        String problemTitle = readProblemTitle();

        System.out.print("Min grade: ");
        Double minGrade = scanner.nextDouble();

        System.out.println(assignmentService.filterByGrade(problemTitle, minGrade));
    }


}