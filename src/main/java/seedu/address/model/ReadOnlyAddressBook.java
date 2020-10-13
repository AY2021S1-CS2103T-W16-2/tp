package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.flashcard.FlashCard;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the flashcards list.
     * This list will not contain any duplicate flashcard.
     */
    ObservableList<FlashCard> getFlashCardList();

}
