# Runnning TextView

## Installation
#### build.gradle (Project: Name)
```kotlin
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### When using gradle.kts
#### settings.gradle.kts
```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
 }
```

#### build.gradle(Module: app)
```kotlin
implementation 'com.github.eriffanani:RunningTextView:1.0.0'
```
#### build.gradle.kts(Module: app)
```kotlin
implementation("com.github.eriffanani:RunningTextView:1.0.0")
```

### Licence
```license
Copyright 2023 Mukhammad Erif Fanani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
