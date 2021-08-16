#include <stdio.h>
#define LENGTH 256

main() {
    int bucket[LENGTH];
    int i;
    int c;

    for (i = 0; i < LENGTH; i++) 
        bucket[i] = 0;

    while((c = getchar()) != EOF) {
        bucket[c] += 1;
    }

    for (i = 0; i < LENGTH; i++) {
        if (bucket[i] != 0)
            printf("%c: %d\t", i, bucket[i]);
    }
}
