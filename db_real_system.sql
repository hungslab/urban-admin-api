-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept (
                        dept_id           bigint(20)      not null auto_increment    comment '部门id',
                        dept_name         varchar(30)     default ''                 comment '部门名称',
                        leader            varchar(20)     default null               comment '负责人',
                        phone             varchar(11)     default null               comment '联系电话',
                        email             varchar(50)     default null               comment '邮箱',
                        status            char(1)         default '0'                comment '部门状态（0正常 1停用）',
                        del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                        create_by         varchar(64)     default ''                 comment '创建者',
                        create_time 	    datetime                                   comment '创建时间',
                        update_by         varchar(64)     default ''                 comment '更新者',
                        update_time       datetime                                   comment '更新时间',
                        primary key (dept_id)
) engine=innodb auto_increment=200 comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into sys_dept values(100,  '销售部',   'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(101,  '市场部门',   'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(102,  '技术部门',   'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(103,  '财务部门',   'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);
insert into sys_dept values(104,  '运维部门',   'admin', '15888888888', 'ry@qq.com', '0', '0', 'admin', sysdate(), '', null);

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user (
                          user_id           bigint(20)      not null auto_increment    comment '用户ID',
                          dept_id           bigint(20)      default null               comment '部门ID',
                          user_name         varchar(30)     not null                   comment '用户账号',
                          nick_name         varchar(30)     default ''                 comment '用户昵称',
                          user_type         varchar(2)      default '00'               comment '用户类型（00系统用户）',
                          email             varchar(50)     default ''                 comment '用户邮箱',
                          phonenumber       varchar(11)     default ''                 comment '手机号码',
                          sex               char(1)         default '0'                comment '用户性别（0男 1女 2未知）',
                          avatar            varchar(100)    default ''                 comment '头像地址',
                          password          varchar(100)    default ''                 comment '密码',
                          salt              varchar(20)     default ''                 comment '盐加密',
                          status            char(1)         default '0'                comment '帐号状态（0正常 1停用）',
                          del_flag          char(1)         default '0'                comment '删除标志（0代表存在 2代表删除）',
                          login_ip          varchar(128)    default ''                 comment '最后登录IP',
                          login_date        datetime                                   comment '最后登录时间',
                          create_by         varchar(64)     default ''                 comment '创建者',
                          create_time       datetime                                   comment '创建时间',
                          update_by         varchar(64)     default ''                 comment '更新者',
                          update_time       datetime                                   comment '更新时间',
                          remark            varchar(500)    default null               comment '备注',
                          primary key (user_id)
) engine=innodb auto_increment=100 comment = '用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
insert into sys_user values(1,  103, 'admin', 'admin', '00', 'admin@163.com', '15888888888', '1', '', '29c67a30398638269fe600f73a054934', '111111','0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '管理员');
insert into sys_user values(2,  105, 'ry',    '若依', '00', 'ry@qq.com',  '15666666666', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222','0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '测试员');
insert into sys_user values(3,  103, '张三', '张三', '01', 'zs@163.com',   '15444444444', '1', '', '29c67a30398638269fe600f73a054934', '111111','0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '普通用户');
insert into sys_user values(4,  105, '李四',  '李四', '01', 'ls@qq.com',  '15333333333', '1', '', '8e6d98b90472783cc73c17047ddccf36', '222222','0', '0', '127.0.0.1', sysdate(), 'admin', sysdate(), '', null, '普通用户');


-- ----------------------------
-- 3、操作日志记录
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log (
                              oper_id           bigint(20)      not null auto_increment    comment '日志主键',
                              description       varchar(50)     null                       comment '操作内容描述',
                              oper_name         varchar(50)     default ''                 comment '操作人员',
                              oper_ip           varchar(128)    default ''                 comment '主机地址',
                              operator_type     int(1)          default 0                  comment '操作类别',
                              method            varchar(100)    default ''                 comment '方法名称',
                              oper_param        varchar(2000)   default ''                 comment '请求参数',
                              json_result       varchar(2000)   default ''                 comment '返回参数',
                              oper_time         datetime                                   comment '操作时间',
                              remark            varchar(200)    null                       comment '备注',
                              primary key (oper_id)
) engine=innodb auto_increment=100 comment = '操作日志记录';

-- ----------------------------
-- 5、商品
-- ----------------------------
drop table if exists sys_product;
create table sys_product (
                           product_id          bigint(20)      not null auto_increment    comment '商品ID',
                           product_name        varchar(50)     default ''                 comment '商品名称',
                           product_title       varchar(50)     null                       comment '产品标题',
                           product_avatar      varchar(100)    default ''                 comment '商品图片',
                           product_price       decimal(10, 2)  default 0                  comment '商品价格',
                           product_count       int(10)         default 0                  comment '商品数量',
                           product_sale_count  int(10)         default 0                  comment '商品销量',
                           product_status      char(1)         default '1'                comment '商品状态（1上架 0下架）',
                           product_create_time datetime                                   comment '创建时间',
                           primary key (product_id)
) engine=innodb auto_increment=100 comment = '商品表';

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO sys_product VALUES (1, '2018春装新款韩版潮学生宽松薄款卫衣女长袖ins超火的上衣服外套', '春装新款百搭~~', ' ', 119.00, 99, 11,1, sysdate());
INSERT INTO sys_product VALUES (2, '乔琪诺牛仔卫衣女中长款连帽套头中袖韩版宽松2018新款连衣裙夏', '乔琪诺原创设计 送运费险', ' ', 119.00, 99, 11,1, sysdate());
INSERT INTO sys_product VALUES (3, '花花公子春季男士长袖衬衫免烫中青年休闲衬衣潮流男装印花衬衣', '送运费险 放心购物', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (4, '人本高帮帆布鞋内增高布鞋高邦高腰单鞋牛仔布系带学院风学生款女', '帆布鞋', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (5, '2018新款ins超火短款连帽卫衣女夏春季bf风薄款帽衫潮学生宽松', '潮流卫衣', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (6, '花花公子牛仔裤男修身款 秋冬季直筒商务休闲弹力男士牛仔长裤子', '花花公子正品 默认圆通 送运费险', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (7, '人本韩版女式低帮百搭帆布鞋系带浅口学生白色小白鞋文艺清新单鞋', '低帮帆布鞋', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (8, '花花公子长袖衬衫男士印花翻领薄款商务休闲衬衣中青年秋款男装潮', '潮男焕新 舒适体验 帅气有型 赠运费险', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (9, '早春新款韩版宽松长袖卫衣女连帽2018超火ins上衣学生百搭慵懒风', '早春新款宽松连帽卫衣', ' ', 119.00, 99, 11, 1, sysdate());
INSERT INTO sys_product VALUES (10, '花花公子春季卫衣男装圆领套头长袖t恤青年男士简约绣花打底衫潮', '花花公子正品 默认圆通 送运费险', ' ', 119.00, 99, 11, 1, sysdate());




-- ----------------------------
-- 4、订单订单
-- ----------------------------
drop table if exists sys_order;
create table sys_order (
                              order_id          bigint(20)      not null auto_increment    comment '订单ID',
                              order_name        varchar(50)     default ''                 comment '订单商品名称',
                              order_user        varchar(50)     default ''                 comment '下单用户',
                              pay_way           varchar(50)     default ''                 comment '支付方式',
                              order_price       varchar(9)      default ''                 comment '订单价格',
                              order_status      char(1)         default '0'                comment '订单状态（0上架 1下架）',
                              create_time       datetime                                   comment '创建时间',
                              primary key (order_id)
) engine=innodb auto_increment=100 comment = '订单表';

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `sys_order` VALUES (1, '花花公子春季男士长袖衬衫免烫中青年休闲衬衣潮流男装印花衬衣', '张三', '支付宝', 171.6, 1, sysdate());
INSERT INTO `sys_order` VALUES (2, '人本韩版女式低帮百搭帆布鞋系带浅口学生白色小白鞋文艺清新单鞋', '李四', '支付宝', 156.2, 1, sysdate());

-- ----------------------------
-- 5、支付方式
-- ----------------------------
drop table if exists sys_payway;
create table sys_payway (
                           payway_id          bigint(20)      not null auto_increment    comment '支付方式ID',
                           payway_name        varchar(50)     default ''                 comment '订单商品名称',
                           payway_status      char(1)         default '0'                comment '订单状态（0启用 1禁止）',
                           create_time        datetime                                   comment '创建时间',
                           primary key (payway_id)
) engine=innodb auto_increment=100 comment = '支付方式表';

INSERT INTO `sys_payway` VALUES (1, '支付宝', '0', sysdate());
INSERT INTO `sys_payway` VALUES (2, '微信', '0', sysdate());
INSERT INTO `sys_payway` VALUES (3, '银行卡', '0', sysdate());


-- ----------------------------
-- 5、商品评论
-- ----------------------------
DROP TABLE IF EXISTS `sys_review`;
CREATE TABLE `sys_review`  (
                           `review_id`          bigint(20)      NOT NULL AUTO_INCREMENT,
                           `review_content`     mediumtext      CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `review_create_time` datetime        NOT NULL,
                           `review_user_id`     bigint(20)      NOT NULL,
                           `review_product_id`  bigint(20)      NOT NULL,
                           `review_order_id`    bigint(20)      NOT NULL,
                           `review_status`      char(1)         default '0'        comment '评论状态（0未启用 1启用）',
                           PRIMARY KEY (`review_id`) USING BTREE
) engine=innodb auto_increment=100 comment = '商品评论表';

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `sys_review` VALUES (1, '测试测试测试测试测试测试', sysdate(), 1, 6, 55, 1);
INSERT INTO `sys_review` VALUES (2, '手机很好！！！！！！！！！！拍照很清晰', sysdate(), 1, 3, 53, 1);
INSERT INTO `sys_review` VALUES (3, '质量很好', sysdate(), 1, 2, 61, 1);
INSERT INTO `sys_review` VALUES (4, 'dda', sysdate(), 1, 1, 64, 1);
INSERT INTO `sys_review` VALUES (5, '很好', sysdate(), 1, 3, 65, 1);
INSERT INTO `sys_review` VALUES (6, '非常好看！质量也不错！', sysdate(), 1, 7, 82, 1);
INSERT INTO `sys_review` VALUES (7, '很早之前就加入购物车了！买回来后果然没失望！质量很好，穿着也很舒服！', sysdate(), 1, 5, 83, 1);
INSERT INTO `sys_review` VALUES (8, '衣服很好看，发货很及时！', sysdate(), 1, 1, 85, 1);
INSERT INTO `sys_review` VALUES (9, '衣服很好看！模特也是哦(笑', sysdate(), 1, 1, 86, 1);
INSERT INTO `sys_review` VALUES (10, '衣服很时尚，质量也挺好', sysdate(), 1, 1, 88, 1);
INSERT INTO `sys_review` VALUES (11, '给姐姐买的衣服，姐姐很喜欢！质量很不错', sysdate(), 1, 1, 87, 1);
INSERT INTO `sys_review` VALUES (12, '发的衣服有点大了，其他还行，好评给卖家一个鼓励！', sysdate(), 1, 1, 90, 1);
INSERT INTO `sys_review` VALUES (13, '发货过程有点慢，衣服还行吧！', sysdate(), 1, 1, 89, 1);
INSERT INTO `sys_review` VALUES (14, '衣服特别看好，穿上去特潮，男票超级喜欢\r\n好评！', sysdate(), 1, 1, 93, 1);