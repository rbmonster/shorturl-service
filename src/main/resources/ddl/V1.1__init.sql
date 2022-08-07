SET MODE MYSQL;

DROP TABLE IF EXISTS `t_short_url_mapping`;
CREATE TABLE `t_short_url_mapping` (
   `id` bigint(20) NOT NULL COMMENT 'ID',
   `user_id` bigint(20) NOT NULL COMMENT '用户ID',
   `activity_type` varchar(32) DEFAULT NULL COMMENT '活动类型',
   `reference_id` bigint(20) DEFAULT NULL COMMENT '活动ID',
   `short_url_code` varchar(11) NOT NULL COMMENT '短码',
   `short_url` varchar(128) NOT NULL COMMENT '短链地址',
   `origin_url` varchar(512) NOT NULL COMMENT '原始长链接',
   `origin_url_hash` varchar(32) NOT NULL COMMENT '原始长链接hash',
   `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
   `version` int(11) NOT NULL DEFAULT '0',
   PRIMARY KEY (`id`),
   key `idx_user_id_origin_url_hash`(`user_id`,`origin_url_hash`),
   UNIQUE KEY `uniq_short_url_code` (`short_url_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

