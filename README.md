# react-native-pinned-mode


A lightweight React Native library that enables developers to easily configure and control **Android’s Pinned Mode**.

With this package, you can:

- Lock your app to the foreground.

- Prevent users from leaving the app unintentionally.

- Ensure uninterrupted focus on a single app — ideal for kiosk-style flows, presentations, or restricted-use scenarios.

  

> ⚠️ **Note:** This package is **Android only**.

  

---

  

## 📖 What is Pinned Mode?

**Pinned Mode** (introduced in Android 5.0 Lollipop) allows you to lock your app to the foreground so users cannot switch to another app accidentally.

  

- Unlike **Kiosk Mode**, Pinned Mode does **not** require device owner privileges or enterprise management tools.

- Users can exit Pinned Mode with a **specific key combination** (usually *Back + Overview/Recent Apps buttons*).

- This makes it lightweight and suitable for **temporary focus locking**, such as:

- Payment terminals

- Customer feedback apps

- Single-task flows (like exams or demos)

  

Pinned Mode ensures the app stays in focus while still giving users a way to exit if needed — making it **less restrictive than full Kiosk Mode**.

  

---



## 📦 Installation


```sh
npm install react-native-pinned-mode
```


## ⚡ Usage


```js
import {
  enablePinnedMode,
  disablePinnedMode,
  isPinnedModeActive,
} from 'react-native-pinned-mode';

const handlePinnedMode = async () => {
  try {
    const active = await isPinnedModeActive();
    if (!active) {
      await enablePinnedMode();   // Enable pinned mode
    } else {
      await disablePinnedMode();  // Disable pinned mode
    }
  } catch (e) {
    console.log("Pinned Mode Error:", e);
  }
};
```

## 🚀 Publishing to Play Store

When using Pinned Mode, apps are generally **allowed on the Play Store** because:

- It is an **official Android API**.

- Users always have a **system-level way to exit**.

  

✅ Best practices for publishing:

- Clearly explain the use case in your app description if Pinned Mode is a **core feature**.

- Avoid presenting it as "locking users" permanently — emphasize **focus and security**.

- Ensure your app behaves gracefully when Pinned Mode is exited.

  

---

  

## 🍎 iOS Guidance

Pinned Mode is an **Android-only feature**. iOS does not provide an equivalent API in React Native.

  

However, iOS has:

-  **Guided Access** → A system-level feature that lets users lock the device to a single app. This is controlled by the **device owner** (via accessibility settings), not by the app.

-  **MDM (Mobile Device Management) / Single App Mode** → Enterprise-level solution to lock devices into a single app.

  

👉 Developers cannot enable Guided Access or Single App Mode programmatically from within an iOS app. For apps requiring similar restrictions on iOS, you’ll need to **instruct users/admins** to enable Guided Access or use MDM solutions.

  

---

  

## 📌 Example Use Cases

-  **Customer feedback apps** in stores.

-  **Payment terminals** where accidental exits should be avoided.

-  **Exam/test apps** to prevent switching apps.

-  **Single-purpose enterprise apps**.

  

---


## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---

