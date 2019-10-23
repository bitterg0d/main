package seedu.module.logic.parser;

import seedu.module.logic.commands.gradebookCommands.GradeCommand;
import seedu.module.logic.parser.exceptions.ParseException;

import static seedu.module.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.module.logic.parser.CliSyntax.*;
import static seedu.module.logic.parser.CliSyntax.PREFIX_ACTION;

/**
 * Parses input arguments and creates a new GradeCommand object.
 */
public class GradeCommandParser implements Parser<GradeCommand>  {

    /**
     * Parses the given {@code String} of arguments in the context of the GradeCommand
     * @param args
     * @return a GradeCommand object for execution.
     * @throws ParseException if user input does not conform the expected format.
     */
    public GradeCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, GradeCommand.MESSAGE_USAGE));
        }
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ACTION, PREFIX_DESCRIPTION, PREFIX_TIME);
        try {
            if (!argMultimap.getValue(PREFIX_ACTION).isPresent()) {
                throw new ParseException("Input format error. a/ACTION not found");
            }
            if (argMultimap.getValue(PREFIX_ACTION).get().equals("add")) {
                return new AddGradeCommandParser().parse(argMultimap);
            } else {
                throw new ParseException("Command not recognised");
            }
        } catch (ParseException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, GradeCommand.MESSAGE_USAGE, e));
        }
    }
}
