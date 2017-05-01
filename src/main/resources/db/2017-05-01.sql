/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : sumanager

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-05-01 16:12:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL COMMENT 'ѧ��ѧ��',
  `username` varchar(255) NOT NULL COMMENT 'ѧ������',
  `password` varchar(255) NOT NULL COMMENT 'ѧ������',
  `sex` tinyint(1) DEFAULT NULL COMMENT '�Ա�',
  `email` varchar(255) DEFAULT NULL COMMENT '�����ַ',
  `screenName` varchar(255) DEFAULT NULL COMMENT 'ѧ',
  `locale` varchar(255) DEFAULT NULL COMMENT '��ַ',
  `enabled` tinyint(1) DEFAULT NULL COMMENT '״̬',
  `activated` tinyint(1) DEFAULT NULL COMMENT '����',
  `registertime` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `lastlogintime` datetime DEFAULT NULL COMMENT '����¼ʱ��',
  `registerip` varchar(255) DEFAULT NULL COMMENT 'ע��ip',
  `mobile` varchar(255) DEFAULT NULL COMMENT '�绰',
  `type` int(11) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '��ֵ',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('213456789', '梁静茹', 'e10adc3949ba59abbe56e057f20f883e', '2', null, '梁静茹', 'zh_CN', '1', '1', '2017-04-23 16:18:20', null, '192.168.1.100', '213456789', '1', null, '2017-04-23 16:18:20');
