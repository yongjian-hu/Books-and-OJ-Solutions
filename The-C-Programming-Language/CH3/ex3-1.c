#include <stdio.h>

/** Mine version
int binsearch(int x, int v[], int n) {
    int low, high, mid;

    low = 0;
    high = n - 1;
    while (low < high - 1) {
        mid = (low+high)/2;
        if (x < v[mid])
            high = mid - 1;
        else
            low = mid;
    }
    if (low == high)
        if (v[low] == x) return low;
        else return 0;
    
    if (v[low] == x) return low;
    else if (v[high == x]) return high;
    else return 0;
}
*/

// This is better
int binsearch(int x, int v[], int n)
{
    int low, high, mid;

    low = 0;
    high = n - 1;
    while (low < high) {
        mid = (low + high) / 2;
        if (x <= v[mid])
            high = mid;
        else
            low = mid + 1;
    }
    return (x == v[low]) ? low : -1;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    printf("%d\n", binsearch(1, arr, 1));
    printf("%d\n", binsearch(2, arr, 5));
    printf("%d\n", binsearch(3, arr, 5));
    printf("%d\n", binsearch(4, arr, 5));
    printf("%d\n", binsearch(5, arr, 5));
    return 0;
}
