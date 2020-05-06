#include <iostream>
#include <math.h>

using namespace std;

int main(int argc, const char **argv)
{
    int nr_R, nr_K;

    cout << "Numri i rreshtave :";
    cin >> nr_R;
    cout << "Numri i koloave :";
    cin >> nr_K;

    float tabela[nr_R][nr_K];
    float tabela1[nr_R][nr_K];
    float total = 0;
    float shuma_rreshtave[nr_R];
    float shuma_kolonave[nr_K];

    for (int i = 0; i < nr_R; i++)
    {
        for (int j = 0; j < nr_K; j++)
        {
            cin >> tabela[i][j];
        }
    }

    for (int i = 0; i < nr_R; i++)
    {
        float sum = 0;
        for (int j = 0; j < nr_K; j++)
        {
            sum += tabela[i][j];
            total += tabela[i][j];
            cout << tabela[i][j] << " ";
        }
        shuma_rreshtave[i] = sum;
        cout << endl;
    }
    cout << "=======================================" << endl;
    for (int j = 0; j < nr_K; j++)
    {
        float sum = 0;
        for (int i = 0; i < nr_R; i++)
        {
            sum += tabela[i][j];
        }
        shuma_kolonave[j] = sum;
    }
    cout << "=======================================" << endl;
    for (int i = 0; i < nr_R; i++)
    {
        for (int j = 0; j < nr_K; j++)
        {
            tabela1[i][j] = shuma_rreshtave[i] * shuma_kolonave[j] / total;
            cout << tabela1[i][j] << " ";
        }
        cout << endl;
    }
    cout << "=======================================" << endl;
    float chi = 0;
    for (int i = 0; i < nr_R; i++)
    {
        for (int j = 0; j < nr_K; j++)
        {
            chi += pow((tabela[i][j] - tabela1[i][j]), 2) / tabela1[i][j];
        }
    }
    cout << "Chi-statistic: " << chi << endl;
    cout << "df: " << (nr_K - 1) * (nr_R - 1);

    return 0;
}