#include <stdio.h>
#define MAXLINE 1000

int get_line(char line[], int max);
int strend(char *s, char *t);

int main(int argc, char const *argv[])
{
    char s[MAXLINE], t[MAXLINE];
    while (1) {
        printf("Input string: \n");
        while (!get_line(s, MAXLINE)) printf("error: invalid input.\n");
        printf("Input another string: \n");
        while (!get_line(t, MAXLINE)) printf("error: invalid input.\n");

        printf("String t: %s is at the end of string s: %s (T/F): %s\n", s, t, strend(s, t) ? "True" : "False");
    }    

    return 0;
}


int strend(char *s, char *t) {
    char *start_t = t;
    char *start_s = s;
    while (*s && *t) {s++; t++;}
    while (*s) s++;
    while (*t) t++;
   
    while (*--s== *--t && t > start_t && s > start_s);

    if (t == start_t) return 1;
    else return 0;
}

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
