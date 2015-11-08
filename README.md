# AQTest: asynchronous query from web worker to native Android code using XHR

Author: Christopher J. Brody

License: UNLICENSE (public domain)

I can hereby testify that this project is completely my own work and not subject to agreements with any other parties.
In case of code written under direct guidance from sample code the link is given for reference.
In case I accept contributions from any others I will require CLA with similar statements.

## About

This project demonstrates the following:
- Ability to request native Android functionality from within a web worker.
- Build a hybrid Javascript-native app without using a framework such as Cordova which requires attribution of use.

The interaction between Javascript and native Java works as follows:
- The Javascript executes a simple XHR POST with a `file:` or custom URI
- The Java sees URL request and triggers the Javascript `aqcallback` function with a string that echos the URI from the XHR request

This project also has an `AQManager` component that keeps and handles the routing for multiple components that implement the `AQHandler` interface.

This project is a starting point for the following ideas (so far):
- Javascript-native interface that can be used from a web worker within Cordova, such as: [@brodybits / cordova-aqs-android](https://github.com/brodybits/cordova-aqs-android) and [@brodybits / cordova-aqs-ios](https://github.com/brodybits/cordova-aqs-ios)
- Provide a sqlite database access layer for Javascript that can be used within multiple Javascript-native bridging frameworks including Cordova, React Native, and NativeScript
- Provide a public-domain Javascript-native access bridge

## Security warning

The Cordova project has been fixing security issues in its external domain whitelist plugin over time, and has also dealt with security issues in its internal bridging mechanism. It is very strongly advised NOT to release an app with a custom-built web view bridging or domain whitelisting mechanism without proper code review and testing.

## Other major limitations

- There is no general message queueing. The idea is currently let each component implement its own queueing mechanism.

## Related project(s)

- [@brodybits / aqsa-query-test-ios](https://github.com/brodybits/aqsa-query-test-ios) - request native iOS functionality from within a web worker
- [@brodybits / cordova-aqs-android](https://github.com/brodybits/cordova-aqs-android) and [@brodybits / cordova-aqs-ios](https://github.com/brodybits/cordova-aqs-ios)


A similar concept described in my [Starting JSONBus: towards a replacement for Cordova/PhoneGap](http://brodyspark.blogspot.com/2012/12/starting-jsonbus-towards-replacement.html) post on an old blog in December 2012.
