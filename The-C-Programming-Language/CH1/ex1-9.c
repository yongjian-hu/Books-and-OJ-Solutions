#include <stdio.h>
main() {
    int c, prev_c;
    c = getchar();
    prev_c = c;
    while (c != EOF) {
        if (c != ' ' || prev_c != ' ')
            putchar(c);
        prev_c = c;
        c = getchar();
    }
}
