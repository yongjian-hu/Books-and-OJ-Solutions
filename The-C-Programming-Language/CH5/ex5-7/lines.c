#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "lines.h"

int readlines(char *lineptr[], int maxlines) {
    int len, nlines;
    char *p, line[MAXLEN];
    
    nlines = 0;
    while ((len = get_line(line)) > 0)
        if (nlines >= maxlines || (p = malloc(len)) == NULL)
            return -1;
        else {
            line[len - 1] = '\0'; 
            strcpy(p, line);
            lineptr[nlines++] = p;
            // strcpy(lineptr[nlines++], line);
        }
    return nlines; 
}

void writelines(char *lineptr[], int nlines) {
    int i;
    for (i = 0; i < nlines; i++)
        printf("%s\n", lineptr[i]);
} 

int get_line(char line[]) {
    int c, i;

    for (i = 0; i < MAXLEN - 1 
        && (c=getchar()) != EOF && c != '\n'; i++ )
            line[i] = c;
    if (c == '\n') {
        line[i] = c;
        i++;
    }

    line[i] = '\0';
    return i;

}
