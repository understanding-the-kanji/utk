# Understanding the Kanji - Business Requirements

## Copyright Disclaimer

This application is based on the curriculum taught in
[James W Heisig's "Remembering the Kanji"](https://www.amazon.com/Remembering-Kanji-Complete-Japanese-Characters/dp/0824835921)
. Although this application uses the keywords, primitives, and indexes provided in his work; this program is meant to
complement, rather than replace, his work. Heisig's book guides you through the first 500+ Kanji characters through
stories and plots not included in this program. Additionally, he teaches you how to come up with your own stories, which
this program will not address. This program also does not provide an explanation into how or why his method is so
effective. For all of that (and more), you will need to purchase his book (provided in the link above).

## Goals of the Project

The Understanding the Kanji education tool will have two main purposes.

1. Provide a lookup tool for Kanji characters based on specific search criteria.
2. Provide a spaced-repetition-based flashcard system to facilitate easy learning of the Kanji.

### Kanji Lookup Tool

Kanji characters will be available for lookup by three optional search criteria:

1. RTK (Heisig) Index
2. Kanji Character Unicode
3. RTK (Heisig) Keyword

The Kanji lookup page will consist of the three fields, with a "Submit" button below to submit choices. There will also
be a "Back" button to return to the main screen.

The results page will consist of query results, and the user will be given the option to select one of them.

When one of the results is selected, a new window containing information about the Kanji will be displayed.

### Spaced Repetition Flashcard System (like Anki)

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

#### Settings

- _Steps_ can be used to adjust the learning interval. For example, when a user learns a new card, it goes to 10
  minutes, then 1 day. These default steps can be changed and new ones can be added as desired.

- The _graduating interval_ controls how quickly cards progress 

_steps_: the learning interval
_graduating interval_: the learned interval
_easy interval_: going from learning to instant learned (eg. 4 days, etc.)

#### New Cards

When a card is in the "new" category, it does not have any scheduling information, only the order in which the cards are
to be introduced.

#### Learning Cards

When a card is in the "learning" category, it can either be a new card that is in the process of being learned or a
lapse.

If the card is new, it will contain a default

#### Buttons

Once a card is in the learning stage, there are three buttons