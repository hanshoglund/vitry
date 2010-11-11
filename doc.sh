#!/bin/bash
pandoc manual.md -o manual.html --toc -c styles.css --template template.html;
#markdown2pdf manual.md;

osascript -e 'tell application "Firefox" to activate';