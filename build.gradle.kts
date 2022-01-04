plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.5.31"
}

group "com.github.nancom20"
version "3.0"

repositories {
    mavenCentral()

    maven ( url = "https://m2.dv8tion.net/releases" )

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("net.dv8tion:JDA:4.4.0_350")
}