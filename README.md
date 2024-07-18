# Runnning TextView
A running text library that is easy to customize and easy to set up.

<img src="https://github.com/user-attachments/assets/113ae19d-185c-42f4-a7cf-a49e879860f2" width="480px"/>
<img src="https://github.com/user-attachments/assets/6a0ba67e-3e7e-4fe1-81eb-f9281ef4f8de" width="480px"/>

## Installation
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
implementation 'com.github.eriffanani:RunningTextView:1.1.0'
```
#### build.gradle.kts(Module: app)
```kotlin
implementation("com.github.eriffanani:RunningTextView:1.1.0")
```

## How To Use
### layout.xml
```xml
<com.erif.library.RunningTextView
    android:id="@+id/txtRunning"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textColor="@android:color/black"
    android:background="#ECDE68"
    android:paddingTop="5dp"
    android:paddingBottom="5dp"
    android:text="@string/loremIpsum"
    android:textSize="24sp"
    app:scrollDuration="20000" // Default is 10 seconds
    app:scrollAutoPlay="true" // Default is false
    />
```
### Main.java
```java
RunningTextView runningText = findViewById(R.id.txtRunning);
runningText.setDuration(1); // 1 Minutes (Integer)
runningText.setDuration(10.0); // 10 Seconds (Double)
runningText.setDuration(10000L); // 10 Seconds (Long)

// Actions 
runningText.start();
runningText.pause();
runningText.resume();
```

### Main.kt (Kotlin)
```kotlin
val runningText: RunningTextView = findViewById(R.id.txtRunning);
runningText.setDuration(1) // 1 Minutes (Integer)
runningText.setDuration(10.0) // 10 Seconds (Double)
runningText.duration = 10000L // 10 Seconds (Long)

// Actions 
runningText.start()
runningText.pause()
runningText.resume()
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