INSERT INTO `account` VALUES ('18345961235', '女女', 'e10adc3949ba59abbe56e057f20f883e', '1', '56135@qq.com', '18345961231', 'zh_CN', '1', '1', '2017-04-23 19:14:52', null, '192.168.1.14', '18345961231', '1', null, '2017-04-23 19:14:52');
INSERT INTO `account` VALUES ('18345961238', '男男', 'e10adc3949ba59abbe56e057f20f883e', '1', '', '18345961231', 'zh_CN', '1', '1', '2017-04-23 19:15:58', null, '192.168.1.14', '18345961231', '1', null, '2017-04-23 19:15:58');
INSERT INTO `account` VALUES ('201204160109', '小豆子', 'e10adc3949ba59abbe56e057f20f883e', '1', '', null, null, '1', '1', '2017-04-23 16:05:47', '2017-04-23 16:05:49', null, null, '6', null, '2017-04-23 16:05:54');
INSERT INTO `account` VALUES ('201204160111', '苏有朋', 'e10adc3949ba59abbe56e057f20f883e', '1', null, '苏有朋', 'zh_CN', '1', '1', '2017-04-23 16:08:44', null, '192.168.1.100', '15645671234', '1', null, '2017-04-23 16:08:44');
INSERT INTO `account` VALUES ('201304040102', '荆志宝', 'e10adc3949ba59abbe56e057f20f883e', '1', null, '荆志宝', 'zh_CN', '1', '1', '2017-04-23 19:11:03', null, '192.168.1.14', '18345961231', '1', null, '2017-04-23 19:11:03');
INSERT INTO `account` VALUES ('201304040202', '蔡克然', 'e10adc3949ba59abbe56e057f20f883e', '1', null, '蔡克然', 'zh_CN', '1', '1', '2017-04-23 16:43:26', null, '192.168.1.100', '18614033692', '1', null, '2017-04-23 16:43:26');
INSERT INTO `account` VALUES ('201601101254', '张天爱', 'e10adc3949ba59abbe56e057f20f883e', '1', null, '张天爱', 'zh_CN', '1', '1', '2017-04-23 16:00:22', null, '192.168.1.100', '135225896223', '1', null, '2017-04-23 16:00:22');
INSERT INTO `account` VALUES ('4561456445123', ' 荆志宝', 'e10adc3949ba59abbe56e057f20f883e', '1', null, ' 荆志宝', 'zh_CN', '1', '1', '2017-04-23 16:55:36', null, '192.168.1.100', '18614033692', '1', null, '2017-04-23 16:55:36');

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '�����',
  `subtitle` varchar(255) DEFAULT NULL COMMENT 'С����',
  `content` text,
  `limitnum` int(11) DEFAULT NULL COMMENT '��������',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `department_member_id` bigint(20) DEFAULT NULL COMMENT '���ų�Աid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('3', '劳动开创未来 习近平这样描述追梦之路', null, '<p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">幸福不会从天而降，梦想不会自动成真。党的十八以来，在以***同志为核心的党***下，全党和全国各族人民进入了全面建设小康社会新的历史时期。而全面小康的美好蓝图，需要全国人民共同付出艰苦的努力。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　“要真正做到一张好的蓝图一干到底，切实干出成效来，我们要有钉钉子的精神。”党的十八大以来，***在多个场合礼赞劳动创造，讴歌劳动精神，号召工人阶级和广大劳动群众承担庄严使命，投身伟大事业。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　2013年4月28日，***在同全国劳动模范代表座谈时指出“人民创造历史，劳动开创未来。实现我们的奋斗目标，开创我们的美好未来，必须紧紧依靠人民、始终为了人民，必须依靠辛勤劳动、诚实劳动、创造性劳动，必须充分发挥我国工人阶级的重要作用，焕发他们的历史主动精神，调动劳动和创造的积极性。”</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　这段话深刻揭示了实现梦想的逻辑思维，指明了共筑梦想的根本力量，鼓舞起亿万劳动者向着梦想坚毅前行的决心和信心。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　功崇惟志、业广惟勤。在中国由贫弱走向复兴的伟大进程中，一代又一代劳动者顽强拼搏，默默奉献，撑起了发展进步的航船，书写了劳动创造的辉煌。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　<strong>实干兴邦，劳动托起中国梦</strong></p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　“劳动是一切成功的必经之路。”***常说的一句话就是“空谈误国，实干兴邦”。实干首先就要脚踏实地的劳动。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　在我们党团结带领人民进行革命、建设、改革各个历史时期，以劳动模范为代表的广大劳动者辛勤耕耘、砥砺奋进，共同奏响了劳动最光荣、劳动最崇高、劳动最伟大、劳动最美丽的时代强音。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　从“兵工事业开拓者”的吴运铎、“边区工人一面旗帜”的赵占魁，到“宁肯一人脏、换来万人净”的时传祥；从“高炉卫士”孟泰、“两弹元勋”邓稼先，到“中国航空发动机之父”的吴大观等一大批劳动模范和先进工作者，干一行、爱一行，专一行、精一行，带动群众锐意进取、积极投身建立新中国和社会主义现代化建设，为国家和人民建立了杰出功勋。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　2015年4月28日，在庆祝“五一”国际劳动节暨表彰全国劳动模范和先进工作者大会上***指出，“劳动是人类的本质活动，劳动光荣、创造伟大是对人类文明进步规律的重要诠释。”“无论时代条件如何变化，我们始终都要崇尚劳动、尊重劳动者，始终重视发挥工人阶级和广大劳动群众的主力军作用。”这是我们凝心聚力实现中国梦的必经之路，也是我们纪念“五一”国际劳动节的重大意义。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　如今，中华民族正在实现伟大复兴的道路上昂首阔步，中国人民正在全面小康的决胜阶段砥砺前行，我们的国家正在创新改革的深水区攻坚克难，中华民族的大好河山呈现出一片生机盎然、催人奋进的景象。真抓才能攻坚克难，实干才能梦想成真。正如***所指出“全面建成小康社会，进而建成富强***文明和谐的社会主义现代化国家，根本上靠劳动、靠劳动者创造。”</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　<strong>爱岗敬业，造就时代新风尚</strong></p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　塑造劳动风尚，彰显劳动价值，***始终强调要弘扬劳模精神、劳动精神。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　从1921年中国***建立至今的96年来，工人阶级和广大劳动人民群众紧跟着党的前进步伐，积极投身革命、建设、改革的时代洪流，为实现国家独立和人民解放、国家富强和人民幸福做出了不可磨灭的历史性贡献。一路走来，“中国奇迹”的创造、“中国震撼”的交响，无不凝聚着广大劳动者的智慧和汗水。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　回首新中国建立60多年来，一代又一代先进模范人物在各自的工作岗位上建功成才，他们用自己辛勤劳动和开拓精神谱写着“换了人间”的动人篇章。劳动模范身上那种爱岗敬业、无私奉献、艰苦奋斗、勇于创新的优秀品质和时代精神激励着许许多多的人平波奋进，影响了几代人的人生追求。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　2013年4月28日，***在全国总工会机关同全国劳动模范代表座谈时指出，长期以来，广大劳模以高度的主人翁责任感、卓越的劳动创造、忘我的拼搏奉献，谱写出一曲曲可歌可泣的动人赞歌，铸就了“爱岗敬业、争创一流，艰苦奋斗、勇于创新，淡泊名利、甘于奉献”的劳模精神，为全国各族人民树立了光辉的学习榜样。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　一个国家的社会风尚将直接影响这个国家人民的精神面貌，当尊重劳动的意识蔚然成风时，将对这个国家的发展产生巨大的积极影响。2013年4月28日，***在同全国劳动模范代表座谈时，望着眼前一位位耳熟能详的劳模，他充满感情地说：“在我们党团结带领人民进行革命、建设、改革各个历史时期，劳动模范始终是我国工人阶级中一个闪光的群体，享有崇高声誉，备受人民尊敬。”***说，人民创造历史，劳动开创未来。在迈向未来的征程上，我们必须充分发挥我国工人阶级的重要作用，焕发他们的历史主动精神，调动劳动和创造的积极性。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　<strong>勇立潮头，书写时代新篇章</strong></p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　“伟大的事业呼唤着我们，庄严的使命激励着我们。”我们正处在一个催人奋进的时代，从事着前无古人的伟大事业。长期以来，以劳模为代表的广大劳动人民群众立足本职、辛勤工作、默默奉献，在为经济社会发展做出了巨大贡献、创造了巨大物质财富的同时，也留下了宝贵的精神财富。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　“让劳动光荣、创造伟大成为铿锵的时代强音。”2015年4月28日，全国劳动模范和先进工作者表彰大会上******的讲话，在全体劳动者心中激起热烈回响。五年一度的隆重表彰仪式，弘扬的是劳动的精神，塑造的是劳动的风尚，彰显的是劳动的价值。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　劳动者，既是建设国家、实现中国梦的中坚力量，又是一个个真实、朴实且平凡的追梦者。在中华民族伟大复兴的关键时刻、在全面建成小康社会的决胜阶段，主人翁意识、工匠精神、劳模精神是实现中国梦的重要保障，也是劳动人民群众追梦路上的精神食粮。</p><p style=\"margin-top: 20px; margin-bottom: 0px; padding: 0px; line-height: 42px; font-size: 18px; color: rgb(51, 51, 51); font-family: 微软雅黑; white-space: normal; background-color: rgb(255, 255, 255);\">　　对于当代中国，劳动精神不应该褪色。审视中国的历史方位，我们站上了历史的高岗，但如何让“中国制造”升级为“中国智造”？如何增强贫困地区的内生动力，打破贫困的代际传递，让更多的人同步进入小康？如何让青年人补足精神钙质，挥动自立自强的臂膀？一个个时代之问，答案可能各不相同，但又一脉相通：不管时代如何变化，劳动是一切成功的必由之路，也是一切梦想的坚实底座。（由央视网提供）</p><p><br/></p>', '100', '2017-05-01 12:22:05', '2017-05-01 12:22:06', '2', '1', null);
