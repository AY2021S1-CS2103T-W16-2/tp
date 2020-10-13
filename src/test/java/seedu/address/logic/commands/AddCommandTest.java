package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.flashcard.FlashCard;
import seedu.address.testutil.FlashCardBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullFlashCard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_flashCardAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingFlashCardAdded modelStub = new ModelStubAcceptingFlashCardAdded();
        FlashCard validFlashCard = new FlashCardBuilder().build();

        CommandResult commandResult = new AddCommand(validFlashCard).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validFlashCard), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validFlashCard), modelStub.flashCardsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        FlashCard validFlashCard = new FlashCardBuilder().build();
        AddCommand addCommand = new AddCommand(validFlashCard);
        ModelStub modelStub = new ModelStubWithFlashCard(validFlashCard);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PHRASE, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        FlashCard alice = new FlashCardBuilder().withName("Alice").build();
        FlashCard bob = new FlashCardBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different flashCard -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFlashCard(FlashCard flashCard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFlashCard(FlashCard flashCard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFlashCard(FlashCard target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashCard(FlashCard target, FlashCard editedFlashCard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<FlashCard> getFilteredFlashCardList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPhraseList(Predicate<FlashCard> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        /**
         * Updates the filter of the filtered flashcard list to filter by the predicate in the class.
         */
        @Override
        public void updateFilteredPhraseList() {

        }

        @Override
        public void updateQuizModeIndex(int index) {

        }

        @Override
        public int getQuizModeIndex() {
            return 0;
        }

        @Override
        public void setQuizMode(boolean quizMode) {

        }

        @Override
        public boolean isQuizMode() {
            return false;
        }
    }

    /**
     * A Model stub that contains a single flashCard.
     */
    private class ModelStubWithFlashCard extends ModelStub {
        private final FlashCard flashCard;

        ModelStubWithFlashCard(FlashCard flashCard) {
            requireNonNull(flashCard);
            this.flashCard = flashCard;
        }

        @Override
        public boolean hasFlashCard(FlashCard flashCard) {
            requireNonNull(flashCard);
            return this.flashCard.isSameFlashCard(flashCard);
        }
    }

    /**
     * A Model stub that always accept the flashCard being added.
     */
    private class ModelStubAcceptingFlashCardAdded extends ModelStub {
        final ArrayList<FlashCard> flashCardsAdded = new ArrayList<>();

        @Override
        public boolean hasFlashCard(FlashCard flashCard) {
            requireNonNull(flashCard);
            return flashCardsAdded.stream().anyMatch(flashCard::isSameFlashCard);
        }

        @Override
        public void addFlashCard(FlashCard flashCard) {
            requireNonNull(flashCard);
            flashCardsAdded.add(flashCard);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
