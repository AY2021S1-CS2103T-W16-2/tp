---
layout: page
title: User Guide
---

ForgetfulNUS is a **desktop app for helping students taking German 1** (LAG1201) **and German 2** (LAG2201) **in NUS to practise and test their vocabulary, optimised for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, ForgetfulNUS can get your German revision done faster than traditional GUI apps.

## Table of Contents

1. [Quick Start](#qs)
1. [Features](#features)
    1. [Editing the glossary](#editing)
        1. [Add Flashcard](#add)
        1. [Delete Flashcard](#delete)
        1. [Clear All Flashcards](#clear)
    2. [Test Yourself](#test)
        1. [Normal Mode](#quiz)
        1. [Random Mode](#random)
        1. [Next](#next)
        1. [Try](#try)
        1. [End Testing](#end)
    3. [Navigating the Glossary](#navigating)
        1. [Find a Flashcard](#find)
        1. [View All Flashcards](#list)
        1. [Sort All Flashcards](#sort)
    4. [Miscellaneous Commands](#misc)
        1. [Help](#help)
        1. [Exit](#exit)
1. [FAQ](#faq)
1. [Command Summary](#cmdsum)

--------------------------------------------------------------------------------------------------------------------

## <a name="qs"></a>1. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ForgetfulNUS.jar` from [here](https://github.com/AY2021S1-CS2103T-W16-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your ForgetfulNUS.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Here are some example commands you can try:

   * **`add`**`g/Vergesslichkeit e/Forgetfulness` : Adds a flashcard with German phrase `Vergesslichkeit` with English translation `Forgetfulness` to the glossary.

   * **`delete`**`3` : Deletes the 3rd flashcard shown in the glossary.
   
   * **`list`** : Lists all flashcards.

   * **`sort`**`english` : Sorts the glossary by alphabetical order of English phrases.

   * **`quiz`** : Starts a round of vocabulary testing with all existing flashcards in the glossary.

   * **`random`**`5` : Starts a round of vocabulary testing with 5 flashcards randomly chosen from the existing glossary.

   * **`end`** : Ends a round of vocabulary testing.

   * **`clear`** : Deletes all flashcards.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## <a name="features"></a>2. Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add g/<GERMAN PHRASE> e/<ENGLISH PHRASE>`, `GERMAN PHRASE` and `ENGLISH PHRASE` are parameters which can be used as `add g/Vergesslichkeit e/Forgetfulness`.
  
* Items with `...` after them can be used multiple times including zero times.
  e.g. `g/<GERMAN PHRASE> [t/<TAG>]...` can be used as  (i.e. 0 times), t/objects, t/objects t/nouns etc.
  
* Items in square brackets are optional
  e.g `g/<GERMAN PHRASE> [t/<TAG>]` can be used as g/Vergesslichkeit t/tutorialOne or as g/Vergesslichkeit.

</div>

### <a name="editing"></a>2.1. Editing the glossary

#### <a name="add"></a>2.1.1. Adding a flashcard: `add`

Adds a flashcard to the glossary.

Format: `add g/<GERMAN PHRASE> e/<ENGLISH PHRASE> d/[<DIFFICULTY>] s/[<GENDER>] [t/<TAG>]...}`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about add command:**<br>

* Difficulty has only three states, EASY, MEDIUM and HARD.
  If left blank, by default it will be MEDIUM.
  
* Gender has only three states, M (Masculine), F (Feminine) and NEUTRAL.
  If left blank, by default it will be NEUTRAL.
  
</div>

![add-screenshot](images/add-screenshot.png)

Example:
* `add g/Tasche e/bag d/hard s/f t/tutorialOne t/page5`

#### <a name="delete"></a>2.1.2. Deleting a flashcard : `delete`

Deletes the specified flashcard from the glossary.

Format: `delete <INDEX>`

* Deletes the flashcard at the specified `INDEX`.
* The index refers to the index number shown in the displayed glossary.
* The index **must be a positive integer** 1, 2, 3, …​

![delete-screenshot](images/delete-screenshot.png)

Example:
* `delete 2` deletes the 2nd flashcard in the glossary.

#### <a name="clear"></a>2.1.3. Clearing all entries : `clear`

Clears all flashcards from the glossary.

Format: `clear`

### <a name="test"></a>2.2. Test Yourself

#### <a name="quiz"></a>2.2.1. Normal Test : `quiz`

Starts a round of vocabulary testing with all the flashcards that are currently in the glossary.

Format: `quiz`

![quiz-screenshot](images/quiz-screenshot.png)

#### <a name="random"></a>2.2.2. Random Test : `random`

Starts a round of vocabulary testing with the specified number of flashcards randomly selected from the existing glossary.

Format: `random <NUMBER>`

![random-screenshot](images/random-screenshot.png)

Example: `random 10` starts a randomised quiz with 10 randomly selected flashcards.

#### <a name="next"></a>2.2.3. Next : `next`
Skips the current flashcard and move on to the next card in quiz mode.

Format: `next`

![next-screenshot](images/next-screenshot.png)

#### <a name="try"></a>2.2.4. Try : `try`
Compares the user attempt with the definition of the current flashcard. If the attempt is correct, the quiz will move on to the next flashcard. If the attempt is not correct, users will be prompted to try again or skip this card.

Format: `try <ATTEMPT>`
![try-screenshot](images/try-screenshot.png)

Example: 'try Tuesday'

#### <a name="end"></a>2.2.5. End Test : `end`

Ends the round of vocabulary testing.

Format: `end`

![end-screenshot](images/end-screenshot.png)

### <a name="navigating"></a>2.3. Navigating the glossary
#### <a name="find"></a>2.3.1. Finding a flashcard by the German phrase : `find`

Find a flashcard by the german phrase. The full phrase must be entered. 

Format: `find <GERMAN PHRASE>`

Examples:
* `find Tasche` Finds the flashcard with the German Phrase 'Tasche'.

![find-screenshot](images/find-screenshot.png)

#### <a name="list"></a>2.3.2. Listing all flashcards : `list`

Displays all flashcards in the glossary.

Format: `list`

![list-screenshot](images/list-screenshot.png)

#### <a name="sort"></a>2.3.3. Sort all flashcards : `sort`

Sorts the all flashcards according to the way you choose.

Format: `sort <PARAMETER>`

* `<PARAMETER>` refers to how you want to sort the flashcards by.
* Possible parameters:
    1. `german`: sorts by the alphabetical order of German phrases.
    1. `english`: sorts by the alphabetical order of English definitions.
    1. `reversegerman`: sorts by the reverse alphabetical order of German phrases.
    1. `reverseenglish`: sorts by the reverse alphabetical order of English phrases.
    1. `easytohard`: sorts by difficulty of flashcards, from easy to hard.
    1. `hardtoeasy`: sorts by difficulty of flashcards, from hard to easy.
    1. `earliest`: sorts by chronological order, from the earliest flashcard added to latest.
    1. `latest`: sorts by chronological order, from the latest flashcard added to earliest.

![sort-screenshot](images/sort-screenshot.png)

### <a name="misc"></a>2.4. Miscellaneous Commands

#### <a name="help"></a>2.4.1 Help : `help`

Opens a small window containing a link to this User Guide.

Format: `help`

#### <a name="exit"></a>2.4.2 Exiting the program : `exit`

Saves and exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## <a name="faq"></a>3. FAQ

**Q**: Do I need to save my data manually?<br>
**A**: ForgetfulNUS data is automatically saved in the hard disk upon exiting. There is no need to save manually.

**Q**: How do I transfer my data to another Computer?<br>
**A**:
1. Install the app in your other computer.
1. Locate the `data` folder in your previous ForgetfulNUS home folder, and find the `glossary.JSON` file inside.
1. Transfer the `glossary.JSON` file to your new computer
1. Place the `glossary.JSON` file in the `data` folder of the ForgetfulNUS home folder in your other computer.

--------------------------------------------------------------------------------------------------------------------

## <a name="cmdsum"></a>4. Command Summary

Action | Format, Examples
--------|------------------
**Add** | `add g/<GERMAN PHRASE> e/<ENGLISH PHRASE> [d/<DIFFICULTY>] [s/<GENDER>] [t/<TAG>]...` <br> e.g., `add g/Vergesslichkeit e/Forgetfulness d/hard`
**Delete** | `delete INDEX` <br> e.g., `delete 3`
**Clear** | `clear`
**Start Normal Quiz** | `quiz`
**Start Random Quiz** | `random <NUMBER>` <br> e.g., `random 5`
**Skip phrase in quiz** | `next`
**Attempt an answer** | `try <ATTEMPT>`
**End Quiz** | `end`
**Find** | `find <KEYWORD>`
**List** | `list`
**Sort** | `sort <PARAMETER>` <br> e.g., `sort english`
**Help** | `help`
**Exit** | `exit`
