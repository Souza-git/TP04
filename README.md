# TP04

#### Classe `Criptografia`

A classe `Criptografia` implementa funções para cifrar e decifrar dados utilizando duas operações de embaralhamento: substituição e transposição. A chave criptográfica utilizada é uma string fixa definida dentro da classe.

-   **Substituição** (`substituir()` e `substituirInverso()`):
    
    -   A operação de substituição embaralha os dados permutando os bytes de acordo com uma tabela gerada a partir da chave criptográfica. Cada byte é substituído por outro byte determinado pela chave.
-   **Transposição** (`transpor()` e `transporInverso()`):
    
    -   A operação de transposição rearranja os bytes dos dados de acordo com o índice calculado usando a chave criptográfica. Isso resulta em uma permutação dos bytes baseada na posição na sequência de dados.
-   **Cifragem Completa** (`cifrar()` e `decifrar()`):
    
    -   A função `cifrar()` aplica primeiro a substituição e depois a transposição nos dados para garantir maior segurança na criptografia.
    -   A função `decifrar()` realiza a operação inversa, aplicando primeiro a transposição inversa e depois a substituição inversa para recuperar os dados originais.

-   Há uma função de cifragem em todas as classes de entidades, envolvendo pelo menos duas operações diferentes e usando uma chave criptográfica? Sim
-    Uma das operações de cifragem é baseada na substituição e a outra na transposição? Sim
-   O trabalho está funcionando corretamente? Sim
-   O trabalho está completo? Sim
-   O trabalho é original e não a cópia de um trabalho de um colega? Original
