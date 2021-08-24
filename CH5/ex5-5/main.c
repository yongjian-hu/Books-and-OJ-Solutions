#include <stdio.h>
#define MAXLINE 1000

char *_strncpy(char *s, char *t, int n);
char *_strncat(char *s, char *t, int n);
int _strncmp(char *s, char *t, int n);

int get_line(char line[], int max);

int main(int argc, char const *argv[])
{
    char *t = "Test string.";
    char s[MAXLINE];
    // strncpy
    _strncpy(s, t, 4);
    printf("strncpy: %s\n", s);
    // strncat
    _strncat(s, t, 6);
    printf("strncat: %s\n", s);
    // strncmp
    printf("strncmp: %d (n = 3)\n", _strncmp(s, t, 3));
    printf("strncmp: %d (n = 4)\n", _strncmp(s, t, 4));
    printf("strncmp: %d (n = 5)\n", _strncmp(s, t, 5));
    printf("strncmp: %d (n = 6)\n", _strncmp(s, t, 6));
    printf("strncmp: %d (TestTestTest, n = 10) \n", _strncmp(s, "TestTestTest", 10));

    return 0;
}
