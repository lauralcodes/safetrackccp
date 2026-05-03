#!/usr/bin/env sh
set -eu

if command -v mvn >/dev/null 2>&1; then
  exec mvn "$@"
fi

echo "Error: Maven (mvn) is not installed or not on PATH." >&2
echo "Install Maven or add the Maven Wrapper files, then retry." >&2
exit 127

