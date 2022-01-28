val collectArtifactsTasks: MutableList<Copy> = ArrayList()

allprojects {
//    apply(kotlin("multiplatform"))
    version = "2!2020.01.27a0"
    group = "io.github.landgrafhomyak"

    if (this@allprojects !== rootProject) {
        configurations {
            create("out")
        }

        collectArtifactsTasks.add(
            tasks.create<Copy>("collectArtifacts") {
                dependsOn(configurations["out"])
                destinationDir = rootDir.resolve("out")

                from(configurations["out"].artifacts.files)
            }
        )
    }
}

tasks.create("collectArtifacts") {
    dependsOn(*collectArtifactsTasks.toTypedArray())
}