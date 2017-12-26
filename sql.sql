SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `simple_cart`
-- ----------------------------
DROP TABLE IF EXISTS `simple_cart`;
CREATE TABLE `simple_cart` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT,
  `user_id`     INT(11) NOT NULL,
  `product_id`  INT(11)          DEFAULT NULL
  COMMENT '商品id',
  `quantity`    INT(11)          DEFAULT NULL
  COMMENT '数量',
  `checked`     INT(11)          DEFAULT NULL
  COMMENT '是否选择,1=已勾选,0=未勾选',
  `create_time` DATETIME         DEFAULT NULL
  COMMENT '创建时间',
  `update_time` DATETIME         DEFAULT NULL
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id_index` (`user_id`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_cart`
-- ----------------------------
BEGIN;
INSERT INTO `simple_cart` VALUES ('126', '21', '26', '1', '1', '2017-04-13 21:27:06', '2017-04-13 21:27:06');
COMMIT;

-- ----------------------------
--  Table structure for `simple_category`
-- ----------------------------
DROP TABLE IF EXISTS `simple_category`;
CREATE TABLE `simple_category` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '类别Id',
  `parent_id`   INT(11)          DEFAULT NULL
  COMMENT '父类别id当id=0时说明是根节点,一级类别',
  `name`        VARCHAR(50)      DEFAULT NULL
  COMMENT '类别名称',
  `status`      TINYINT(1)       DEFAULT '1'
  COMMENT '类别状态1-正常,2-已废弃',
  `sort_order`  INT(4)           DEFAULT NULL
  COMMENT '排序编号,同类展示顺序,数值相等则自然排序',
  `create_time` DATETIME         DEFAULT NULL
  COMMENT '创建时间',
  `update_time` DATETIME         DEFAULT NULL
  COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 100000
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_category`
-- ----------------------------
BEGIN;
INSERT INTO `simple_category` VALUES ('100001', '0', '手机', '1', NULL, '2017-12-26 16:56:45', '2017-12-26 16:56:45');
COMMIT;

-- ----------------------------
--  Table structure for `simple_order`
-- ----------------------------
DROP TABLE IF EXISTS `simple_order`;
CREATE TABLE `simple_order` (
  `id`           INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '订单id',
  `order_no`     BIGINT(20)       DEFAULT NULL
  COMMENT '订单号',
  `user_id`      INT(11)          DEFAULT NULL
  COMMENT '用户id',
  `shipping_id`  INT(11)          DEFAULT NULL,
  `payment`      DECIMAL(20, 2)   DEFAULT NULL
  COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` INT(4)           DEFAULT NULL
  COMMENT '支付类型,1-在线支付',
  `postage`      INT(10)          DEFAULT NULL
  COMMENT '运费,单位是元',
  `status`       INT(10)          DEFAULT NULL
  COMMENT '订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭',
  `payment_time` DATETIME         DEFAULT NULL
  COMMENT '支付时间',
  `send_time`    DATETIME         DEFAULT NULL
  COMMENT '发货时间',
  `end_time`     DATETIME         DEFAULT NULL
  COMMENT '交易完成时间',
  `close_time`   DATETIME         DEFAULT NULL
  COMMENT '交易关闭时间',
  `create_time`  DATETIME         DEFAULT NULL
  COMMENT '创建时间',
  `update_time`  DATETIME         DEFAULT NULL
  COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_order`
-- ----------------------------
BEGIN;
INSERT INTO `simple_order` VALUES
  ('103', '1491753014256', '1', '25', '13998.00', '1', '0', '10', NULL, NULL, NULL, NULL, '2017-12-26 16:56:45',
   '2017-12-26 16:56:45');
COMMIT;

-- ----------------------------
--  Table structure for `simple_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `simple_order_item`;
CREATE TABLE `simple_order_item` (
  `id`                 INT(11) NOT NULL AUTO_INCREMENT
  COMMENT '订单子表id',
  `user_id`            INT(11)          DEFAULT NULL,
  `order_no`           BIGINT(20)       DEFAULT NULL,
  `product_id`         INT(11)          DEFAULT NULL
  COMMENT '商品id',
  `product_name`       VARCHAR(100)     DEFAULT NULL
  COMMENT '商品名称',
  `product_image`      VARCHAR(500)     DEFAULT NULL
  COMMENT '商品图片地址',
  `current_unit_price` DECIMAL(20, 2)   DEFAULT NULL
  COMMENT '生成订单时的商品单价，单位是元,保留两位小数',
  `quantity`           INT(10)          DEFAULT NULL
  COMMENT '商品数量',
  `total_price`        DECIMAL(20, 2)   DEFAULT NULL
  COMMENT '商品总价,单位是元,保留两位小数',
  `create_time`        DATETIME         DEFAULT NULL,
  `update_time`        DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`, `order_no`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 135
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `simple_order_item` VALUES
  ('113', '1', '1491753014256', '26', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机',
          '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg', '6999.00', '2', '13998.00', '2017-12-26 16:56:45',
          '2017-12-26 16:56:45');
COMMIT;

-- ----------------------------
--  Table structure for `simple_pay_info`
-- ----------------------------
DROP TABLE IF EXISTS `simple_pay_info`;
CREATE TABLE `simple_pay_info` (
  `id`              INT(11) NOT NULL AUTO_INCREMENT,
  `user_id`         INT(11)          DEFAULT NULL
  COMMENT '用户id',
  `order_no`        BIGINT(20)       DEFAULT NULL
  COMMENT '订单号',
  `pay_platform`    INT(10)          DEFAULT NULL
  COMMENT '支付平台:1-支付宝,2-微信',
  `platform_number` VARCHAR(200)     DEFAULT NULL
  COMMENT '支付宝支付流水号',
  `platform_status` VARCHAR(20)      DEFAULT NULL
  COMMENT '支付宝支付状态',
  `create_time`     DATETIME         DEFAULT NULL
  COMMENT '创建时间',
  `update_time`     DATETIME         DEFAULT NULL
  COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_pay_info`
-- ----------------------------
BEGIN;
INSERT INTO `simple_pay_info` VALUES
  ('53', '1', '1492090946105', '1', '2017041321001004300200116250', 'WAIT_BUYER_PAY', '2017-12-26 16:56:45',
   '2017-12-26 16:56:45');
COMMIT;

-- ----------------------------
--  Table structure for `simple_product`
-- ----------------------------
DROP TABLE IF EXISTS `simple_product`;
CREATE TABLE `simple_product` (
  `id`          INT(11)        NOT NULL AUTO_INCREMENT
  COMMENT '商品id',
  `category_id` INT(11)        NOT NULL
  COMMENT '分类id,对应simple_category表的主键',
  `name`        VARCHAR(100)   NOT NULL
  COMMENT '商品名称',
  `subtitle`    VARCHAR(200)            DEFAULT NULL
  COMMENT '商品副标题',
  `main_image`  VARCHAR(500)            DEFAULT NULL
  COMMENT '产品主图,url相对地址',
  `sub_images`  TEXT COMMENT '图片地址,json格式,扩展用',
  `detail`      TEXT COMMENT '商品详情',
  `price`       DECIMAL(20, 2) NOT NULL
  COMMENT '价格,单位-元保留两位小数',
  `stock`       INT(11)        NOT NULL
  COMMENT '库存数量',
  `status`      INT(6)                  DEFAULT '1'
  COMMENT '商品状态.1-在售 2-下架 3-删除',
  `create_time` DATETIME                DEFAULT NULL
  COMMENT '创建时间',
  `update_time` DATETIME                DEFAULT NULL
  COMMENT '更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_product`
-- ----------------------------
BEGIN;
INSERT INTO `simple_product` VALUES
  ('26', '100002', 'Apple iPhone 7 Plus (A1661) 128G 玫瑰金色 移动联通电信4G手机', 'iPhone 7，现更以红色呈现。',
         '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg',
         '241997c4-9e62-4824-b7f0-7425c3c28917.jpeg,b6c56eb0-1748-49a9-98dc-bcc4b9788a54.jpeg,92f17532-1527-4563-aa1d-ed01baa0f7b2.jpeg,3adbe4f7-e374-4533-aa79-cc4a98c529bf.jpeg',
         '<p><img alt=\"10000.jpg\" src=\"http://img.happysimple.com/00bce8d4-e9af-4c8d-b205-e6c75c7e252b.jpg\" width=\"790\" height=\"553\"><br></p><p><img alt=\"20000.jpg\" src=\"http://img.happysimple.com/4a70b4b4-01ee-46af-9468-31e67d0995b8.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"30000.jpg\" src=\"http://img.happysimple.com/0570e033-12d7-49b2-88f3-7a5d84157223.jpg\" width=\"790\" height=\"365\"><br></p><p><img alt=\"40000.jpg\" src=\"http://img.happysimple.com/50515c02-3255-44b9-a829-9e141a28c08a.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"50000.jpg\" src=\"http://img.happysimple.com/c138fc56-5843-4287-a029-91cf3732d034.jpg\" width=\"790\" height=\"525\"><br></p><p><img alt=\"60000.jpg\" src=\"http://img.happysimple.com/c92d1f8a-9827-453f-9d37-b10a3287e894.jpg\" width=\"790\" height=\"525\"><br></p><p><br></p><p><img alt=\"TB24p51hgFkpuFjSspnXXb4qFXa-1776456424.jpg\" src=\"http://img.happysimple.com/bb1511fc-3483-471f-80e5-c7c81fa5e1dd.jpg\" width=\"790\" height=\"375\"><br></p><p><br></p><p><img alt=\"shouhou.jpg\" src=\"http://img.happysimple.com/698e6fbe-97ea-478b-8170-008ad24030f7.jpg\" width=\"750\" height=\"150\"><br></p><p><img alt=\"999.jpg\" src=\"http://img.happysimple.com/ee276fe6-5d79-45aa-8393-ba1d210f9c89.jpg\" width=\"790\" height=\"351\"><br></p>',
         '6999.00', '9991', '1', NULL, '2017-04-13 21:45:41'),
  ('27', '100006', 'Midea/美的 BCD-535WKZM(E)冰箱双开门对开门风冷无霜智能电家用', '送品牌烤箱，五一大促',
         'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg',
         'ac3e571d-13ce-4fad-89e8-c92c2eccf536.jpeg,4bb02f1c-62d5-48cc-b358-97b05af5740d.jpeg,36bdb49c-72ae-4185-9297-78829b54b566.jpeg',
         '<p><img alt=\"miaoshu.jpg\" src=\"http://img.happysimple.com/9c5c74e6-6615-4aa0-b1fc-c17a1eff6027.jpg\" width=\"790\" height=\"444\"><br></p><p><img alt=\"miaoshu2.jpg\" src=\"http://img.happysimple.com/31dc1a94-f354-48b8-a170-1a1a6de8751b.jpg\" width=\"790\" height=\"1441\"><img alt=\"miaoshu3.jpg\" src=\"http://img.happysimple.com/7862594b-3063-4b52-b7d4-cea980c604e0.jpg\" width=\"790\" height=\"1442\"><img alt=\"miaoshu4.jpg\" src=\"http://img.happysimple.com/9a650563-dc85-44d6-b174-d6960cfb1d6a.jpg\" width=\"790\" height=\"1441\"><br></p>',
         '3299.00', '8876', '1', '2017-04-13 18:51:54', '2017-04-13 21:45:41'),
  ('28', '100012', '4+64G送手环/Huawei/华为 nova 手机P9/P10plus青春', 'NOVA青春版1999元',
         '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg',
         '0093f5d3-bdb4-4fb0-bec5-5465dfd26363.jpeg,13da2172-4445-4eb5-a13f-c5d4ede8458c.jpeg,58d5d4b7-58d4-4948-81b6-2bae4f79bf02.jpeg',
         '<p><img alt=\"11TB2fKK3cl0kpuFjSsziXXa.oVXa_!!1777180618.jpg\" src=\"http://img.happysimple.com/5c2d1c6d-9e09-48ce-bbdb-e833b42ff664.jpg\" width=\"790\" height=\"966\"><img alt=\"22TB2YP3AkEhnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.happysimple.com/9a10b877-818f-4a27-b6f7-62887f3fb39d.jpg\" width=\"790\" height=\"1344\"><img alt=\"33TB2Yyshk.hnpuFjSZFpXXcpuXXa_!!1777180618.jpg\" src=\"http://img.happysimple.com/7d7fbd69-a3cb-4efe-8765-423bf8276e3e.jpg\" width=\"790\" height=\"700\"><img alt=\"TB2diyziB8kpuFjSspeXXc7IpXa_!!1777180618.jpg\" src=\"http://img.happysimple.com/1d7160d2-9dba-422f-b2a0-e92847ba6ce9.jpg\" width=\"790\" height=\"393\"><br></p>',
         '1999.00', '9994', '1', '2017-04-13 18:57:18', '2017-04-13 21:45:41'),
  ('29', '100008', 'Haier/海尔HJ100-1HU1 10公斤滚筒洗衣机全自动带烘干家用大容量 洗烘一体', '门店机型 德邦送货',
         '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg',
         '173335a4-5dce-4afd-9f18-a10623724c4e.jpeg,42b1b8bc-27c7-4ee1-80ab-753d216a1d49.jpeg,2f1b3de1-1eb1-4c18-8ca2-518934931bec.jpeg',
         '<p><img alt=\"1TB2WLZrcIaK.eBjSspjXXXL.XXa_!!2114960396.jpg\" src=\"http://img.happysimple.com/ffcce953-81bd-463c-acd1-d690b263d6df.jpg\" width=\"790\" height=\"920\"><img alt=\"2TB2zhOFbZCO.eBjSZFzXXaRiVXa_!!2114960396.jpg\" src=\"http://img.happysimple.com/58a7bd25-c3e7-4248-9dba-158ef2a90e70.jpg\" width=\"790\" height=\"1052\"><img alt=\"3TB27mCtb7WM.eBjSZFhXXbdWpXa_!!2114960396.jpg\" src=\"http://img.happysimple.com/2edbe9b3-28be-4a8b-a9c3-82e40703f22f.jpg\" width=\"790\" height=\"820\"><br></p>',
         '4299.00', '9993', '1', '2017-04-13 19:07:47', '2017-04-13 21:45:41');
COMMIT;

-- ----------------------------
--  Table structure for `simple_shipping`
-- ----------------------------
DROP TABLE IF EXISTS `simple_shipping`;
CREATE TABLE `simple_shipping` (
  `id`                INT(11) NOT NULL AUTO_INCREMENT,
  `user_id`           INT(11)          DEFAULT NULL
  COMMENT '用户id',
  `receiver_name`     VARCHAR(20)      DEFAULT NULL
  COMMENT '收货姓名',
  `receiver_phone`    VARCHAR(20)      DEFAULT NULL
  COMMENT '收货固定电话',
  `receiver_mobile`   VARCHAR(20)      DEFAULT NULL
  COMMENT '收货移动电话',
  `receiver_province` VARCHAR(20)      DEFAULT NULL
  COMMENT '省份',
  `receiver_city`     VARCHAR(20)      DEFAULT NULL
  COMMENT '城市',
  `receiver_district` VARCHAR(20)      DEFAULT NULL
  COMMENT '区/县',
  `receiver_address`  VARCHAR(200)     DEFAULT NULL
  COMMENT '详细地址',
  `receiver_zip`      VARCHAR(6)       DEFAULT NULL
  COMMENT '邮编',
  `create_time`       DATETIME         DEFAULT NULL,
  `update_time`       DATETIME         DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_shipping`
-- ----------------------------
BEGIN;
INSERT INTO `simple_shipping` VALUES
  ('4', '13', 'geely', '010', '18688888888', '北京', '北京市', '海淀区', '中关村', '100000', '2017-01-22 14:26:25',
   '2017-01-22 14:26:25'),
  ('7', '17', 'Rosen', '13800138000', '13800138000', '北京', '北京', NULL, '中关村', '100000', '2017-03-29 12:11:01',
   '2017-03-29 12:11:01'),
  ('29', '1', '吉利', '13800138000', '13800138000', '北京', '北京', '海淀区', '海淀区中关村', '100000', '2017-04-09 18:33:32',
   '2017-04-09 18:33:32');
COMMIT;

-- ----------------------------
--  Table structure for `simple_user`
-- ----------------------------
DROP TABLE IF EXISTS `simple_user`;
CREATE TABLE `simple_user` (
  `id`          INT(11)     NOT NULL AUTO_INCREMENT
  COMMENT '用户表id',
  `username`    VARCHAR(50) NOT NULL
  COMMENT '用户名',
  `password`    VARCHAR(50) NOT NULL
  COMMENT '用户密码，MD5加密',
  `email`       VARCHAR(50)          DEFAULT NULL,
  `phone`       VARCHAR(20)          DEFAULT NULL,
  `question`    VARCHAR(100)         DEFAULT NULL
  COMMENT '找回密码问题',
  `answer`      VARCHAR(100)         DEFAULT NULL
  COMMENT '找回密码答案',
  `role`        INT(4)      NOT NULL
  COMMENT '角色0-管理员,1-普通用户',
  `create_time` DATETIME    NOT NULL
  COMMENT '创建时间',
  `update_time` DATETIME    NOT NULL
  COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `simple_user`
-- ----------------------------
BEGIN;
INSERT INTO `simple_user` VALUES
  ('1', 'simple', '123123123', 'crescentcxm@gmail.com', '18578230461', '问题', '答案', '没有bug',
   '2017-12-26 16:56:45', '2017-12-26 16:56:45');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
