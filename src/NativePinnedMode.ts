import { TurboModuleRegistry, type TurboModule } from 'react-native';

export interface Spec extends TurboModule {
  enablePinnedMode(): Promise<boolean>;
  disablePinnedMode(): Promise<boolean>;
  isPinnedModeActive(): boolean;
}

export default TurboModuleRegistry.getEnforcing<Spec>('PinnedMode');
