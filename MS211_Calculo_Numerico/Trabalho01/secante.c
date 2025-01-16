#include <stdio.h>
#include <string.h>
#include <math.h>

#define funcao(p) (p*p*p + p*p - 3*sinf(p))

/**
 * @brief Calcula o valor de xk aproximado para o qual a funcao x^3 + x^2 -3sen(x) = 0 no intervalo dado
 * 
 * @param x0 float que indica um valor para o comeco
 * @param x1 float que indica um valor para o comeco
*/
float secante(float x0, float x1){
    float xk_menos1, xk, xk_mais1;

    xk = x1;
    xk_menos1 = x0;

    while(fabs(xk - xk_menos1) >= 0.01 && fabs(funcao(xk)) >= 0.01){

        xk_mais1 = xk - funcao(xk)*((xk - xk_menos1)/(funcao(xk) - funcao(xk_menos1)));
        printf("xk = %f; xk-1 = %f; xk+1 = %f\n", xk, xk_menos1, xk_mais1);

        xk_menos1 = xk;

        xk = xk_mais1;
    }

    return xk;
}



int main(){

    printf("intervalo [-2; -1,5]: %f\n", secante(-1.75, -1.8));
    printf("intervalo [-0,2; 0,2]: %f\n", secante(-0.1, -0.05));
    printf("intervalo [1; 1,4]: %f\n", secante(1.05, 1.1));

    return 0;
}