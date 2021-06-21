import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//buildscript {
//	repositories {
//		mavenCentral()
//	}
//
//	dependencies {
//		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
//		classpath("org.jetbrains.kotlin:kotlin-allopen:1.5.10")
//		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.5.1")
//	}
//}

plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
}

group = "br.com.GftLoversApi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

extra["springVersion"] = "2.5.1"

repositories {
	mavenCentral()
}

tasks.bootJar {
	enabled = false
}

subprojects {
	group = "br.com.GftLoversApi"
	version = "0.0.1-SNAPSHOT"

	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-allopen")

	repositories {
		mavenCentral()
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.boot:spring-boot-dependencies:${property("springVersion")}")
		}
	}

	dependencies {

		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		testImplementation("org.springframework.boot:spring-boot-starter-test")


	}

	allOpen {
//		annotation("org.springframework.stereotype.Component")
//		annotation("org.springframework.stereotype.Service")
//		annotation("org.springframework.stereotype.Repository")
		annotation("org.springframework.context.annotation.Configuration")
//		annotation("org.springframework.context.annotation.ComponentScan")

	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}
