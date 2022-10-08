# Understanding the Kanji

[![Gradle](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml/badge.svg)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml)
[![Doxygen](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml/badge.svg?branch=main)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml)


This tool is meant to aid the learner of the Japanese language in understanding the meaning behind the Kanji characters.
Many students of Japanese feel as there are too many Kanji characters to remember. However, it turns out that the Kanji
characters (based on the Chinese writing system), can be broken down into smaller, more-memorable "radicals" (as they
are called). By piecing these radicals together and coming up with stories to go along with these radicals, one can
drastically reduce the time and effort required to master the Kanji.

## Licensing

### Copyright Disclaimer

This application is based on the curriculum taught in
[James W Heisig's "Remembering the Kanji"](https://www.amazon.com/Remembering-Kanji-Complete-Japanese-Characters/dp/0824835921)
. Although this application uses the keywords, primitives, and indexes provided in his work; this program is meant to
complement, rather than replace, his work. Heisig's book guides you through the first 500+ Kanji characters through
stories and plots not included in this program. Additionally, he teaches you how to come up with your own stories, which
this program will not address. This program also does not provide an explanation into how or why his method is so
effective. For all of that (and more), you will need to purchase his book (provided in the link above).

### Other Licensing Information

All the source code for this project is licensed under the MIT license. All external assets should contain a LICENSE
file in the directory in which they are stored. Although the schema for the database is licensed under the same license
as the project source code (the MIT license), the content stored in that database is licensed under the CC0 1.0
Universal license.

## How to Use This Program

This program is not meant to a complete source for Japanese language learning. Many good learning sources already
exist (such as grammar textbooks, lecture videos, etc.) and this program is not meant to entirely replace those tools.
However, this tool is meant to _aid_ the learner in Japanese (specifically in remembering the Kanji characters).

## How This Program Works

The main purpose of this program is to provide an easy way to look up the characters and meanings of the Kanji
characters provided in Heisig's works. It serves as a dictionary-tool (of sorts) by which the user can query for Kanji
characters.

### Kanji Lookup Tool

Kanji characters will be available for lookup by three optional search criteria:

1. RTK (Heisig) Index
2. Kanji Character Unicode
3. RTK (Heisig) Keyword

The Kanji lookup page allows the user to search based on one of the aforementioned criteria. Since Heisig keeps his
keywords unique (only one keyword per kanji character), the keywords are strongly-typed and need to match the material
taught in Heisig's works.

# Build Instructions

## Dependency Installation

To build this program, you will need to have OpenJDK17 installed on your machine. This program may work well with other
versions of Java, but this app is only officially supported on the OpenJDK17 platform.

### Windows (Chocolatey)

To install OpenJDK17 using the [Chocolatey package manager](https://chocolatey.org/), you can type in the following in a
Powershell session running as Administrator:

```
choco install openjdk17 -y
```

### Ubuntu (apt)

If you are running Ubuntu, you can type in the following on the terminal:

```
sudo apt install openjdk-17-jdk openjdk-17-jre -y
```

## Running the Project

### Windows

If you are on Windows, you can type in the following in the command prompt:

```
.\gradlew.bat run
```

### Ubuntu (or any other Linux platform)

If you are on Ubuntu (or any other Linux distribution for that matter), you can type in the following in the terminal:

```
./gradlew run
```

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
