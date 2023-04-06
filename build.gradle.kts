plugins {
    java
    application
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "net.samuelcmace"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

application {
    mainModule.set("net.samuelcmace.utk")
    mainClass.set("net.samuelcmace.utk.ApplicationLauncher")
}

javafx {
    version = "20"
    modules("javafx.controls", "javafx.fxml")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.xerial:sqlite-jdbc:3.41.2.1")
}

tasks.test {
    useJUnitPlatform()
}