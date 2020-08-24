-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(
    `id`     int(11)      NOT NULL AUTO_INCREMENT,
    `cover`  varchar(255)          DEFAULT '',
    `title`  varchar(255) NOT NULL DEFAULT '',
    `author` varchar(255)          DEFAULT '',
    `date`   varchar(20)           DEFAULT '',
    `press`  varchar(255)          DEFAULT '',
    `abs`    varchar(255)          DEFAULT NULL,
    `cid`    int(11)               DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_book_category_on_cid` (`cid`),
    CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 109
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`   int(11)      NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)                                              NOT NULL AUTO_INCREMENT,
    `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(255)                                            DEFAULT NULL,
    `salt`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 110
  DEFAULT CHARSET = utf8;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `path`      varchar(64)                                            DEFAULT NULL,
    `name`      varchar(64)                                            DEFAULT NULL,
    `icon_cls`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `component` varchar(64)                                            DEFAULT NULL,
    `parent_id` int(11)                                                DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8
  COLLATE = utf8_general_ci;
