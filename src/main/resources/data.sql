INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD, NICK_NAME,EMAIL)  VALUES ('admin', '$2a$10$c2VT5PblS4HYEdeeLIc5t.y17pTePRHorrWPt2YeGTYB81J2.kPLu', 'adminNickName', 'admin@admin.com');
INSERT INTO tb_member (LOGIN_ID, LOGIN_PWD, NICK_NAME,EMAIL)  VALUES ('user', '$2a$10$0ajkgQCOdO5gIheng00pc.0sX84W8qFW.8hDEdsRsh32B/3pOHPly', 'userNickName', 'user@user.com');
--
INSERT INTO tb_authority (AUTHORITY_NAME) values ('ROLE_USER');
INSERT INTO tb_authority (AUTHORITY_NAME) values ('ROLE_ADMIN');
--
INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('admin', 'ROLE_ADMIN');
INSERT INTO tb_member_authority (LOGIN_ID, AUTHORITY_NAME) values ('user', 'ROLE_USER');