package ro.ubb.labproblems.controller;

import ro.ubb.labproblems.domain.entities.Assignment;
import ro.ubb.labproblems.domain.validators.ValidatorException;
import ro.ubb.labproblems.repository.Repository;

public class AssignmentController {

    private final Repository<Integer, Assignment> assignmentRepository;


    public AssignmentController(Repository<Integer, Assignment> assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }


    public String assign(String problemTitle, Integer studentRegistrationNumber) {
        try {
            return assignmentRepository.save(new Assignment(problemTitle, studentRegistrationNumber))
                    .map(student -> "Problem was already assigned to student")
                    .orElse("Assigned successfully");
        } catch (ValidatorException e) {
            return e.getMessage();
        }
    }

    public String grade(String problemTitle, Integer studentRegistrationNumber, Double grade) {
        Assignment assignment = new Assignment(problemTitle, studentRegistrationNumber);
        assignment.setGrade(grade);
        try {
            return assignmentRepository.update(assignment)
                    .map(student -> "Problem was not assigned to student")
                    .orElse("Graded successfully");
        } catch (ValidatorException e) {
            return e.getMessage();
        }
    }

    public String unnassign(String problemTitle, Integer studentRegistrationNumber) {
        return assignmentRepository.delete(new Assignment(problemTitle, studentRegistrationNumber).getIdentifier())
                .map(assignment -> "Unassigned successfully")
                .orElse("No assignment was present");
    }
}