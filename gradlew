#!/usr/bin/env bash
set -euo pipefail

GRADLE_VERSION="8.2.1"
GRADLE_BASE_DIR="${GRADLE_USER_HOME:-$HOME/.gradle}"
GRADLE_DOWNLOAD_DIR="${GRADLE_BASE_DIR}/wrapper/dists"
GRADLE_DIST_DIR="${GRADLE_DOWNLOAD_DIR}/gradle-${GRADLE_VERSION}-bin"
GRADLE_DIST_ZIP="${GRADLE_DIST_DIR}/gradle-${GRADLE_VERSION}-bin.zip"
GRADLE_UNPACK_DIR="${GRADLE_DIST_DIR}/gradle-${GRADLE_VERSION}"
GRADLE_BIN="${GRADLE_UNPACK_DIR}/bin/gradle"

if [[ ! -x "$GRADLE_BIN" ]]; then
  mkdir -p "$GRADLE_DIST_DIR"
  if [[ ! -f "$GRADLE_DIST_ZIP" ]]; then
    echo "Downloading Gradle ${GRADLE_VERSION}..."
    curl -L -o "$GRADLE_DIST_ZIP" "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
  fi
  echo "Extracting Gradle ${GRADLE_VERSION}..."
  unzip -q -o "$GRADLE_DIST_ZIP" -d "$GRADLE_DIST_DIR"
fi

exec "$GRADLE_BIN" "$@"
