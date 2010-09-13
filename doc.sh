#!/bin/bash
pandoc manual.md -o manual.html -s --toc -c styles.css
markdown2pdf manual.md