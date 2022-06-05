#include <stdio.h>
#include <stdlib.h>

int get_line(char line[], int max) {
    int c, i;

    for (i = 0; i < max - 1 
        && (c=getchar()) != EOF && c != '\n'; i++ )
            line[i] = c;
    if (c == '\n') {
        line[i] = c;
        i++;
    }

    line[i] = '\0';
    return i;

}
