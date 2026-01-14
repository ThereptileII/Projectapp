# Renovate Glass

Renovate Glass is a minimalist home renovation companion app with a liquid-glass aesthetic. The Android app ships with a dashboard, tasks, shopping list, and project creation screens powered by local HTML templates, along with two premium widgets for at-a-glance progress and task tracking.

## Highlights
- Four liquid-glass screens (Dashboard, Tasks, Shopping, Create) rendered inside native tabs.
- App logo and splash screen aligned to the neon-glass visual system.
- Two Android widgets: Project Progress and Today's Tasks.

## Build APK
The repository includes a lightweight Gradle launcher script that downloads Gradle on first run.

```bash
./gradlew assembleRelease
```

The GitHub Actions workflow builds the release APK and uploads it as an artifact.
