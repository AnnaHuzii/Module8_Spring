
INSERT INTO user(id, first_name, last_name, email, password)
values (UUID(), "admin", "admin", "admin@mail",
        "$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG"),
       (UUID(), "user", "user", "user@mail",
        "$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
;

INSERT INTO role (id, name)
values (UUID(), "ADMIN"),
       (UUID(), "USER")
;

INSERT INTO producer (id, name)
values (UUID(), "Producer A"),
       (UUID(), "Producer B")
;