INSERT INTO `activity` VALUES ('10', '1564', '456465', '<p><img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/></p>', '45646032', '2017-05-01 13:44:10', '2017-05-01 13:44:12', '2', '1', null);
INSERT INTO `activity` VALUES ('13', '好想你', null, '<p style=\"text-align:center\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://img.desy.net/video/f9bb0ac5-4953-4891-9f61-4b1e72d804e4-6714771_MP4.mp4\" data-setup=\"{}\"></video></p><p><br/></p>', '50', '2017-05-01 14:55:06', '2017-05-01 14:55:07', '3', '1', null);
INSERT INTO `activity` VALUES ('14', '人民的名义', null, '<ul class=\" list-paddingleft-2\"><li class=\"title\" style=\"\"><ul class=\"lemmaWgt-lemmaTitle lemmaWgt-lemmaTitle- list-paddingleft-2\" style=\"margin: 0px 0px 10px; padding: 0px; width: 700px;\"><li class=\"lemmaWgt-lemmaTitle-title\" style=\"\"><h1 style=\"margin: 0px 10px 0px 0px; padding: 0px; font-size: 38px; display: inline; line-height: 1.15; font-weight: 400; vertical-align: sub;\">人民的名义</h1><p>&nbsp;<a class=\"edit-lemma cmn-btn-hover-blue cmn-btn-28 j-edit-link\" style=\"color: rgb(102, 102, 102); display: inline-block; border: 1px solid rgb(197, 197, 197); border-radius: 3px; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial; text-align: center; line-height: 14px; padding: 6px 0px; position: relative; margin: 0px 5px 0px 0px; width: 60px; outline: 0px; height: 14px; top: -2px;\"><span class=\"cmn-icon wiki-lemma-icons wiki-lemma-icons_edit-lemma\" style=\"-webkit-font-smoothing: antialiased; speak: none; line-height: 12px; outline: 0px; font-family: baikeFont_layout; margin: 0px 7px 0px 0px; vertical-align: text-top; color: rgb(82, 163, 245);\"></span>编辑</a></p></li><li class=\"lemmaWgt-lemmaTitle-keyInfo\" style=\"\"><ul style=\"list-style-type: none;\" class=\" list-paddingleft-2\"><li><p>中国大陆</p></li><li><p>52集</p></li></ul></li></ul></li><li class=\"desc\" style=\"\"><p>《人民的名义》是由<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%9D%8E%E8%B7%AF\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">李路</a>执导、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%91%A8%E6%A2%85%E6%A3%AE\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">周梅森</a>编剧的检察反腐电视剧，由<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E9%99%86%E6%AF%85\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">陆毅</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%BC%A0%E4%B8%B0%E6%AF%85\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张丰毅</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%90%B4%E5%88%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">吴刚</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E8%AE%B8%E4%BA%9A%E5%86%9B\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">许亚军</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%BC%A0%E5%BF%97%E5%9D%9A\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张志坚</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%9F%AF%E8%93%9D\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">柯蓝</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E8%83%A1%E9%9D%99\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">胡静</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%BC%A0%E5%87%AF%E4%B8%BD\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张凯丽</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E8%B5%B5%E5%AD%90%E7%90%AA\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">赵子琪</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E7%99%BD%E5%BF%97%E8%BF%AA\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">白志迪</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%9D%8E%E5%BB%BA%E4%B9%89\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">李建义</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E9%AB%98%E4%BA%9A%E9%BA%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">高亚麟</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E4%B8%81%E6%B5%B7%E5%B3%B0\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">丁海峰</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%86%AF%E9%9B%B7\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">冯雷</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%9D%8E%E5%85%89%E5%A4%8D\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">李光复</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%BC%A0%E6%99%9E%E4%B8%B4\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">张晞临</a>等联袂主演，<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E4%BE%AF%E5%8B%87\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">侯勇</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%B2%88%E6%99%93%E6%B5%B7\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">沈晓海</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E4%BE%AF%E5%A4%A9%E6%9D%A5\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">侯天来</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%91%A8%E6%B5%A9%E4%B8%9C\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">周浩东</a>、<a target=\"_blank\" href=\"http://baike.baidu.com/item/%E5%88%98%E4%BC%9F\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">刘伟</a>等特别出演。</p><p>该剧以检察官侯亮平的调查行动为叙事主线，讲述了当代检察官维护公平正义和法制统一、查办贪腐案件的故事，于2017年3月28日在湖南卫视“金鹰独播剧场”播出。<span style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: pointer; padding: 0px 2px;\">[1]</span><a class=\"sup-anchor\" style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\">&nbsp;</a></p></li><dl><dd class=\"middleContent\" style=\"margin: 0px; padding: 0px; color: rgb(51, 51, 51); font-family: arial, tahoma, &quot;Microsoft Yahei&quot;, 宋体, sans-serif; font-size: 12px; white-space: normal; background-color: rgb(255, 255, 255);\"></dd></dl><li class=\"featureBaseInfo\" style=\"\"><ul class=\" list-paddingleft-2\" style=\"margin: 0px; padding: 0px; border-bottom: 1px dashed rgb(229, 229, 229);\"><li><p>类型</p></li><li><p>当代、反腐、检察</p></li></ul><ul class=\" list-paddingleft-2\" style=\"margin: 0px; padding: 0px; border-bottom: 1px dashed rgb(229, 229, 229);\"><li><p>导演</p></li><li><p><a target=\"_blank\" href=\"http://baike.baidu.com/item/%E6%9D%8E%E8%B7%AF/4847406\" style=\"color: rgb(19, 110, 194); text-decoration-line: none;\">李路</a></p></li></ul><ul class=\" list-paddingleft-2\" style=\"margin: 0px; padding: 0px; border-bottom: 1px dashed rgb(229, 229, 229);\"><li><p>出品公司</p></li><li><p>最高人民检察院影视中心等单位<span style=\"font-size: 12px; line-height: 0; position: relative; vertical-align: baseline; top: -0.5em; margin-left: 2px; color: rgb(51, 102, 204); cursor: default; padding: 0px 2px;\">[1]</span><a class=\"sup-anchor\" style=\"color: rgb(19, 110, 194); position: relative; top: -50px; font-size: 0px; line-height: 0;\">&nbsp;</a></p></li></ul><ul class=\"play list-paddingleft-2\" style=\"margin: 0px; padding: 0px; height: 48px; border-bottom: 1px dashed rgb(229, 229, 229);\"><li><p>在线观看</p></li><li><p><a target=\"_blank\" href=\"http://www.iqiyi.com/v_19rrb59or4.html?vfm=m_127_bdbk\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: inline-block; outline: 0px; height: 30px; line-height: 30px; font-size: 14px; margin: 6px 4px 0px 0px; padding: 0px 10px 0px 25px; border-radius: 3px; background: url(&quot;http://baike.bdimg.com/static/wiki-lemma/widget/feature/common/poster/baseCards/baseInfo/img/play_8c39bf5.png&quot;) 5px center no-repeat rgb(252, 252, 252); border: 1px solid rgb(218, 219, 220);\">爱奇艺</a>&nbsp;<a target=\"_blank\" href=\"http://www.mgtv.com/b/312289/3882167.html?cxid=19sgybcjiq\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: inline-block; outline: 0px; height: 30px; line-height: 30px; font-size: 14px; margin: 6px 4px 0px 0px; padding: 0px 10px 0px 25px; border-radius: 3px; background: url(&quot;http://baike.bdimg.com/static/wiki-lemma/widget/feature/common/poster/baseCards/baseInfo/img/play_8c39bf5.png&quot;) 5px center no-repeat rgb(252, 252, 252); border: 1px solid rgb(218, 219, 220);\">芒果TV</a>&nbsp;<a target=\"_blank\" href=\"http://v.youku.com/v_show/id_XMjczMzEwNzQ2OA==.html?tpa=dW5pb25faWQ9MTAzNzA4XzEwMDAwMV8wMV8wMQ\" style=\"color: rgb(19, 110, 194); text-decoration-line: none; display: inline-block; outline: 0px; height: 30px; line-height: 30px; font-size: 14px; margin: 6px 4px 0px 0px; padding: 0px 10px 0px 25px; border-radius: 3px; background: url(&quot;http://baike.bdimg.com/static/wiki-lemma/widget/feature/common/poster/baseCards/baseInfo/img/play_8c39bf5.png&quot;) 5px center no-repeat rgb(252, 252, 252); border: 1px solid rgb(218, 219, 220);\">优酷</a></p></li></ul><ul style=\"margin: 0px; padding: 0px;\" class=\" list-paddingleft-2\"><li><p><span class=\"ac_title\" style=\"font-size: 14px; font-weight: 700;\">主要演员</span><a href=\"http://baike.baidu.com/link?url=D4TFmD8kT8sFRDi6MFfSsweY8Dc77Pg_dTkrpIhnL9FWX4qbDLs7h-GPdJKqY-4eRBYzAHV2RhtTuDLLEPySEDuqE47kmyo1dEwXc2pHDKsSvfEc49_KHb_efvrCLcQQ9hn7z25B4dnNqDissDyF2a#%E6%BC%94%E8%81%8C%E5%91%98%E8%A1%A8\" class=\"more\" style=\"color: rgb(102, 102, 102); text-decoration-line: none; float: right;\">更多</a></p></li><li><p><a href=\"http://baike.baidu.com/item/%E9%99%86%E6%AF%85/361763\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"></a></p><p><a href=\"http://baike.baidu.com/item/%E9%99%86%E6%AF%85/361763\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"><img src=\"http://e.hiphotos.baidu.com/baike/whfpf%3D80%2C80%2C0/sign=aa3fc251abaf2eddd4a41aa9eb2d39d9/0dd7912397dda1447102d0e5b5b7d0a20cf4865a.jpg\"/></a></p><p class=\"actorName\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: center; white-space: nowrap; text-overflow: ellipsis; overflow: hidden; line-height: 30px;\"><a href=\"http://baike.baidu.com/item/%E9%99%86%E6%AF%85/361763\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\">陆毅</a></p><p></p></li><li><p><a href=\"http://baike.baidu.com/item/%E5%BC%A0%E4%B8%B0%E6%AF%85/2139258\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"></a></p><p><a href=\"http://baike.baidu.com/item/%E5%BC%A0%E4%B8%B0%E6%AF%85/2139258\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"><img src=\"http://e.hiphotos.baidu.com/baike/whfpf%3D80%2C80%2C0/sign=3d75fca453fbb2fb347e0b5229771894/10dfa9ec8a136327064b36ca978fa0ec09fac7a1.jpg\"/></a></p><p class=\"actorName\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: center; white-space: nowrap; text-overflow: ellipsis; overflow: hidden; line-height: 30px;\"><a href=\"http://baike.baidu.com/item/%E5%BC%A0%E4%B8%B0%E6%AF%85/2139258\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\">张丰毅</a></p><p></p></li><li><p><a href=\"http://baike.baidu.com/item/%E5%90%B4%E5%88%9A/2234630\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"></a></p><p><a href=\"http://baike.baidu.com/item/%E5%90%B4%E5%88%9A/2234630\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\"><img src=\"http://f.hiphotos.baidu.com/baike/whfpf%3D80%2C80%2C0/sign=848dfa9785025aafd3672d8b9dd09354/34fae6cd7b899e515a2d864345a7d933c9950dc1.jpg\"/></a></p><p class=\"actorName\" style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; text-align: center; white-space: nowrap; text-overflow: ellipsis; overflow: hidden; line-height: 30px;\"><a href=\"http://baike.baidu.com/item/%E5%90%B4%E5%88%9A/2234630\" target=\"_blank\" style=\"color: rgb(102, 102, 102); text-decoration-line: none;\">吴刚</a></p><p></p></li></ul><p><span class=\"vTitle\" style=\"font-size: 14px; font-weight: 700; line-height: 34px;\">精彩片段</span><a class=\"gen_videoBox\" title=\"\" style=\"color: rgb(19, 110, 194); height: 80px; width: 106px; display: block; background: rgb(51, 51, 51); position: relative; overflow: hidden;\"><img src=\"http://g.hiphotos.baidu.com/baike/whfpf%3D106%2C80%2C50/sign=d78ea5485c4e9258a661d5aefabfe068/3b87e950352ac65cce952b5ff1f2b21193138a0e.jpg\" height=\"80\" width=\"106\" alt=\"\" class=\"vImg\"/></a></p></li></ul><p style=\"text-align:center\"><video class=\"edui-upload-video  vjs-default-skin video-js\" controls=\"\" preload=\"none\" width=\"420\" height=\"280\" src=\"http://img.desy.net/video/57269f8d-1104-447a-a5a5-77dbf259f08f-26.mp4\" data-setup=\"{}\"></video></p><p><br/></p>', '50', '2017-05-01 15:25:54', '2017-05-01 15:25:55', '3', '1', null);

