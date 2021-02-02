### [Node.js Simple Server](https://github.com/warren-bank/Android-NodeJS-Simple-Server)

Android app to demo running a simple HTTP server using Node.js in Android.

#### Screenshots:

![server](./screenshots/01-server.png)
![client](./screenshots/02-client.png)

#### Credits:

* [Node.js for Mobile Apps](https://github.com/JaneaSystems/nodejs-mobile) by [Janea Systems](https://github.com/JaneaSystems)

#### Design:

* this demo app is based on the official ["native-gradle"](https://github.com/janeasystems/nodejs-mobile-samples/tree/5f07c64eeb8c79abead04145b62f428b6b847553/android/native-gradle) sample app that is described on the ["Getting Started"](https://code.janeasystems.com/nodejs-mobile/getting-started-android) page of the documentation for using _Node.js for Mobile Apps_ in Android
  * license: [MIT](https://github.com/JaneaSystems/nodejs-mobile-samples/blob/5f07c64eeb8c79abead04145b62f428b6b847553/LICENSE)
* it borrows some native code and pre-built binaries from forked repos belonging to [Informatic](https://github.com/Informatic)
  * who showed that it was trivial to patch v0.2.2 to decrease the minSDK from 21 to 19
  * who has a [PR](https://github.com/JaneaSystems/nodejs-mobile/pull/291) to show that it's become much more complicated to patch v0.3.2 to decrease the minSDK from 21 to 19
* it makes some changes to:
  * the gradle build scripts
  * the app icon
  * the layout and welcome message in MainActivity

#### Technical Details:

* Node.js for Mobile Apps v0.3.1
  * binaries:
    * [64-bit](https://github.com/JaneaSystems/nodejs-mobile/releases/tag/nodejs-mobile-v0.3.1)
      * minSDK = [21](https://github.com/janeasystems/nodejs-mobile/blob/nodejs-mobile-v0.3.1/android-configure#L58) (Android 5.0 Lollipop)
  * versions:
    * NodeJS = 12.16.3
    * OpenSSL = 1.1.1g
* Node.js for Mobile Apps v0.2.2
  * binaries:
    * [32-bit](https://github.com/Informatic/nodejs-mobile-react-native/commit/b1986b66bf976d7744d2d816049cf72a1db4c42e)
      * minSDK = [19](https://github.com/JaneaSystems/nodejs-mobile/issues/103#issuecomment-586942512) (Android 4.4 KitKat)
  * versions:
    * NodeJS = 10.13.0
    * OpenSSL = 1.1.0i
* no root

#### List of Permissions:

* android.permission.INTERNET

#### Legal:

* copyright: [Warren Bank](https://github.com/warren-bank)
* license: [GPL-2.0](https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt)
