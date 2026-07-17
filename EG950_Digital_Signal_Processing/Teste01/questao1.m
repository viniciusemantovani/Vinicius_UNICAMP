%ITEM C:

hs = [2 -5 4 -1];
hp = [3 -3 1];
x = [1 -1 0 2];

N_s = length(x) + length(hs) - 1;
N_p = length(x) + length(hp) - 1;

hs_x = conv(x,hs)
hp_x = conv(x,hp)

ns = [0:length(hs_x)-1];
np = [0:length(hp_x)-1];

figure();
stem(ns,hs_x)
title("Série - Convolução");
ylabel("x*hs");
xlabel("n")

figure();
stem(np,hp_x)
title("Paralelo - Convolução");
ylabel("x*hp");
xlabel("n")

%ITEM D:

dft_hs = fft(hs, N_s)
dft_hp = fft(hp, N_p)

ns = [0:length(dft_hs)-1];
np = [0:length(dft_hp)-1];

figure();

subplot(2,1,1);
stem(ns,abs(dft_hs))
title("Série - mod DFT")
ylabel("Magnitude");
xlabel("n")

subplot(2,1,2);
stem(ns,unwrap(angle(dft_hs)))
title("Série - fase DFT");
ylabel("Fase");
xlabel("n")

figure();

subplot(2,1,1);
stem(np,abs(dft_hp))
title("Paralelo - mod DFT")
ylabel("Magnitude");
xlabel("n")

subplot(2,1,2);
stem(np,unwrap(angle(dft_hp)))
title("Paralelo - fase DFT");
ylabel("Fase");
xlabel("n")

%ITEM E:

dft_x = fft(x)
nx = [0:length(dft_x)-1];

figure();

subplot(2,1,1);
stem(nx,abs(dft_x))
title("Entrada - mod DFT");
ylabel("Magnitude");
xlabel("n");

subplot(2,1,2);
stem(nx,unwrap(angle(dft_x)))
title("Entrada - fase DFT");
ylabel("Fase");
xlabel("n");

% ITEM F E G:

dft_x = fft(x, N_s);
Ys_item_f = dft_hs.*dft_x

dft_x = fft(x, N_p);
Yp_item_f = dft_hp.*dft_x

%Ys
figure();

subplot(2,1,1);
nYs = [0:length(Ys_item_f)-1];
stem(nYs, abs(Ys_item_f));
title("Comparação Ys - MAGNITUDE");
ylabel("MAGNITUDE");
xlabel("n");
hold on;
Ys_item_c = fft(hs_x)
nYs = [0:length(Ys_item_c)-1];
stem(nYs - 0.1, abs(Ys_item_c)); % Defasagem adicionada apenas para visualizacao
legend("Ys item f", "Ys item c");

subplot(2,1,2);
nYs = [0:length(Ys_item_f)-1];
stem(nYs, unwrap(angle(Ys_item_f)));
title("Comparação Ys - FASE");
ylabel("Fase");
xlabel("n");
hold on;
nYs = [0:length(Ys_item_c)-1];
stem(nYs - 0.1, unwrap(angle(Ys_item_c))); % Defasagem adicionada apenas para visualizacao
legend("Ys item f", "Ys item c");

%Yp
figure();

subplot(2,1,1);
nYp = [0:length(Yp_item_f)-1];
stem(nYp, abs(Yp_item_f));
title("Comparação Yp - MAGNITUDE");
ylabel("MAGNITUDE");
xlabel("n");
hold on;
Yp_item_c = fft(hp_x)
nYp = [0:length(Yp_item_c)-1];
stem(nYp - 0.1, abs(Yp_item_c)); % Defasagem adicionada apenas para visualizacao
legend("Yp item f", "Yp item c");

subplot(2,1,2);
nYp = [0:length(Yp_item_f)-1];
stem(nYp, unwrap(angle(Yp_item_f)));
title("Comparação Yp - FASE");
ylabel("Fase");
xlabel("n");
hold on;
nYp = [0:length(Yp_item_c)-1];
stem(nYp - 0.1, unwrap(angle(Yp_item_c))); % Defasagem adicionada apenas para visualizacao
legend("Yp item f", "Yp item c");