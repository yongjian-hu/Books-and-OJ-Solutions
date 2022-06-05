#include <stdio.h>

int _strncmp(char *s, char *t, int n) {
    while (n-- > 0 && (*s++ == *t++))
     if (n == 0 || *s == 0 || *t == 0)
        return 0;
   
    return *s - *t;
}
