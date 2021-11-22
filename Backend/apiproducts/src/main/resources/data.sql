INSERT INTO tb_user (email, password) VALUES ('arthur@gmail.com', '123456');
INSERT INTO tb_user (email, password) VALUES ('bob@gmail.com', '123456');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADM');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);