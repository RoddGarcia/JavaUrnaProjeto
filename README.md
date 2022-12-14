# JavaUrnaProjeto
Projeto desenvolvido para a máteria Programação de Sistemas I, junto com minha dupla Matheus Barbosa.


Decisões relativas à implementação
O projeto presente tem como seu objetivo principal simular uma urna eletrônica através de Java. É feito um sistema de votação simplificado, em que o usuário tem a possibilidade de cadastrar três candidatos para cada cargo contendo para cada, o nome, o número do seu partido político e número de candidato. Ainda, há a possibilidade de cadastrar cinco eleitores que poderão constar seu voto no processo eleitoral. Dessa forma, o eleitor deve registrar seu nome e CPF. Por fim, o usuário poderá receber os resultados apurados e também ter em mãos o relatório e as estatísticas das eleições lá efetuadas.

De início, o projeto foi desenvolvido com o intuito de alocar os dados criados pelo usuário dentro de matrizes, cujas quais funcionam à medida em que cada linha representa um eleitor ou qualquer cargo de candidato. Por outro lado, as colunas apresentam os dados de cada indivíduo em formato de String.

A princípio, o projeto iria conter seis classes no total: Main, Eleitor, Presidente, Governador, Prefeito e Voto. Porém, devido a problemas envolvendo a importação de dados advindos da matriz, a dupla optou por reduzir as classes para Main, Candidato, Eleitor e Voto, usando como parâmetro as listas que cada método requer.

O menu foi desenvolvido para ser guiado através de um switch, o qual teria como parâmetro o input do usuário. A partir deste, o mesmo seria levado para adicionar um candidato, adicionar um eleitor, votar, apurar resultados ou consultar o relatório e estatísticas, caso a escolha do indivíduo seja maior que 6, o programa se encerra.

Nas opções 1 e 2 do menu, o usuário consegue cadastrar candidatos e eleitores respectivamente. Na opção 3, ele finalmente consegue votar. Para isso, o sistema seleciona o primeiro eleitor cadastrado e induz o usuário a escolher o número de candidato. Se o mesmo digitar o valor “-1”, seu voto será computado como branco; se for “-2”, será nulo. 

Na opção 4, o usuário tem acesso ao número de votos de cada candidato juntamente do total de votos, total de votos válidos, total de votos brancos e total de votos nulos, cada um seguido pelo seu valor em porcentagem.

Por fim, na opção 5, um relatório é exibido, exibindo os eleitores que votaram e apresenta qual partido elegeu mais políticos e qual elegeu menos políticos.


Diagrama de Classes
![Classe UML(4)](https://user-images.githubusercontent.com/85592905/207738854-b49f70fc-eb72-40f5-9b78-1bb1362a9b05.png)
