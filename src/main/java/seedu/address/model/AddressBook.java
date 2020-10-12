package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.flashcard.FlashCard;
import seedu.address.model.flashcard.UniqueFlashCardList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniqueFlashCardList persons;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniqueFlashCardList();
    }

    public AddressBook() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the flashcard list with {@code flashCards}.
     * {@code flashCards} must not contain duplicate flashCards.
     */
    public void setPersons(List<FlashCard> flashCards) {
        this.persons.setFlashCards(flashCards);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
    }

    //// flashcard-level operations

    /**
     * Returns true if a flashCard with the same identity as {@code flashCard} exists in the address book.
     */
    public boolean hasPerson(FlashCard flashCard) {
        requireNonNull(flashCard);
        return persons.contains(flashCard);
    }

    /**
     * Adds a flashcard to the address book.
     * The flashcard must not already exist in the address book.
     */
    public void addPerson(FlashCard p) {
        persons.add(p);
    }

    /**
     * Replaces the given flashcard {@code target} in the list with {@code editedFlashCard}.
     * {@code target} must exist in the address book.
     * The flashcard identity of {@code editedFlashCard} must not be the same as another existing
     * flashcard in the address book.
     */
    public void setPerson(FlashCard target, FlashCard editedFlashCard) {
        requireNonNull(editedFlashCard);

        persons.setFlashCard(target, editedFlashCard);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(FlashCard key) {
        persons.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<FlashCard> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBook // instanceof handles nulls
                && persons.equals(((AddressBook) other).persons));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }
}
