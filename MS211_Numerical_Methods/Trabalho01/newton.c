#include <stdio.h>
#include <string.h>
#include <math.h>

#define funcao(p) (p*p*p + p*p - 3*sinf(p))
#define derfunc(p) (3*p*p + 2*p - 3*cosf(p))

/**
 * @brief Calcula o valor de xk aproximado para o qual a funcao x^3 + x^2 -3sen(x) = 0 no intervalo dado
 * 
 * @param x0 float que indica um valor para o comeco
*/
float newton(float x0){
    float xk_menos1, xk;
    xk_menos1 = x0;

    xk = xk_menos1 - (funcao(xk_menos1)/derfunc(xk_menos1));

    printf("xk = %f; xk-1 = %f\n", xk, xk_menos1);

    while(fabs(xk - xk_menos1) >= 0.01 && fabs(funcao(xk)) >= 0.01){

        xk_menos1 = xk;
        xk = xk_menos1 - (funcao(xk_menos1)/derfunc(xk_menos1));

        printf("xk = %f; xk-1 = %f\n", xk, xk_menos1);

    }

    return xk;
}



int main(){

    printf("intervalo [-2; -1,5]: %f\n", newton(-1.75));
    printf("intervalo [-0,2; 0,2]: %f\n", newton(0.05));
    printf("intervalo [1; 1,4]: %f\n", newton(1.2));

    return 0;
}