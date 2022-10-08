# Build Instructions

[![Gradle](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml/badge.svg)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/gradle.yml)
[![Doxygen](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml/badge.svg?branch=main)](https://github.com/samuelcmace/understanding-the-kanji/actions/workflows/doxygen.yml)

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