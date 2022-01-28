rootProject.name = "cwapi"
include(":core")
project(":core").name = "cwapi-core"
include(":clients")
project(":clients").name = "cwapi-clients"
include(":app")
project(":app").name = "cwapi-app"

