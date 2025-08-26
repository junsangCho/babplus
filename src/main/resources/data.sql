-- USERS
insert into users (id, password, name, role, enable, created_date, updated_date) values('wnstkddl90','$2a$10$h2uH7sk60HAldUEvJ/0YW.Ki4XxMjpM5wARtphaA/R.UauXu3uUc2','조준상','admin',1,'2025-08-18 13:07:53', '2025-08-18 13:07:59');
insert into users (id, password, name, role, enable, created_date, updated_date) values('hanb123','$2a$10$h2uH7sk60HAldUEvJ/0YW.Ki4XxMjpM5wARtphaA/R.UauXu3uUc2','진한별','admin',1,'2025-08-18 13:08:57', '2025-08-18 13:09:01');


-- STORE
INSERT INTO PUBLIC.STORE (USER_ID, NAME, ADDRESS, HOTLINE, ENABLE, CREATED_DATE, UPDATED_DATE) VALUES ('wnstkddl90', '방배지점', '강남구 방배동', '02-3491-3439', true, '2025-08-19 13:07:53', '2025-08-19 13:07:59');
INSERT INTO PUBLIC.STORE (USER_ID, NAME, ADDRESS, HOTLINE, ENABLE, CREATED_DATE, UPDATED_DATE) VALUES ('wnstkddl90', '학동지점', '강남구 학동', '02-3491-3438', true, '2025-08-19 13:08:57', '2025-08-19 13:09:01');
INSERT INTO PUBLIC.STORE (USER_ID, NAME, ADDRESS, HOTLINE, ENABLE, CREATED_DATE, UPDATED_DATE) VALUES ('hanb123', '창동지점', '노원구 창동', '02-3491-3437', true, '2025-08-19 13:08:57', '2025-08-19 13:09:01');
INSERT INTO PUBLIC.STORE (USER_ID, NAME, ADDRESS, HOTLINE, ENABLE, CREATED_DATE, UPDATED_DATE) VALUES ('hanb123', '상계지점', '강남구 상계동', '02-3491-3436', true, '2025-08-19 13:08:57', '2025-08-19 13:09:01');
INSERT INTO PUBLIC.STORE (USER_ID, NAME, ADDRESS, HOTLINE, ENABLE, CREATED_DATE, UPDATED_DATE) VALUES ('hanb123', '중계지점', '강남구 중계동', '02-3491-3435', true, '2025-08-19 13:08:57', '2025-08-19 13:09:01');