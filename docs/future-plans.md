# Future Plans for the Project

## In-App Spaced Repetition Flashcard System

One idea to go forward with this project is to implement a spaced-repetition-based flashcard system that will quiz the
user on select Kanji characters.

### Implementation

Although the following explanation tries to be as concise and clear as possible, these notes are provided after
watching [Matt vs Japan's YouTube Video](https://www.youtube.com/watch?v=lz60qTP2Gx0). He provides an explanation of the
Anki/Spaced Repetition algorithm in a more easy and broken-down fashion.

Spaced repetition flashcard systems are designed to quiz the end user on certain information in certain intervals that
will make the information more-memorable. At a base level, each spaced repetition flashcard is in one of three
categories:

1. New
2. Learning
3. Learned

New cards are those that have not yet been shown. Learning cards are those that are in the process of being learned, but
have not yet been mastered for any given day. Learned cards are those that have been mastered on a given day in the
past, but need to be reviewed to increase one's retention rate.

## Anki Deck Generator

Another, perhaps more-flexible and more-useful, tool would be to create an anki deck generator that would create decks
based on the SQLite database. Since Anki already has a built-in feature set of its own, this tool would merely serve as
a lookup tool, while Anki would implement the flashcard system.