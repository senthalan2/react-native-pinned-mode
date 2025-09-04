# react-native-pinned-mode

react-native-pinned-mode is a React Native library that enables developers to easily configure and control Android’s Pinned Mode. With this package, you can lock your app to the foreground and prevent users from leaving the app unintentionally — making it useful for scenarios where uninterrupted focus on a single app is required.

## Installation


```sh
npm install react-native-pinned-mode
```


## Usage


```js
import {
  enablePinnedMode,
  disablePinnedMode,
  isPinnedModeActive,
} from 'react-native-pinned-mode';

// ...

const handlePinnedMode = async () => {
    try {
      console.log(isPinnedModeActive(), 'Is Pinned Mode Active');
      if (!isPinnedModeActive()) {
        await enablePinnedMode();
      } else {
        await disablePinnedMode();
      }
    } catch (e) {
      console.log(e, 'Error');
    }
  };
```


## Contributing

- [Development workflow](CONTRIBUTING.md#development-workflow)
- [Sending a pull request](CONTRIBUTING.md#sending-a-pull-request)
- [Code of conduct](CODE_OF_CONDUCT.md)

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
