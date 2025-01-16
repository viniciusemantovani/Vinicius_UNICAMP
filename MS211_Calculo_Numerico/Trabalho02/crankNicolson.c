//Crank-Nicolson Method Code, by: Vinicius Esperanca Mantovani

#include <stdlib.h>
#include <stdio.h>

//Defined values to be used:
#define f(x,y) (((1 - h)*y + h)/(1+h)) //Define the function wanted here!


struct eulerVectors
{
    float X[9];
    float Y[9];
};

struct eulerVectors *cN(float X0, float Y0, float h, float n){
    struct eulerVectors *vectors = malloc(sizeof(struct eulerVectors));
    vectors->X[0] = X0;
    vectors->Y[0] = Y0;

    for(int i = 0; i <= n - 1; i++){
        vectors->Y[i + 1] = f(vectors->X[i],vectors->Y[i]);
        vectors->X[i + 1] = vectors->X[i] + h;
    }

    return vectors;
}

int main(int argc, char *argv){

    float h = 0.5;
    float n = 8;
    float X0 = -1; //Define the first value of X wanted here! In our case: a) -1
    float Y0 = 1; //Define the first value of Y wanted here! In our case: a) 1

    struct eulerVectors *vectors = cN(X0, Y0, h, n);

    printf("(x,y) points of the curve\n");
    printf("(%.3f, %.3f) ; ", X0, Y0);

    for(int i = 1; i <= n; i++){
        printf("(%.4f, %.4f) ; ", vectors->X[i], vectors->Y[i]);
    }
    return 0;
}