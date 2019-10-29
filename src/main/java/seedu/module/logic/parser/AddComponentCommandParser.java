package seedu.module.logic.parser;

import seedu.module.commons.core.index.Index;
import seedu.module.logic.commands.gradebookCommands.AddComponentCommand;
import seedu.module.logic.parser.exceptions.ParseException;
import seedu.module.model.module.Grade;

import static seedu.module.logic.parser.CliSyntax.PREFIX_PERCENTAGE;
import static seedu.module.logic.parser.CliSyntax.PREFIX_COMPONENT;

/**
 * Parses input arguments and creates a new AddComponentCommand object.
 */
public class AddComponentCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the AddGradeCommand
     * and returns an AddGradeCommand object for execution.
     * @param argsMultimap
     * @return AddGradeCommand
     * @throws ParseException if the user input does not conform the expected format.
     */
    public AddComponentCommand parse(ArgumentMultimap argsMultimap) throws ParseException {
        Index index = ParserUtil.parseIndex(argsMultimap.getPreamble());
        if (argsMultimap.getValue(PREFIX_PERCENTAGE).isPresent() && argsMultimap.getValue(PREFIX_COMPONENT).isPresent()) {
            String component = argsMultimap.getValue(PREFIX_COMPONENT).get();
            String percentage = argsMultimap.getValue(PREFIX_PERCENTAGE).get();
            Grade addGrade = new Grade(component, Integer.valueOf(percentage), "-");
            return new AddComponentCommand(index, addGrade);
        } else {
            throw new ParseException(Grade.MESSAGE_CONSTRAINTS);
        }

    }
}
