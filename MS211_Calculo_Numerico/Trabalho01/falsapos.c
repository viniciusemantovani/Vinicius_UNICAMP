#include <stdio.h>
#include <string.h>
#include <math.h>

#define funcao(p) (p*p*p + p*p - 3*sinf(p))

/**
 * @brief Calcula o valor de xk aproximado para o qual a funcao x^3 + x^2 -3sen(x) = 0 no intervalo dado
 * 
 * @param min float que indica o menor valor de x no intervalo
 * @param max float que indica o maior valor de x no intervalo
*/
float falsapos(float min, float max, int cres){
    float a, b;
    float xk;
    a = min;
    b = max;
    xk = (fabs(funcao(b))*a + fabs(funcao(a))*b)/(fabs(funcao(b)) + fabs(funcao(a)));


    while(fabs(a - b) >= 0.01 && fabs(funcao(xk)) >= 0.01){
        if(cres == 1 && (funcao(xk)) > 0){
            b = xk;
            xk = (fabs(funcao(b))*a + fabs(funcao(a))*b)/(fabs(funcao(b)) + fabs(funcao(a)));
        } else if(cres == 1 && (funcao(xk)) < 0){
            a = xk;
            xk = (fabs(funcao(b))*a + fabs(funcao(a))*b)/(fabs(funcao(b)) + fabs(funcao(a)));
        } else if(cres == 1 && (funcao(xk)) > 0){
            a = xk;
            xk = (fabs(funcao(b))*a + fabs(funcao(a))*b)/(fabs(funcao(b)) + fabs(funcao(a)));
        } else{
            b = xk;
            xk = (fabs(funcao(b))*a + fabs(funcao(a))*b)/(fabs(funcao(b)) + fabs(funcao(a)));
        }
        printf("xk = %f; a = %f; b = %f\n", xk, a, b);
    }

    return xk;
}



int main(){

    printf("intervalo [-2; -1,5]: %f\n", falsapos(-2, -1.5, 1));
    printf("intervalo [-0,2; 0,2]: %f\n", falsapos(-0.2, 0.2, 0));
    printf("intervalo [1; 1,4]: %f\n", falsapos(1, 1.4, 1));

    return 0;
}