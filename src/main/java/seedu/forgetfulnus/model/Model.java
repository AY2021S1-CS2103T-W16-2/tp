package seedu.forgetfulnus.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.forgetfulnus.commons.core.GuiSettings;
import seedu.forgetfulnus.model.flashcard.FlashCard;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashCard> PREDICATE_SHOW_ALL_FLASHCARDS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' glossary file path.
     */
    Path getGlossaryFilePath();

    /**
     * Sets the user prefs' glossary file path.
     */
    void setGlossaryFilePath(Path glossaryFilePath);

    /**
     * Replaces glossary data with the data in {@code glossary}.
     */
    void setGlossary(ReadOnlyGlossary glossary);

    /** Returns the Glossary */
    ReadOnlyGlossary getGlossary();

    /**
     * Returns true if a flashCard with the same identity as {@code flashCard} exists in the glossary.
     */
    boolean hasFlashCard(FlashCard flashCard);

    /**
     * Deletes the given flashcard.
     * The flashcard must exist in the glossary.
     */
    void deleteFlashCard(FlashCard target);

    /**
     * Adds the given flashCard.
     * {@code flashCard} must not already exist in the glossary.
     */
    void addFlashCard(FlashCard flashCard);

    /**
     * Replaces the given flashcard {@code target} with {@code editedFlashCard}.
     * {@code target} must exist in the glossary.
     * The flashcard identity of {@code editedFlashCard} must not be the same as
     * another existing flashcard in the glossary.
     */
    void setFlashCard(FlashCard target, FlashCard editedFlashCard);

    /** Returns an unmodifiable view of the filtered flashcard list */
    ObservableList<FlashCard> getFilteredFlashCardList();

    /**
     * Updates the filter of the filtered flashcard list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPhraseList(Predicate<FlashCard> predicate);

    /**
     * Updates the filter of the filtered flashcard list to filter by the predicate in the class.
     */
    void updateFilteredPhraseList();

    void updateQuizModeIndex(int index);

    int getQuizModeIndex();

    void setQuizMode(boolean quizMode);

    boolean isQuizMode();
}