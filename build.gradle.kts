import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Target
import org.jooq.codegen.GenerationTool

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    id("org.flywaydb.flyway") version "9.0.4"
    groovy
}

group = "com"
version = "0.2.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.modelmapper:modelmapper:3.1.0")
    implementation("io.github.microutils:kotlin-logging:2.1.23")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-jooq:2.7.2")
    implementation("org.zalando:logbook-spring-boot-starter:2.14.0")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    dependencies {
        classpath("org.jooq:jooq:3.14.4")
        classpath("org.jooq:jooq-codegen:3.14.4")
        classpath("org.postgresql:postgresql:42.4.1")
    }
}

val dbLocalUrl = "jdbc:postgresql://localhost:5432/admin"
val dbLocalUsername = "admin"
val dbLocalPassword = "admin"

val dbUrl = System.getenv()["DB_URL"] ?: dbLocalUrl
val dbUsername = System.getenv()["DB_USERNAME"] ?: dbLocalUsername
val dbPassword = System.getenv()["DB_PASSWORD"] ?: dbLocalPassword

flyway {
    url = "jdbc:postgresql://localhost:5432/admin"
    user = "admin"
    password = "admin"
    cleanDisabled = false
}

tasks.create("jooqGenerate") {
    GenerationTool.generate(Configuration()
        .withJdbc(Jdbc()
            .withUser("admin")
            .withPassword("admin")
            .withDriver("org.postgresql.Driver")
            .withUrl("jdbc:postgresql://localhost:5432/admin"))
        .withGenerator(Generator()
            .withDatabase(Database().withInputSchema("public"))
            .withGenerate(Generate())
            .withTarget(Target()
                .withPackageName("com.kanban.jooq")
                .withDirectory("${projectDir}/src/main/java"))))
}
