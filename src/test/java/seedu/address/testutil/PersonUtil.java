package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ENGLISH_PHRASE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GERMAN_PHRASE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.model.flashcard.FlashCard;
import seedu.address.model.tag.Tag;

/**
 * A utility class for FlashCard.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code flashCard}.
     */
    public static String getAddCommand(FlashCard flashCard) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(flashCard);
    }

    /**
     * Returns the part of command string for the given {@code flashCard}'s details.
     */
    public static String getPersonDetails(FlashCard flashCard) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_GERMAN_PHRASE + flashCard.getGermanPhrase().fullGermanPhrase + " ");
        sb.append(PREFIX_ENGLISH_PHRASE + flashCard.getEnglishPhrase().fullEnglishPhrase + " ");
        sb.append(PREFIX_EMAIL + flashCard.getEmail().value + " ");
        flashCard.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditFlashCardDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditCommand.EditFlashCardDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getGermanPhrase()
                .ifPresent(germanPhrase -> sb.append(PREFIX_GERMAN_PHRASE)
                        .append(germanPhrase.fullGermanPhrase).append(" "));
        descriptor.getEnglishPhrase()
                .ifPresent(englishPhrase -> sb.append(PREFIX_ENGLISH_PHRASE)
                        .append(englishPhrase.fullEnglishPhrase).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
