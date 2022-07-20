plugins {
    id("java")
}

group = "cc.polyfrost"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation ("org.beryx:awt-color-factory:1.0.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}