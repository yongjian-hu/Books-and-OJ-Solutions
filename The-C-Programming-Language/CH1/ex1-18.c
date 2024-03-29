#include <stdio.h>
#define MAXLINE 1000

int get_line(char line[], int maxline);
int trim(char s[], int len);

int main() {
   int len;
   int max;
   char line[MAXLINE];
   char longest[MAXLINE];

   max = 0;
   while ((len = get_line(line, MAXLINE)) > 0) {
       printf("%s", line);
       len = trim(line, len);
       printf("After tirm: %s", line);
   }
   return 0;
}

int get_line(char s[], int lim) {
    int c, i;
    for (i = 0; i<lim-1 && (c=getchar()) != EOF && c !='\n'; ++i)
        s[i] = c;
    if (c == '\n') {
        s[i] = c;
        ++i;
    }
    s[i] = '\0';
    return i;
}

int trim(char s[], int len) {
    int i;
    for (i = len - 1; i > 0 && ( s[i] == '\n' || s[i] == '\t' || s[i] == ' ' ); i--) {
        s[i] = '\0';
    }
    if (i < len - 1) s[i+1] = '\n';
    return i;
}
