insert into chat.users (login, passwd) VALUES ('rosfryd', '123456');

insert into chat.room (chat_owner, chat_name) VALUES (1, 'chat1');

insert into chat.msgs (room_id, sender, message, time) VALUES (1, 1, 'hello friends', to_timestamp('2017     Aug','YYYY MON'));