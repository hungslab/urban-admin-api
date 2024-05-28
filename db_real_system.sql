/*
 Navicat Premium Data Transfer

 Source Server         : hm
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : db_real_system

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 08/05/2024 00:48:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
                             `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
                             `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
                             `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
                             `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
                             `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                             `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '部门状态（1正常 0停用）',
                             `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
                             `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, '销售部', 'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-05-07 18:44:46', '', NULL);
INSERT INTO `sys_dept` VALUES (101, '市场部门', 'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-05-07 18:44:46', '', NULL);
INSERT INTO `sys_dept` VALUES (102, '技术部门', 'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-05-07 18:44:46', '', NULL);
INSERT INTO `sys_dept` VALUES (103, '财务部门', 'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-05-07 18:44:46', '', NULL);
INSERT INTO `sys_dept` VALUES (104, '运维部门', 'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2024-05-07 18:44:46', '', NULL);

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
                                 `oper_id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志主键',
                                 `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作内容描述',
                                 `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
                                 `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
                                 `operator_type` int NULL DEFAULT 0 COMMENT '操作类别',
                                 `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
                                 `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
                                 `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
                                 `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
                                 `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                 PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
                              `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
                              `order_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '订单商品名称',
                              `order_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '下单用户',
                              `pay_way` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '支付方式',
                              `order_price` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '订单价格',
                              `order_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '订单状态（1上架 0下架）',
                              `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                              PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, '花花公子春季男士长袖衬衫免烫中青年休闲衬衣潮流男装印花衬衣', '张三', '支付宝', '171.6', '1', '2024-05-07 18:44:47');
INSERT INTO `sys_order` VALUES (2, '人本韩版女式低帮百搭帆布鞋系带浅口学生白色小白鞋文艺清新单鞋', '李四', '支付宝', '156.2', '1', '2024-05-07 18:44:47');
INSERT INTO `sys_order` VALUES (3, '乔琪诺牛仔卫衣女中长款连帽套头中袖韩版宽松2018新款连衣裙夏', '张三', '支付宝', '171.6', '1', '2024-05-07 18:44:47');

-- ----------------------------
-- Table structure for sys_payway
-- ----------------------------
DROP TABLE IF EXISTS `sys_payway`;
CREATE TABLE `sys_payway`  (
                               `payway_id` bigint NOT NULL AUTO_INCREMENT COMMENT '支付方式ID',
                               `payway_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '订单商品名称',
                               `payway_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '订单状态（0启用 1禁止）',
                               `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                               PRIMARY KEY (`payway_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付方式表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_payway
-- ----------------------------
INSERT INTO `sys_payway` VALUES (1, '支付宝', '1', '2024-05-07 18:44:47');
INSERT INTO `sys_payway` VALUES (2, '微信', '1', '2024-05-07 18:44:47');
INSERT INTO `sys_payway` VALUES (3, '银行卡', '1', '2024-05-07 18:44:47');

-- ----------------------------
-- Table structure for sys_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product`  (
                                `product_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
                                `product_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品名称',
                                `product_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品标题',
                                `product_avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '商品图片',
                                `product_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '商品价格',
                                `product_count` int NULL DEFAULT 0 COMMENT '商品数量',
                                `product_sale_count` int NULL DEFAULT 0 COMMENT '商品销量',
                                `product_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '商品状态（1上架 0下架）',
                                `product_create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `product_cb` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品成本',
                                `product_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类',
                                PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO `sys_product` VALUES (1, '2018春装新款韩版潮学生宽松薄款卫衣女长袖ins超火的上衣服外套', '春装新款百搭~~', 'https://gw.alicdn.com/imgextra/i3/2534433306/O1CN01jYHdAb1aICCMvU2Rx_!!2534433306.jpg', 1119.00, 99, 11, '1', '2024-04-07 18:44:47', 19.00, '衣服');
INSERT INTO `sys_product` VALUES (2, '乔琪诺牛仔卫衣女中长款连帽套头中袖韩版宽松2018新款连衣裙夏', '乔琪诺原创设计 送运费险', 'https://gw.alicdn.com/imgextra/i3/3670023043/O1CN01opmt0H1YLjzEA2NYW_!!3670023043.jpg', 119.00, 99, 11, '1', '2024-04-07 18:44:47', 19.00, '衣服');
INSERT INTO `sys_product` VALUES (3, '花花公子春季男士长袖衬衫免烫中青年休闲衬衣潮流男装印花衬衣', '送运费险 放心购物', 'https://gw.alicdn.com/imgextra/i3/2208111378194/O1CN01j5XOR02AOu6hDLZ9h_!!2208111378194.jpg', 119.00, 99, 11, '1', '2024-06-06 18:44:47', 19.00, '衣服');
INSERT INTO `sys_product` VALUES (4, '人本高帮帆布鞋内增高布鞋高邦高腰单鞋牛仔布系带学院风学生款女', '帆布鞋', 'https://gw.alicdn.com/imgextra/i1/1615661421/O1CN01O6QqIi1MMrkxiMY7u_!!1615661421.jpg', 119.00, 99, 11, '1', '2024-05-07 18:44:47', 19.00, '肉');
INSERT INTO `sys_product` VALUES (5, '2018新款ins超火短款连帽卫衣女夏春季bf风薄款帽衫潮学生宽松', '潮流卫衣', 'https://gw.alicdn.com/bao/uploaded/i4/2208161521967/O1CN0106akTj1QOvpy8nlQ0_!!2208161521967.jpg', 119.00, 99, 11, '1', '2024-05-07 18:44:47', 19.00, '肉');
INSERT INTO `sys_product` VALUES (6, '花花公子牛仔裤男修身款 秋冬季直筒商务休闲弹力男士牛仔长裤子', '花花公子正品 默认圆通 送运费险', 'https://gw.alicdn.com/imgextra/i3/684727683/O1CN01nypCNK26crrWLivai_!!684727683.jpg', 119.00, 99, 11, '1', '2024-05-07 18:44:47', 19.00, '肉');
INSERT INTO `sys_product` VALUES (7, '人本韩版女式低帮百搭帆布鞋系带浅口学生白色小白鞋文艺清新单鞋', '低帮帆布鞋', 'https://gw.alicdn.com/imgextra/i4/2115388309/O1CN01TRp5nc2BFZbA6sXfK_!!2115388309-0-lubanu-s.jpg', 119.00, 99, 11, '1', '2025-05-07 18:44:47', 19.00, '蔬菜');
INSERT INTO `sys_product` VALUES (8, '花花公子长袖衬衫男士印花翻领薄款商务休闲衬衣中青年秋款男装潮', '潮男焕新 舒适体验 帅气有型 赠运费险', 'https://gw.alicdn.com/imgextra/i2/2517726762/O1CN01mhXhZD1zp341EnaSb_!!2517726762.jpg', 119.00, 99, 11, '1', '2024-06-07 18:44:47', 19.00, '蔬菜');
INSERT INTO `sys_product` VALUES (9, '早春新款韩版宽松长袖卫衣女连帽2018超火ins上衣学生百搭慵懒风', '早春新款宽松连帽卫衣', 'https://gw.alicdn.com/imgextra/i3/3314876883/O1CN01JQEewK20iSvi1jk8Q_!!3314876883.jpg', 119.00, 99, 11, '1', '2024-06-07 18:44:47', 19.00, '蔬菜');

-- ----------------------------
-- Table structure for sys_review
-- ----------------------------
DROP TABLE IF EXISTS `sys_review`;
CREATE TABLE `sys_review`  (
                               `review_id` bigint NOT NULL AUTO_INCREMENT,
                               `review_content` mediumtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                               `review_create_time` datetime NOT NULL,
                               `review_user_id` bigint NULL DEFAULT 1,
                               `review_product_id` bigint NULL DEFAULT 1,
                               `review_order_id` bigint NULL DEFAULT 1,
                               `review_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '评论状态（0未启用 1启用）',
                               PRIMARY KEY (`review_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_review
-- ----------------------------
INSERT INTO `sys_review` VALUES (1, '测试测试测试测试测试测试', '2024-05-07 18:44:47', 1, 6, 55, '1');
INSERT INTO `sys_review` VALUES (2, '手机很好！！！！！！！！！！拍照很清晰', '2024-05-07 18:44:47', 1, 3, 53, '1');
INSERT INTO `sys_review` VALUES (3, '质量很好', '2024-05-07 18:44:47', 1, 2, 61, '1');
INSERT INTO `sys_review` VALUES (4, 'dda', '2024-05-07 18:44:47', 1, 1, 64, '1');
INSERT INTO `sys_review` VALUES (5, '很好', '2024-05-07 18:44:47', 1, 3, 65, '1');
INSERT INTO `sys_review` VALUES (6, '非常好看！质量也不错！', '2024-05-07 18:44:47', 1, 7, 82, '1');
INSERT INTO `sys_review` VALUES (7, '很早之前就加入购物车了！买回来后果然没失望！质量很好，穿着也很舒服！', '2024-05-07 18:44:47', 1, 5, 83, '1');
INSERT INTO `sys_review` VALUES (8, '衣服很好看，发货很及时！', '2024-05-07 18:44:47', 1, 1, 85, '1');
INSERT INTO `sys_review` VALUES (9, '衣服很好看！模特也是哦(笑', '2024-05-07 18:44:47', 1, 1, 86, '1');
INSERT INTO `sys_review` VALUES (10, '衣服很时尚，质量也挺好', '2024-05-07 18:44:47', 1, 1, 88, '1');
INSERT INTO `sys_review` VALUES (11, '给姐姐买的衣服，姐姐很喜欢！质量很不错', '2024-05-07 18:44:47', 1, 1, 87, '1');
INSERT INTO `sys_review` VALUES (12, '发的衣服有点大了，其他还行，好评给卖家一个鼓励！', '2024-05-07 18:44:47', 1, 1, 90, '1');
INSERT INTO `sys_review` VALUES (13, '发货过程有点慢，衣服还行吧！', '2024-05-07 18:44:47', 1, 1, 89, '1');
INSERT INTO `sys_review` VALUES (14, '衣服特别看好，穿上去特潮，男票超级喜欢\r\n好评！', '2024-05-07 18:44:47', 1, 1, 93, '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                             `dept_id` bigint NULL DEFAULT NULL COMMENT '部门ID',
                             `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
                             `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户昵称',
                             `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
                             `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
                             `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
                             `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
                             `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
                             `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
                             `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '盐加密',
                             `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '帐号状态（1正常 0停用）',
                             `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
                             `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
                             `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
                             `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
                             `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                             `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                             PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', 'admin', '00', 'admin@163.com', '15888888888', '1', 'https://img.zcool.cn/community/01a6095f110b9fa8012066219b67d4.png@1280w_1l_2o_100sh.png', '29c67a30398638269fe600f73a054934', '111111', '1', '0', '127.0.0.1', '2024-05-07 18:44:46', 'admin', '2024-05-07 18:44:46', '', NULL, '管理员');
INSERT INTO `sys_user` VALUES (2, 101, '李超伊', '李超伊', '00', 'cy@qq.com', '15666666666', '1', 'https://img.zcool.cn/community/0143395f110b9fa801215aa060a140.png@1280w_1l_2o_100sh.png', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '1', '127.0.0.1', '2024-05-07 18:44:46', 'admin', '2024-05-07 18:44:46', '', NULL, '测试员');
INSERT INTO `sys_user` VALUES (3, 102, '沙顺珍', '张三', '01', 'zs@163.com', '15444444444', '1', 'https://img.zcool.cn/community/014f685f110b9fa801215aa096689e.png@1280w_1l_2o_100sh.png', '29c67a30398638269fe600f73a054934', '111111', '0', '1', '127.0.0.1', '2024-05-07 18:44:46', 'admin', '2024-05-07 18:44:46', '', NULL, '普通用户');
INSERT INTO `sys_user` VALUES (4, 101, '吴昀霞', '吴昀霞', '01', 'ls@qq.com', '15333333333', '1', 'https://img.zcool.cn/community/016a2e5f110b9fa801215aa097202c.png@1280w_1l_2o_100sh.png', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '1', '127.0.0.1', '2024-05-07 18:44:46', 'admin', '2024-05-07 18:44:46', '', NULL, '普通用户');
INSERT INTO `sys_user` VALUES (5, 101, '顾梦娇', '顾梦娇', '01', 'ls@qq.com', '15333333333', '1', 'https://img.zcool.cn/community/016a2e5f110b9fa801215aa097202c.png@1280w_1l_2o_100sh.png', '8e6d98b90472783cc73c17047ddccf36', '222222', '0', '1', '127.0.0.1', '2024-05-07 18:44:46', 'admin', '2024-05-07 18:44:46', '', NULL, '普通用户');
-- ----------------------------
-- Procedure structure for GenerateOrderData
-- ----------------------------
DROP PROCEDURE IF EXISTS `GenerateOrderData`;
delimiter ;;
CREATE PROCEDURE `GenerateOrderData`()
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE v_order_price DECIMAL(10, 2);
    DECLARE v_create_time DATETIME;

    WHILE i < 5000 DO
            -- 随机生成order_price, 假设价格范围在10到1000之间
            SET v_order_price = ROUND((RAND() * (1000 - 10)) + 10, 2);

            -- 生成随机日期，从2017年1月1日到2024年12月31日
            SET v_create_time = DATE_ADD('2017-01-01', INTERVAL FLOOR(RAND() * (DATEDIFF('2024-12-31', '2017-01-01') + 1)) DAY);

            INSERT INTO `db_real_system`.`sys_order` (
                `order_name`,
                `order_user`,
                `pay_way`,
                `order_price`,
                `order_status`,
                `create_time`
            ) VALUES (
                         '人本韩版女式低帮百搭帆布鞋系带浅口学生白色小白鞋文艺清新单鞋',
                         '李四',
                         '支付宝',
                         v_order_price,
                         '1',
                         v_create_time
                     );

            SET i = i + 1;
        END WHILE;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for GenerateRandomData
-- ----------------------------
DROP PROCEDURE IF EXISTS `GenerateRandomData`;
delimiter ;;
CREATE PROCEDURE `GenerateRandomData`()
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE v_product_count INT;
    DECLARE v_product_sale_count INT;
    DECLARE v_product_status INT;
    DECLARE v_product_cb DECIMAL(10, 2);
    DECLARE v_product_price DECIMAL(10, 2);
    DECLARE v_product_create_time DATE;
    DECLARE v_product_type VARCHAR(50);
    DECLARE product_types VARCHAR(255) DEFAULT '蔬菜,肉类,水果,衣服,鞋子,手机';

    WHILE i < 2000 DO
            -- 随机生成product_count和product_sale_count
            SET v_product_count = FLOOR(RAND() * (100 - 1 + 1)) + 1;
            SET v_product_sale_count = FLOOR(RAND() * (v_product_count - 1 + 1));

            -- 随机生成product_status和product_cb
            SET v_product_status = FLOOR(RAND() * (9 - 1 + 1)) + 1;
            SET v_product_cb = ROUND(RAND() * (v_product_status - 1), 2);

            -- 随机生成product_price
            SET v_product_price = ROUND((RAND() * (200 - 20 + 1)) + 20, 2);

            -- 生成随机日期
            SET v_product_create_time = DATE_ADD('2017-01-01', INTERVAL FLOOR(RAND() * (DATEDIFF('2024-12-31', '2017-01-01') + 1)) DAY);

            -- 随机选择product_type
            SET v_product_type = SUBSTRING_INDEX(SUBSTRING_INDEX(product_types, ',', FLOOR(1 + (RAND() * 6))), ',', -1);

            INSERT INTO `db_real_system`.`sys_product` (
                `product_name`,
                `product_title`,
                `product_avatar`,
                `product_price`,
                `product_count`,
                `product_sale_count`,
                `product_status`,
                `product_create_time`,
                `product_cb`,
                `product_type`
            ) VALUES (
                         '花花公子春季卫衣男装圆领套头长袖t恤青年男士简约绣花打底衫潮',
                         '花花公子正品 默认圆通 送运费险',
                         'https://gw.alicdn.com/imgextra/i3/3314876883/O1CN01JQEewK20iSvi1jk8Q_!!3314876883.jpg',
                         v_product_price,
                         v_product_count,
                         v_product_sale_count,
                         v_product_status,
                         v_product_create_time,
                         v_product_cb,
                         v_product_type
                     );

            SET i = i + 1;
        END WHILE;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
