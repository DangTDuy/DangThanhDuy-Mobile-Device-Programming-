plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.google.services) apply false

}

// Xóa `dependencyResolutionManagement` vì nó không thuộc file này

