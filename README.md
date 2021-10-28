# Mobile tests

To run test on Browserstack:
```bash
gradle clean test -DdeviceHost=browserstack
```

To run test on Selenoid:
```bash
gradle clean test -DdeviceHost=selenoid
```

To run tests on an emulator:
```bash
gradle clean test -DdeviceHost=emulator
```

To run test locally:
```bash
gradle clean test -DdeviceHost=local
```

To make the tests work, add a configuration file to src/test/resources/config/(browserstack/selenoid/emulator/local).properties
File's structure depends on a device/tool where you want to run tests.

Structure of browserstack.properties
```bash
user=
key=
deviceUrl=http://hub.browserstack.com/wd/hub
app=
device=Google Pixel 3
osVersion=9.0
```
Structure of selenoid.properties
```bash
deviceUrl=https://user1:1234@selenoid.autotests.cloud/wd/hub
platformName=Android
device=android
osVersion=8.1
apkUrl=https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk
```
Structure of emulator.properties
```bash
deviceUrl=http://127.0.0.1:4723/wd/hub
device=Pixel_4_API_30
platformName=Android
osVersion=11.0
app=src/test/resources/app-alpha-universal-release.apk
```

Structure of local.properties
```bash
deviceUrl=http://127.0.0.1:4723/wd/hub
device=M1806E7TG
platformName=Android
osVersion=9.0
app=src/test/resources/app-alpha-universal-release.apk
```
