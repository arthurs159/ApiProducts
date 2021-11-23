INSERT INTO tb_user (email, password) VALUES ('arthur@gmail.com', '123456');
INSERT INTO tb_user (email, password) VALUES ('bob@gmail.com', '123456');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADM');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_category (name) VALUES ('Hardware');
INSERT INTO tb_category (name) VALUES ('Notebook');
INSERT INTO tb_category (name) VALUES ('TV');
INSERT INTO tb_category (name) VALUES ('Periférico');

INSERT INTO tb_product (name, description, price, img_url) VALUES ('Placa de video RTX 2060', ' A nova e poderosa GeForce RTX 2060 aproveita a avançada arquitetura NVIDIA Turing para mergulhar você em incrível realismo e desempenho nos jogos mais recentes', '3599.00', 'https://static.meupc.net/produto/placa-video-gigabyte-geforce-rtx-2060-geforcertx20606gb-tc48yn-S.jpg');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Notebook Lenovo Ideapad 3i Intel Core i5-10210U', 'Design ultrafino com performance O IdeaPad 3i possui processador Intel Core de 10ª geração. Conta com opções de armazenamento hibrido, ou seja, você pode escolher um produto com HDD, SSD ou com as duas opções combinadas.', '3100.00', 'https://images.samsung.com/is/image/samsung/br-notebook-style-s51-np730xbe-kp1br-np730xbe-kp1br-fronttitanumsilver-185313138?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Smart TV 50" LG 4K NanoCell', 'Com a TV NanoCell LG as cores são mais vivas e puras, numa distinção imediata dos seus televisores LCDs convencionais. Isso porque suas cores, quando combinadas com a incrível exibição da resolução 4K real', '2800.00', 'https://images.samsung.com/is/image/samsung/p6pim/africa_pt/ua70au7000uxly/gallery/africa-pt-uhd-au7000-ua70au7000uxly-444488064?$720_576_PNG$');
INSERT INTO tb_product (name, description, price, img_url) VALUES ('Mouse Gamer Redragon Cobra', 'O Mouse Gamer Redragon Cobra possui um desing Impressionante RGB Trazendo a já amada iluminação Redragon Chroma Mark II o mouse Gamer Profissional Cobra impressiona com tanta beleza, conforto e precisão. Vá além e customize do seu jeito a iluminação RGB Chroma do seu mouse com o software Redragon. ', '89.90', 'https://images.kabum.com.br/produtos/fotos/94555/94555_1516707116_index_g.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 4);