INSERT INTO tb_user (email, password) VALUES ('arthur@gmail.com', '123456');
INSERT INTO tb_user (email, password) VALUES ('bob@gmail.com', '123456');
INSERT INTO tb_user (email, password) VALUES ('Jao@gmail.com', '123456');
INSERT INTO tb_user (email, password) VALUES ('Cleb@gmail.com', '123456');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADM');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);

INSERT INTO tb_category (name) VALUES ('Hardware');
INSERT INTO tb_category (name) VALUES ('Notebook');
INSERT INTO tb_category (name) VALUES ('TV');
INSERT INTO tb_category (name) VALUES ('Periférico');
INSERT INTO tb_category (name) VALUES ('Smartphone');


INSERT INTO tb_product (name, description, price, img_url) VALUES ('Placa de video RTX 2060', ' A nova e poderosa GeForce RTX 2060 aproveita a avançada arquitetura NVIDIA Turing para mergulhar você em incrível realismo e desempenho nos jogos mais recentes', '3599.00', 'https://static.meupc.net/produto/placa-video-gigabyte-geforce-rtx-2060-geforcertx20606gb-tc48yn-S.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Notebook Lenovo Ideapad 3i Intel Core i5-10210U', 'Design ultrafino com performance O IdeaPad 3i possui processador Intel Core de 10ª geração. Conta com opções de armazenamento hibrido, ou seja, você pode escolher um produto com HDD, SSD ou com as duas opções combinadas.', '3100.00', 'https://images.samsung.com/is/image/samsung/br-notebook-style-s51-np730xbe-kp1br-np730xbe-kp1br-fronttitanumsilver-185313138?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Smart TV 50" LG 4K NanoCell', 'Com a TV NanoCell LG as cores são mais vivas e puras, numa distinção imediata dos seus televisores LCDs convencionais. Isso porque suas cores, quando combinadas com a incrível exibição da resolução 4K real', '2800.00', 'https://images.samsung.com/is/image/samsung/p6pim/africa_pt/ua70au7000uxly/gallery/africa-pt-uhd-au7000-ua70au7000uxly-444488064?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Mouse Gamer Redragon Cobra', 'O Mouse Gamer Redragon Cobra possui um desing Impressionante RGB Trazendo a já amada iluminação Redragon Chroma Mark II o mouse Gamer Profissional Cobra impressiona com tanta beleza, conforto e precisão. Vá além e customize do seu jeito a iluminação RGB Chroma do seu mouse com o software Redragon. ', '89.90', 'https://images.kabum.com.br/produtos/fotos/94555/94555_1516707116_index_g.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Placa de video Rx 1080', 'GeForce Rx 1080 Perfeita para os combates em seus games.', '1800.00', 'https://static.meupc.net/produto/placa-video-gigabyte-geforce-rtx-2060-geforcertx20606gb-tc48yn-S.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Placa de video RTX 2090', 'RTX 2090 para jogar seus jogos favoritos!!!!', '2900.00', 'https://static.meupc.net/produto/placa-video-gigabyte-geforce-rtx-2060-geforcertx20606gb-tc48yn-S.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Mouse Microsoft', 'O Mouse perfeito para as tarefas do dia a dia. Trabalho ou estudos, sem problemas, o novo mouse da Microsoft tira de letra. ', '58.57', 'https://images.kabum.com.br/produtos/fotos/94555/94555_1516707116_index_g.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Smart TV 89" Sony 4K', 'Nova TV da Samsung com 89", INCRÍVEL para seus jogos e filmes, aproveite!!', '18000.00', 'https://images.samsung.com/is/image/samsung/p6pim/africa_pt/ua70au7000uxly/gallery/africa-pt-uhd-au7000-ua70au7000uxly-444488064?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Smart TV 39" LG', 'TV Comum para assistir novelas e filmes', '899.00', 'https://images.samsung.com/is/image/samsung/p6pim/africa_pt/ua70au7000uxly/gallery/africa-pt-uhd-au7000-ua70au7000uxly-444488064?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Notebook ASUS 14" i5-8400', 'Com design e muita bateria o notebook da asus te entrega tudo isso e mais, aproveite nossa promoção', '3900.00', 'https://images.samsung.com/is/image/samsung/br-notebook-style-s51-np730xbe-kp1br-np730xbe-kp1br-fronttitanumsilver-185313138?$720_576_PNG$');


INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 2);


INSERT INTO tb_review (text, product_id, user_id) VALUES ('Comprei e chegou certinho aqui em casa, produto perfeito', 1, 1);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Produto Perfeito, gostei bastante', 2, 2);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Minha filha adorou!!', 3, 3);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Mouse perfeito para games, ótimo para jogar fps', 4, 4);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Games rodando a muitos FPS!!!!', 5, 1);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Chegou com defeito, uma pena', 6, 2);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Tudo normal, conforme o previsto', 7, 3);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Estamos nos divertindo bastante com essa novidade', 8, 4);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Perfeito para colocar em espaços pequenos', 9, 1);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Agora sim, tudo que eu precisava, atendeu as minhas espectativas', 10, 2);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Gostei, até que roda alguns joguinhos', 2, 3);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Qualidade impecável!!', 3, 4);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Pronto, ja posso minerar bitcoin', 5, 1);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Ok, tudo certo', 6, 2);
INSERT INTO tb_review (text, product_id, user_id) VALUES ('Sempre compro desse mouse, muito bom mesmo.', 7, 3);