-- ----------------------------
-- Table structure for activity_member
-- ----------------------------
DROP TABLE IF EXISTS `activity_member`;
CREATE TABLE `activity_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `stratus` varchar(255) DEFAULT NULL COMMENT '״̬',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '�id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_member
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '�id',
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `content` varchar(255) DEFAULT NULL COMMENT '��������',
  `status` varchar(255) DEFAULT NULL COMMENT '״̬',
  `parentid` bigint(20) DEFAULT NULL COMMENT '����id',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '��������',
  `description` varchar(255) DEFAULT NULL COMMENT '��������',
  `photo_url` varchar(255) DEFAULT NULL COMMENT 'ͼƬ��ַ',
  `goal` varchar(255) DEFAULT NULL COMMENT '����Ŀ��',
  `function` varchar(255) DEFAULT NULL COMMENT '����ְ��',
  `org_id` bigint(20) DEFAULT NULL COMMENT '��֯(Ժϵ)id',
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('2', '网络部', '没有描述', 'www.baidu.com', '没有目标', '没有职能', '1', '2017-04-24 22:59:20');
INSERT INTO `department` VALUES ('3', '新闻中心', '没有描述', 'www.baidu.com', '没有目标', '没有职能', '1', '2017-04-24 22:59:52');
INSERT INTO `department` VALUES ('4', '中华人民共和国外交部', '中华人民共和国外交部', null, null, '中华人民共和国外交部', '1', '2017-05-01 14:24:48');
INSERT INTO `department` VALUES ('5', '中华人民共和国国防部', '中华人民共和国国防部', null, null, '中华人民共和国国防部', '1', '2017-05-01 14:24:50');
INSERT INTO `department` VALUES ('6', '国家发展和改革委员会', '国家发展和改革委员会', null, null, '国家发展和改革委员会', '1', '2017-05-01 14:24:52');
INSERT INTO `department` VALUES ('7', '中华人民共和国教育部', '中华人民共和国教育部', null, null, '中华人民共和国教育部', '1', '2017-05-01 14:24:55');
INSERT INTO `department` VALUES ('8', '中华人民共和国科学技术部', '中华人民共和国科学技术部', null, null, '中华人民共和国科学技术部', '1', '2017-05-01 14:24:59');
INSERT INTO `department` VALUES ('9', '中华人民共和国工业和信息化部', '中华人民共和国工业和信息化部', null, null, '中华人民共和国工业和信息化部', '1', '2017-05-01 14:25:01');
INSERT INTO `department` VALUES ('10', '中华人民共和国国家民族事务委员会', '中华人民共和国国家民族事务委员会', null, null, '中华人民共和国国家民族事务委员会', '1', '2017-05-01 14:25:04');
INSERT INTO `department` VALUES ('11', '中华人民共和国公安部', '中华人民共和国公安部', null, null, '中华人民共和国公安部', '1', '2017-05-01 14:25:07');
INSERT INTO `department` VALUES ('12', '中华人民共和国国家安全部', '中华人民共和国国家安全部', null, null, '中华人民共和国国家安全部', '1', '2017-05-01 14:25:09');
INSERT INTO `department` VALUES ('13', '中华人民共和国监察部', '中华人民共和国监察部', null, null, '中华人民共和国监察部', '1', '2017-05-01 14:25:11');
INSERT INTO `department` VALUES ('14', '中华人民共和国民政部', '中华人民共和国民政部', null, null, '中华人民共和国民政部', '1', '2017-05-01 14:25:17');
INSERT INTO `department` VALUES ('15', '中华人民共和国司法部', '中华人民共和国司法部', null, null, '中华人民共和国司法部', '1', '2017-05-01 14:25:14');
INSERT INTO `department` VALUES ('16', '中华人民共和国财政部', '中华人民共和国财政部', null, null, '中华人民共和国财政部', '1', '2017-05-01 14:25:19');
INSERT INTO `department` VALUES ('17', '中华人民共和国人力资源和社会保障部', '中华人民共和国人力资源和社会保障部', null, null, '中华人民共和国人力资源和社会保障部', '1', '2017-05-01 14:25:22');
INSERT INTO `department` VALUES ('18', '中华人民共和国国土资源部', '中华人民共和国国土资源部', null, null, '中华人民共和国国土资源部', '1', '2017-05-01 14:25:24');
INSERT INTO `department` VALUES ('19', '中华人民共和国环境保护部', '中华人民共和国环境保护部', null, null, '中华人民共和国环境保护部', '1', '2017-05-01 14:25:27');
INSERT INTO `department` VALUES ('20', '中华人民共和国住房和城乡建设部', '中华人民共和国住房和城乡建设部', null, null, '中华人民共和国住房和城乡建设部', '1', '2017-05-01 14:25:30');
INSERT INTO `department` VALUES ('21', '中华人民共和国交通运输部', '中华人民共和国交通运输部', null, null, '中华人民共和国交通运输部', '1', '2017-05-01 14:25:32');
INSERT INTO `department` VALUES ('22', '中华人民共和国铁道部', '中华人民共和国铁道部', null, null, '中华人民共和国铁道部', '1', '2017-05-01 14:25:35');
INSERT INTO `department` VALUES ('23', '中华人民共和国水利部', '中华人民共和国水利部', null, null, '中华人民共和国水利部', '1', '2017-05-01 14:25:37');
INSERT INTO `department` VALUES ('24', '中华人民共和国农业部', '中华人民共和国农业部', null, null, '中华人民共和国农业部', '1', '2017-05-01 14:25:39');
INSERT INTO `department` VALUES ('25', '中华人民共和国商务部', '中华人民共和国商务部', null, null, '中华人民共和国商务部', '1', '2017-05-01 14:25:42');
INSERT INTO `department` VALUES ('26', '中华人民共和国文化部', '中华人民共和国文化部', null, null, '中华人民共和国文化部', '1', '2017-05-01 14:25:44');
INSERT INTO `department` VALUES ('27', '中华人民共和国卫生部', '中华人民共和国卫生部', null, null, '中华人民共和国卫生部', '1', '2017-05-01 14:25:49');
INSERT INTO `department` VALUES ('28', '人口和计划生育委员会', '人口和计划生育委员会', null, null, '人口和计划生育委员会', '1', '2017-05-01 14:25:51');
INSERT INTO `department` VALUES ('29', '中国人民银行', '中国人民银行', null, null, '中国人民银行', '1', '2017-05-01 14:25:54');
INSERT INTO `department` VALUES ('30', '中华人民共和国审计署', '中华人民共和国审计署', null, null, '中华人民共和国审计署', '1', '2017-05-01 14:25:56');

-- ----------------------------
-- Table structure for department_apply
-- ----------------------------
DROP TABLE IF EXISTS `department_apply`;
CREATE TABLE `department_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountId` bigint(20) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `content` text,
  `status` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of department_apply
-- ----------------------------
INSERT INTO `department_apply` VALUES ('30', '201204160109', '12', '6', '<pre clas***rush:java;toolbar:false\">Account&nbsp;account&nbsp;=&nbsp;(Account)&nbsp;request.getSession().getAttribute(&quot;currentAccount&quot;);\nif&nbsp;(account&nbsp;==&nbsp;null)&nbsp;{\n&nbsp;&nbsp;&nbsp;&nbsp;ResultUtil.fail(LocalizationUtil.getClientString(&quot;Account_22&quot;,&nbsp;request),&nbsp;response);\n&nbsp;&nbsp;&nbsp;&nbsp;return;\n}\nlong&nbsp;applyId&nbsp;=&nbsp;ParamUtils.getLongParameter(request,&nbsp;&quot;applyId&quot;,&nbsp;0L);\n\nDepartmentApply&nbsp;departmentApply&nbsp;=&nbsp;departmentApplyService.findById(applyId);\nif(departmentApply&nbsp;==&nbsp;null){\n&nbsp;&nbsp;&nbsp;&nbsp;ResultUtil.fail(LocalizationUtil.getClientString(&quot;Account_22&quot;,&nbsp;request),&nbsp;response);\n&nbsp;&nbsp;&nbsp;&nbsp;return;\n}\nint&nbsp;status&nbsp;=&nbsp;ParamUtils.getIntParameter(request,&nbsp;&quot;status&quot;,&nbsp;0);\nif(status&nbsp;==&nbsp;0){\n&nbsp;&nbsp;&nbsp;&nbsp;ResultUtil.fail(LocalizationUtil.getClientString(&quot;Account_22&quot;,&nbsp;request),&nbsp;response);\n&nbsp;&nbsp;&nbsp;&nbsp;return;\n}</pre><p><br/></p>', '3', '2017-05-01 15:24:10');
INSERT INTO `department_apply` VALUES ('32', '201204160111', '3', '6', '<p>给个部长当当</p>', '2', '2017-05-01 15:49:16');
INSERT INTO `department_apply` VALUES ('33', '201204160111', '4', '5', '<p>给我通过试试</p>', '2', '2017-05-01 15:49:48');
INSERT INTO `department_apply` VALUES ('34', '201204160111', '6', '4', '<p>我就申请八个部门</p>', '2', '2017-05-01 15:51:25');

-- ----------------------------
-- Table structure for department_member
-- ----------------------------
DROP TABLE IF EXISTS `department_member`;
CREATE TABLE `department_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountId` bigint(20) DEFAULT NULL,
  `departmentId` bigint(20) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL COMMENT '����',
  `remark` varchar(255) DEFAULT NULL COMMENT '����',
  `status` varchar(255) DEFAULT NULL COMMENT '״̬',
  `ctreateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_member
