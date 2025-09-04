import PinnedMode from './NativePinnedMode';

export function enablePinnedMode(): Promise<boolean> {
  return PinnedMode.enablePinnedMode();
}

export function disablePinnedMode(): Promise<boolean> {
  return PinnedMode.disablePinnedMode();
}

export function isPinnedModeActive(): boolean {
  return PinnedMode.isPinnedModeActive();
}
