insert into role(name_role) values ('director');
insert into role(name_role) values ('senior administrator');
insert into role(name_role) values ('senior metodist');
insert into role(name_role) values ('administrator');

insert into users(name_user, role_id) values ('Sergey', 1);
insert into users(name_user, role_id) values ('Anna', 2);
insert into users(name_user, role_id) values ('Olga', 3);
insert into users(name_user, role_id) values ('Sveta', 4);

insert into rules(name_rule) values ('manage');
insert into rules(name_rule) values ('accountant');
insert into rules(name_rule) values ('manage events');
insert into rules(name_rule) values ('sell ticket');

insert into role_rules(role_id, rule_id) values (1, 1);
insert into role_rules(role_id, rule_id) values (2, 1);
insert into role_rules(role_id, rule_id) values (3, 2);
insert into role_rules(role_id, rule_id) values (4, 3);

insert into category(name_category) values ('management');
insert into category(name_category) values ('sport service');
insert into category(name_category) values ('sales to customers');

insert into state(name_state) values ('working');
insert into state(name_state) values ('on holiday');

insert into item(item_text, user_id, category_id, state_id) values ('manage an organization', 1, 1, 1);
insert into item(item_text, user_id, category_id, state_id) values ('keep accounting', 2, 1, 1);
insert into item(item_text, user_id, category_id, state_id) values ('organization of sporting events', 3, 2, 1);
insert into item(item_text, user_id, category_id, state_id) values ('sale of sports services to clients', 4, 3, 1);

insert into comments(comment, item_id) values ('very good', 1);
insert into comments(comment, item_id) values ('good', 2);
insert into comments(comment, item_id) values ('badly', 3);
insert into comments(comment, item_id) values ('ok', 4);