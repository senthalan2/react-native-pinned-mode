declare module 'react-native-pinned-mode' {
    export function enablePinnedMode(): Promise<boolean>;
    export function disablePinnedMode(): Promise<boolean>;
    export function isPinnedModeActive(): boolean;
}
