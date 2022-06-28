delete from hardware;

insert into hardware(id,hardwarename,price,hardwaretype,numberof)
values ('code12','equinox 3D', 250.45, 'CPU', 15);

insert into hardware(id,hardwarename,price,hardwaretype,numberof)
values ('code10','zert onyx gt', 450.5, 'GPU', 3);

insert into hardware(id,hardwarename,price,hardwaretype,numberof)
values ('code11','pio 3fk', 44.8, 'OTHER', 20);

insert into review(id ,reviewtitle ,reviewtext ,grade ,hardware)
values (1,'good product', 'I like this thing they did', 4, 'code12');

insert into review(id ,reviewtitle ,reviewtext ,grade ,hardware)
values (2,'mediocre product', 'Its aight', 3, 'code11');

insert into review(id ,reviewtitle ,reviewtext ,grade ,hardware)
values (3,'bad product', 'hate, hate, HATE this thing, it murdered my whole family', 1, 'code10');

insert into review(id ,reviewtitle ,reviewtext ,grade ,hardware)
values (4,'amazing product', 'looove this thing, it murdered my nemesis and his whole family', 5, 'code11');

insert into user(id, username, password)
values
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'), -- password = admin
    (3, 'creator', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi');
insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER'),
    (3, 'ROLE_CREATOR');
insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1),
    (3,3);