/*Table structure for table `roles` */

CREATE TABLE `roles` (
  `r_id` int(11) NOT NULL,
  `r_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `r_flag` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT '角色表';

/*Table structure for table `users` */

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `u_username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_last_login` datetime DEFAULT NULL,
  `u_login_ip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT '用户表';

/*Table structure for table `user_roles` */

CREATE TABLE `user_roles` (
  `ur_id` int(11) NOT NULL,
  `ur_user_id` int(11) DEFAULT NULL,
  `ur_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT '用户角色对应表';


