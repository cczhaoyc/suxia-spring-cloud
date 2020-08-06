# 用户表
CREATE TABLE `suxia_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户Id',
  `file_id` bigint(20) DEFAULT 0 COMMENT '文件Id(图片)',
  `username` varchar(64) NOT NULL COMMENT '用户账号',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `sex_code` varchar(24) NOT NULL COMMENT '用户性别代码',
  `id_type_code` varchar(24) NOT NULL COMMENT '证件类型代码',
  `id_number` varchar(32) NOT NULL COMMENT '证件号码',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `telephone` varchar(24) NOT NULL COMMENT '联系电话',
  `wubi` varchar(20) NOT NULL COMMENT '五笔',
  `pinyin` varchar(20) NOT NULL COMMENT '拼音',
  `is_stopped` tinyint(1) DEFAULT 0 NOT NULL COMMENT '停用标志（0:在用 1:停用）',
  `remark` varchar(1024) DEFAULT '' COMMENT '说明',
  `is_deleted` tinyint(1) DEFAULT 0 NOT NULL NULL COMMENT '是否删除(0:否 1:是)',
  `created_user_id` bigint(20) NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '最后更新人',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

# 库存表
CREATE TABLE `suxia_storage` (
`storage_id` int(11) NOT NULL COMMENT '库存Id',
`commodity_code` varchar(255) NOT NULL COMMENT '商品编码',
`count` int(11) DEFAULT 0 COMMENT '数量',
`remark` varchar(1024) DEFAULT '' COMMENT '说明',
`is_deleted` tinyint(1) DEFAULT 0 NOT NULL NULL COMMENT '是否删除(0:否 1:是)',
`created_user_id` bigint(20) NOT NULL COMMENT '创建人',
`created_time` datetime NOT NULL COMMENT '创建时间',
`update_user_id` bigint(20) NOT NULL COMMENT '最后更新人',
`update_time` datetime NOT NULL  COMMENT '最后更新时间',
PRIMARY KEY (`storage_id`),
UNIQUE KEY (`commodity_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='库存表';

# 订单表
CREATE TABLE `suxia_order` (
`order_id` int(11) NOT NULL COMMENT '订单Id',
`user_id` varchar(255) NOT NULL COMMENT '用户Id',
`commodity_code` varchar(255) NOT NULL COMMENT '商品编码',
`count` int(11) DEFAULT 0 COMMENT '数量',
`money` decimal(12,2) DEFAULT 0.00 COMMENT '金额',
`remark` varchar(1024) DEFAULT '' COMMENT '说明',
`is_deleted` tinyint(1) DEFAULT 0 NOT NULL NULL COMMENT '是否删除(0:否 1:是)',
`created_user_id` bigint(20) NOT NULL COMMENT '创建人',
`created_time` datetime NOT NULL COMMENT '创建时间',
`update_user_id` bigint(20) NOT NULL COMMENT '最后更新人',
`update_time` datetime NOT NULL  COMMENT '最后更新时间',
PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';

# 账户表
CREATE TABLE `suxia_account` (
`account_id` bigint(20) NOT NULL COMMENT '账户Id',
`user_id` varchar(255) NOT NULL COMMENT '用户Id',
`money` decimal(12,2) DEFAULT 0.00 COMMENT '金额',
`remark` varchar(1024) DEFAULT '' COMMENT '说明',
`is_deleted` tinyint(1) DEFAULT 0 NOT NULL NULL COMMENT '是否删除(0:否 1:是)',
`created_user_id` bigint(20) NOT NULL COMMENT '创建人',
`created_time` datetime NOT NULL COMMENT '创建时间',
`update_user_id` bigint(20) NOT NULL COMMENT '最后更新人',
`update_time` datetime NOT NULL COMMENT '最后更新时间',
PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='账户表';