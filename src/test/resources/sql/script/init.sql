insert  into `roles`(`r_id`,`r_name`,`r_flag`) values (1,'ADMIN','ROLE_ADMIN');
insert  into `roles`(`r_id`,`r_name`,`r_flag`) values (2,'USER','ROLE_USER');

insert  into `users`(`u_id`,`u_username`,`u_password`,`u_last_login`,`u_login_ip`) values (1,'admin','123456',NULL,NULL);
insert  into `users`(`u_id`,`u_username`,`u_password`,`u_last_login`,`u_login_ip`) values (2,'guest','123456',NULL,NULL);

insert  into `user_roles`(`ur_id`,`ur_user_id`,`ur_role_id`) values (1,1,1);
insert  into `user_roles`(`ur_id`,`ur_user_id`,`ur_role_id`) values (2,1,2);
insert  into `user_roles`(`ur_id`,`ur_user_id`,`ur_role_id`) values (3,2,2);