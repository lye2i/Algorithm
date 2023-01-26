#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

long long solution(int w, int h) {
    long long block = 0;
    for(int i=0; i<h; i++){
        block += (long long)i*w/h;
    }
    return 2*block;
}