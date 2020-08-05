#include <stdio.h>
#define MAX 30
#define OUT 0
#define IN 1
main() {
    int bucket[30];
    int c;
    int state = IN;
    int n = 0; // counter

    for (int i = 0; i < MAX; i++) {
        bucket[i] = 0;
    }

    while ((c=getchar()) != EOF) {
        if (c == ' ' || c == '\t' || c == '\n') {
            state = OUT;
            if (n != 0)
                bucket[n]++;
            n = 0;
        } else if (state == OUT) {
            state = IN;
        }
        if (state == IN) n++;
    }

    printf("====Histogram====\n");
    for (int i = 0; i < MAX; i++) {
        if (bucket[i] != 0) {
            printf("%2d: ", i);
            for (int j = bucket[i]; j > 0; j--) {
                printf("o");
            }
            printf("\n");
        }
        
    }
}
