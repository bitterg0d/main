package seedu.module.logic.parser;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.gradebookCommands.AddComponentCommand;
import seedu.module.logic.commands.gradebookCommands.AddGradeCommand;
import seedu.module.logic.parser.exceptions.ParseException;
import seedu.module.model.module.Grade;

import static seedu.module.logic.parser.CliSyntax.*;

public class AddGradeCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the AddGradeCommand
     * and returns an AddGradeCommand object for execution.
     *
     * @param argsMultimap
     * @return AddGradeCommand
     * @throws ParseException if the user input does not conform the expected format.
     */
    public AddGradeCommand parse(ArgumentMultimap argsMultimap) throws ParseException {
        Index index = ParserUtil.parseIndex(argsMultimap.getPreamble());
        if (argsMultimap.getValue(PREFIX_GRADE).isPresent()) {
            String score = argsMultimap.getValue(PREFIX_GRADE).get();
            int gradeIndexNum = Integer.parseInt(argsMultimap.getValue(PREFIX_GRADE_INDEX).get().trim());
            return new AddGradeCommand(index, score, gradeIndexNum);
        } else {
            throw new ParseException(Grade.MESSAGE_CONSTRAINTS);
        }

    }
}