#include <stdio.h>

char *_strncat(char *s, char *t, int n) {
    if(!t) {
        printf("error: string t not exits.\n");
        return NULL;
    }
    while(*s) s++;
    while(n-- > 0 && (*s++ = *t++));
    return s;
}
