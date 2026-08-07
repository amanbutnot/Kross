import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.amanbutnot"
version = libs.versions.kross.get()

kotlin {
    android {
        namespace = "io.github.amanbutnot.kross"
        //noinspection GradleDependency
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava() // enable java compilation support
        withHostTestBuilder {}.configure {}
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }
        lint {
            abortOnError = true
            warningsAsErrors = true
        }
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), "kross-core", version.toString())

    pom {
        name = "Kross"
        description = "All in one compose multiplatform library."
        inceptionYear = "2026"
        url = "https://github.com/amanbutnot/Kross.git"
        licenses {
            license {
                name = "Apache License 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0"
                distribution = "repo"
            }
        }
        developers {
            developer {
                id = "amanbutnot"
                name = "Aman"
                url = "https://github.com/amanbutnot"
            }
        }
        scm {
            url = "https://github.com/amanbutnot/kross"
            connection = "scm:git:git://github.com/amanbutnot/kross.git"
            developerConnection = "scm:git:ssh://git@github.com/amanbutnot/kross.git"
        }
    }
}