-- ----------------------------
INSERT INTO `department_member` VALUES ('8', '201204160109', '12', '6', '', '1', '2017-05-01 15:24:39');
INSERT INTO `department_member` VALUES ('9', '201204160111', '3', '6', '', '1', '2017-05-01 15:48:42');

-- ----------------------------
-- Table structure for function
-- ----------------------------
DROP TABLE IF EXISTS `function`;
CREATE TABLE `function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of function
-- ----------------------------
INSERT INTO `function` VALUES ('1', '机构信息管理', '/organization/list', '6', '1', '2017-04-20 22:44:20', '2');
INSERT INTO `function` VALUES ('2', '账号信息管理', '/account/list', '6', '1', '2017-04-20 22:44:44', '1');
INSERT INTO `function` VALUES ('3', '活动管理', '/activity/list', '4', '1', '2017-04-23 11:56:24', '3');
INSERT INTO `function` VALUES ('4', '部门管理', '/department/list', '5', '1', '2017-04-25 23:35:00', '4');
INSERT INTO `function` VALUES ('6', '职位申请', '/departmentApply/add', '1', '1', '2017-04-30 18:32:16', '5');
INSERT INTO `function` VALUES ('7', '我的申请', '/departmentApply/list', '1', '1', '2017-04-30 20:51:35', '6');
INSERT INTO `function` VALUES ('8', '审核申请', '/departmentApply/applyList', '5', '1', '2017-04-30 22:19:31', '7');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo��ַ',
  `name` varchar(255) DEFAULT NULL COMMENT '����(Ժϵ)����',
  `createtime` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '201204160109', null, '计算机学生会', '2017-04-19 00:59:09');
