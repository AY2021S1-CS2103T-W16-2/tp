package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.EnglishPhrase;
import seedu.address.model.flashcard.FlashCard;
import seedu.address.model.flashcard.GermanPhrase;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link FlashCard}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "FlashCard's %s field is missing!";

    private final String germanPhrase;
    private final String englishPhrase;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given flashcard details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("germanPhrase") String germanPhrase,
                             @JsonProperty("englishPhrase") String englishPhrase,
                             @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {
        this.germanPhrase = germanPhrase;
        this.englishPhrase = englishPhrase;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code FlashCard} into this class for Jackson use.
     */
    public JsonAdaptedPerson(FlashCard source) {
        germanPhrase = source.getGermanPhrase().fullGermanPhrase;
        englishPhrase = source.getEnglishPhrase().fullEnglishPhrase;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted flashcard object into the model's {@code FlashCard} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted flashcard.
     */
    public FlashCard toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (germanPhrase == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    GermanPhrase.class.getSimpleName()));
        }
        if (!GermanPhrase.isValidGermanPhrase(germanPhrase)) {
            throw new IllegalValueException(GermanPhrase.MESSAGE_CONSTRAINTS);
        }
        final GermanPhrase modelGermanPhrase = new GermanPhrase(germanPhrase);

        if (englishPhrase == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    EnglishPhrase.class.getSimpleName()));
        }
        if (!EnglishPhrase.isValidEnglishPhrase(englishPhrase)) {
            throw new IllegalValueException(EnglishPhrase.MESSAGE_CONSTRAINTS);
        }
        final EnglishPhrase modelEnglishPhrase = new EnglishPhrase(englishPhrase);
        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new FlashCard(modelGermanPhrase, modelEnglishPhrase, modelTags);
    }

}
