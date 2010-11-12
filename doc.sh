#!/bin/bash
pandoc manual.md -o manual.html --toc -c styles.css --template template.html;

osascript -e 'tell application "Firefox" to activate';