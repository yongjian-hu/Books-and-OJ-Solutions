#include <stdio.h>

char *_strncpy(char *s, char *t, int n) {
    if (!t) {
        printf("error: string not exits.\n");
        return NULL;
    }

    while (n-- > 0 && (*s++ = *t++));

    return s;
}
