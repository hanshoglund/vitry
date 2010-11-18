rm manual.pdf;
markdown2pdf manual.md --template template.tex -N;
 
open manual.pdf;
#osascript -e 'tell application "Preview" to activate';
