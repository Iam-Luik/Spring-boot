-- esse FILE_READ só funciona no H2
insert into fruta (nome, unidade, preco_unitario, quantidade_estoque, foto) values
('uva', 'quilo', 12.5, 10, FILE_READ('classpath:/uva.jpg')),
('banana', 'dúzia', 7, 55, FILE_READ('classpath:/banana.jpg')),
('abacaxi', 'unidade', 9.35, 100, FILE_READ('classpath:/abacaxi.png'));