#include <stdio.h>
#define OUT 1
#define IN 0
main() {
    int c;
    int state = IN;
    while ((c=getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            state = OUT;
        } else if (state == OUT) {
            state = IN;
            putchar('\n');
        }
        putchar(c);
    }
}
