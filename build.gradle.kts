plugins {
  kotlin("jvm") version "2.0.20" apply false
}

allprojects {
  repositories {
    mavenCentral()

    maven(url = "https://repo.spring.io/milestone")
    maven(url = "https://repo.spring.io/snapshot")
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}

subprojects {

}
