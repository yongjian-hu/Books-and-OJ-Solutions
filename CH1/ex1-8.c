#include <stdio.h>

main() {
    int c, n_sp = 0, nt = 0, ne = 0;

    while ((c = getchar()) != EOF) {
        switch (c) {
            case ' ':
                ++n_sp;
                break;
            case '\t':
                ++nt;
                break;
            case '\n':
                ++ne;
                break;
            default:
                break;
        }
    }
    printf("Spaces, tabular, enter: %d, %d, %d.\n", n_sp, nt, ne);
}
