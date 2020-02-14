SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zhoukao0214_department
-- ----------------------------
DROP TABLE IF EXISTS `zhoukao0214_department`;
CREATE TABLE `zhoukao0214_department`
(
    `department_id` int NOT NULL auto_increment,
    `name`          varchar(20) not null ,
    `parent_id`     int not null ,
    `sort_order`    int,
    PRIMARY KEY (`department_id`),
    index `idx_name` (`name`),
    index `idx_parent_id` (`parent_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 auto_increment = 1;
