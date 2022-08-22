set names utf8;

CREATE TABLE `tb_article` (
                              `id` bigint(20) NOT NULL,
                              `context` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                              `author` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              KEY `FKr96xhu8ni8hs723o3ny5ykjjk` (`author`),
                              CONSTRAINT `FKr96xhu8ni8hs723o3ny5ykjjk` FOREIGN KEY (`author`) REFERENCES `tb_member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- simple_article_db.tb_member definition

CREATE TABLE `tb_member` (
                             `id` bigint(20) NOT NULL,
                             `create_date` datetime(6) DEFAULT NULL,
                             `update_date` datetime(6) DEFAULT NULL,
                             `state` int(11) NOT NULL,
                             `login_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `login_pwd` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             `nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- INSERT INTO MEMBER (LOGIN_ID, LOGIN_PWD, NICK_NAME)  VALUES ('admin1', '$2a$10$1PdZ.5oP5vj2oSJNaBWlGO3XAo38.sXfgup/LVpasxzzNmBrd8dly', 'admin1NickName');
-- INSERT INTO MEMBER (LOGIN_ID, LOGIN_PWD, NICK_NAME)  VALUES ('user1', '$2a$10$x5ItQ0I/FMmWxBE5tLDh3ex.0w.O.YjfDvMS/T349nl.Hqhy84gL', 'user1NickName');
-- --
-- INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_USER');
-- INSERT INTO AUTHORITY (AUTHORITY_NAME) values ('ROLE_ADMIN');
-- --
-- INSERT INTO USER_AUTHORITY (LOGIN_ID, AUTHORITY_NAME) values ('admin1', 'ROLE_ADMIN');
-- INSERT INTO USER_AUTHORITY (LOGIN_ID, AUTHORITY_NAME) values ('user1', 'ROLE_USER');