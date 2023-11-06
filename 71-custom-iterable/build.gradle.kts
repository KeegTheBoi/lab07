plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "7.0.0" // Update the version!
}

application {
    // Define the main class for the application
    mainClass.set("it.unibo.inner.TestIterableWithPolicy")
}