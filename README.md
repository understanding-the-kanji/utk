# Understanding the Kanji

[![Gradle](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml/badge.svg)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml)
[![Doxygen](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml/badge.svg?branch=main)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml)

This tool is meant to aid the learner of the Japanese language in understanding the meaning behind the Kanji characters. Many students of Japanese feel as there are too many Kanji characters to remember. However, it turns out that the Kanji characters (based on the Chinese writing system), can be broken down into smaller, more-memorable "radicals" (as they are called). By piecing these radicals together and coming up with stories to go along with these radicals, one can drastically reduce the time and effort required to master the Kanji.

## License
All of the code for this project is licensed under the MIT license (a copy of which should be included in this project under the LICENSE file). The Noto Sans Japanese Font included with this project is licensed separately under the SIL OPEN FONT LICENSE Version 1.1 and is created by Google.

## How to Use This Program
This program is not meant to a complete source for Japanese language learning. Many good learning sources already exist (such as grammar textbooks, lecture videos, etc.) and this program is not meant to entirely replace those tools. However, this tool is meant to _aid_ the learner in Japanese (specifically in remembering the Kanji characters).

### Dependency Installation
To build this program, you will need to have OpenJDK17 installed on your machine. This program may work well with other versions of Java, but this app is only officially supported on the OpenJDK17 platform.

#### Windows (Chocolatey)
To install OpenJDK17 using the [Chocolatey package manager](https://chocolatey.org/), you can type in the following in a Powershell session running as Administrator:
```
choco install openjdk17 -y
```

#### Ubuntu (apt)
If you are running Ubuntu, you can type in the following on the terminal:
```
sudo apt install openjdk-17-jdk openjdk-17-jre -y
```

### Running the Project

#### Windows
If you are on Windows, you can type in the following in the command prompt:
```
.\gradlew.bat
```

#### Ubuntu (or any other Linux platform)
If you are on Ubuntu (or any other Linux distribution for that matter), you can type in the following in the terminal:
```
./gradlew
```