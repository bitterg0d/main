package seedu.module.logic.commands.gradebookCommands;

import seedu.module.logic.commands.Command;

import static seedu.module.logic.parser.CliSyntax.*;

public abstract class GradeCommand  extends Command {
    public static final String COMMAND_WORD = "grade";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds,deletes or edits a grade of a Module. \n"
            + "Parameters: \n"
            + "INDEX (must be a positive integer) \n"
            + PREFIX_ACTION + "ACTION\n"
            + PREFIX_COMPONENT + "COMPONENT\n"
            + PREFIX_PERCENTAGE + "PERCENTAGE\n"
            + PREFIX_GRADE + "GRADE\n"
            + "Example: " + COMMAND_WORD + " 1 " + PREFIX_ACTION + "addComponent "
            + PREFIX_COMPONENT + " MIDTERMS " + PREFIX_PERCENTAGE + "20 ";

    public static final String MESSAGE_ADD_COMPONENT_SUCCESS = "Added grading component to Module: %1$s";
    public static final String MESSAGE_DELETE_COMPONENT_SUCCESS = "Removed grading component to Module: %1$s";
    public static final String MESSAGE_ADD_GRADE_SUCCESS = "Added grade to Module: %1$s";
    public static final String MESSAGE_DELETE_GRADE_SUCCESS = "Removed grade from module: %1$s";
}
