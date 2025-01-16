#include <stdio.h>
#include <string.h>
#include <math.h>

/**
 * @brief Calcula o valor de xk aproximado para o qual a funcao x^3 + x^2 -3sen(x) = 0 no intervalo dado
 * 
 * @param min float que indica o menor valor de x no intervalo
 * @param max float que indica o maior valor de x no intervalo
*/
float bissec(float min, float max, int cres){
    float a, b;
    float xk;
    a = min;
    b = max;
    xk = (a + b)/2;

    while(fabs(a - b) >= 0.01 && fabs(xk*xk*xk + xk*xk - 3*sinf(xk)) >= 0.01){
        if(cres == 1 && (xk*xk*xk + xk*xk - 3*sinf(xk)) > 0){
            b = xk;
            xk = (a + b)/2;
        } else if(cres == 1 && (xk*xk*xk + xk*xk - 3*sinf(xk)) < 0){
            a = xk;
            xk = (a + b)/2;
        } else if(cres == 1 && (xk*xk*xk + xk*xk - 3*sinf(xk)) > 0){
            a = xk;
            xk = (a + b)/2;
        } else{
            b = xk;
            xk = (a + b)/2;
        }
        printf("xk = %f; a = %f; b = %f\n", xk, a, b);
    }

    return xk;
}



int main(){

    printf("intervalo [-2; -1,5]: %f\n", bissec(-2, -1.5, 1));
    printf("intervalo [-0,2; 0,2]: %f\n", bissec(-0.2, 0.2, 0));
    printf("intervalo [1; 1,4]: %f\n", bissec(1, 1.4, 1));

    return 0;
}