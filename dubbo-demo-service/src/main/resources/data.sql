insert ignore into `t_privilege` (`id`, `name`, `sort_order`)
values ('manage.manage-staffs', '管理职员', 3),
       ('manage.manage-roles', '管理角色', 2),
       ('manage.manage-settings', '管理设置', 1);

insert ignore into `t_staff` (`id`, `username`, `password`, `screen_name`, `avatar`)
values (1, 'admin', '$2a$10$yeygHPKKo6t0F8G7c.j3WOmo3b76AtnKPjI3.gKKgAk.X7ROKrrZO', '管理员', 'static/flutter-logo.png');

insert ignore into `t_role` (`id`, `name`, `description`)
values (1, '超级管理员', '具有系统所有权限');

insert ignore into `t_role_privilege` (`role_id`, `privilege_id`)
select 1, `id`
from `t_privilege`;

insert ignore into `t_staff_role` (`staff_id`, `role_id`)
values (1, 1);