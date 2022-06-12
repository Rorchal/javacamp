CREATE TABLE `commodity` (
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


CREATE TABLE `order` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `commodity_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `commodity_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;



CREATE TABLE `user` (
  `name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `id` bigint(20) NOT NULL,
  `sex` varchar(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;