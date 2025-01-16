%Open Archives
% ----------------------------------------------------------------------------
[data_train fs_train] = audioread("train.wav");
[data_gong fs_gong] = audioread("gong.wav");
[data_Handel fs_Handel] = audioread("Handel.wav");
[data_laughter fs_laughter] = audioread("laughter.wav");
[data_splat fs_splat] = audioread("splat.wav");

% Compute and Plot the FFT of the train
% ----------------------------------------------------------------------------
n_train = length(data_train);
f_train = (0:floor(n_train/2)-1) * (fs_train / n_train);
plotFFT(data_train, f_train, n_train, "train", "");

% Perform FFT
train_fft = fft(data_train);

% Suppress samples with absolute values less than 0.001
train_fft(abs(train_fft) < 1052.545*10^(-2)) = 0;

% Inverse FFT to get the compressed audio signal
compresses_train = ifft(train_fft, 'symmetric');

% Save the audio
audiowrite('compresses_train.wav', compresses_train, fs_train);

% Plot the FFT after compression
plotFFT(compresses_train, f_train, n_train, "train", "compresses");

% Compute and Plot the FFT of the gong
% ----------------------------------------------------------------------------
n_gong = length(data_gong);
f_gong = (0:floor(n_gong/2)-1) * (fs_gong / n_gong);
plotFFT(data_gong, f_gong, n_gong, "gong", "");

% Perform FFT
gong_fft = fft(data_gong);

gong_fft(abs(gong_fft) < 2323.765*10^(-2)) = 0;

% Inverse FFT to get the compressed audio signal
compresses_gong = ifft(gong_fft, 'symmetric');

% Save the audio
audiowrite('compresses_gong.wav', compresses_gong, fs_gong);

% Plot the fft after compression
plotFFT(compresses_gong, f_gong, n_gong, "gong", "compresses");

% Compute and Plot the FFT of the handel
% ----------------------------------------------------------------------------
n_Handel = length(data_Handel);
f_Handel = (0:floor(n_Handel/2)-1) * (fs_Handel / n_Handel);
plotFFT(data_Handel, f_Handel, n_Handel, "Handel", "");

% Perform FFT
Handel_fft = fft(data_Handel);

Handel_fft(abs(Handel_fft) < 4332.735*10^(-2)) = 0;

% Inverse FFT to get the compressed audio signal
compresses_Handel = ifft(Handel_fft, 'symmetric');

% Save the audio
audiowrite('compresses_Handel.wav', compresses_Handel, fs_Handel);

% Plot the fft after compression
plotFFT(compresses_Handel, f_Handel, n_Handel, "Handel", "compresses");

% Compute and Plot the FFT of the laughter
% ----------------------------------------------------------------------------
n_laughter = length(data_laughter);
f_laughter = (0:floor(n_laughter/2)-1) * (fs_laughter / n_laughter);
plotFFT(data_laughter, f_laughter, n_laughter, "laughter", "");

% Perform FFT
laughter_fft = fft(data_laughter);

laughter_fft(abs(laughter_fft) < 108.145*10^(-2)) = 0;

% Inverse FFT to get the compressed audio signal
compresses_laughter = ifft(laughter_fft, 'symmetric');

% Save the audio
audiowrite('compresses_laughter.wav', compresses_laughter, fs_laughter);

% Plot the fft after compression
plotFFT(compresses_laughter, f_laughter, n_laughter, "laughter", "compresses");

% Compute and Plot the FFT of the splat
% ----------------------------------------------------------------------------
n_splat = length(data_splat);
f_splat = (0:floor(n_splat/2)-1) * (fs_splat / n_splat);
plotFFT(data_splat, f_splat, n_splat, "splat", "");

% Perform FFT
splat_fft = fft(data_splat);

splat_fft(abs(splat_fft) < 293.971*10^(-2)) = 0;

% Inverse FFT to get the compressed audio signal
compresses_splat = ifft(splat_fft, 'symmetric');

% Save the audio
audiowrite('compresses_splat.wav', compresses_splat, fs_splat);

% Plot the fft after compression
plotFFT(compresses_splat, f_splat, n_splat, "splat", "compresses");

% ---------------------------------------------------------------------------- 
% Function for plotting FFTs
% ----------------------------------------------------------------------------
function [] = plotFFT(signal, f, n, signal_name, filter_name)

    signal_fft = fft(signal);
    signal_fft = signal_fft(1:floor(n/2));
    
    % Magnitude of the FFT
    magnitude = abs(signal_fft);
    
    % Plot the FFT
    figure;
    plot(f, magnitude);
    xlabel('Frequency (Hz)');
    ylabel('Magnitude');
    title(sprintf('FFT of %s audio %s', signal_name, filter_name));

end