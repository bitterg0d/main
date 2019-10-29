package seedu.module.logic.commands.gradebookCommands;

import seedu.module.commons.core.Messages;
import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.CommandResult;
import seedu.module.logic.commands.exceptions.CommandException;
import seedu.module.model.Model;
import seedu.module.model.module.Grade;
import seedu.module.model.module.TrackedModule;

import java.util.List;

public class AddGradeCommand extends GradeCommand {
    private Index index;
    private String score;
    private Grade grade;
    private int gradeIndexNum;

    public AddGradeCommand(Index index, String score, int gradeIndexNum) {
        this.index = index;
        this.score = score;
        this.gradeIndexNum = gradeIndexNum;

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<TrackedModule> lastShownList = model.getFilteredModuleList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        TrackedModule moduleToAddGrade = lastShownList.get(index.getZeroBased());
        grade = moduleToAddGrade.getGradeList().get(gradeIndexNum - 1);
        moduleToAddGrade.addGrade(grade);

        model.updateFilteredModuleList(Model.PREDICATE_SHOW_ALL_MODULES);
        model.displayTrackedList();

        return new CommandResult(generateSuccessMessage(moduleToAddGrade));
    }

    /**
     * Generates a command execution success message based on whether the remark is added to or removed from
     * {@code moduleToEdit}.
     */
    private String generateSuccessMessage(TrackedModule moduleToAddGrade) {
        String message = !grade.getGrade().isEmpty() ? MESSAGE_ADD_GRADE_SUCCESS
                : MESSAGE_DELETE_GRADE_SUCCESS;
        return String.format(message, moduleToAddGrade);
    }
}
